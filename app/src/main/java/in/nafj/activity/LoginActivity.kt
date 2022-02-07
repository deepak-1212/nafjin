package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityLoginBinding
import `in`.nafj.helper.Constants
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import java.net.NetworkInterface
import java.net.SocketException
import java.util.*

private const val TAG = "LoginActivity"

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private var firebaseToken = ""
    private val activityLoginActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val rePassedNumber = it.data?.getStringExtra("number")
                binding.mobileNo.setText(rePassedNumber.toString())
            }
        }

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        FirebaseApp.initializeApp(this)
        retrieveToken()

        sharedPreferences = application.getSharedPreferences(
            Constants.sharedPrefFile,
            Context.MODE_PRIVATE
        )

        binding.nextButton.setOnClickListener(this)
        val loginStatus = sharedPreferences.getBoolean("loginStatus", false)
        if (loginStatus) {
            val editor = sharedPreferences.edit()
            editor.putString("firebaseToken", firebaseToken)
            editor.apply()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.nextButton -> {
                if (binding.mobileNo.text?.length == 10) {
                    Log.i(TAG, "onClick: ${binding.mobileNo.text}")
                    val intent = Intent(this, LoginOtpActivity::class.java)
                    intent.putExtra("number", binding.mobileNo.text.toString())
                    intent.putExtra("firebaseToken", firebaseToken)
                    activityLoginActivity.launch(intent)
                } else {
                    binding.mobileNo.error = "Please enter a correct number"
                }
            }
        }
    }

    private fun retrieveToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("TAG", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            firebaseToken = task.result
        })
    }

    fun getMacAddress(): String {
        try {
            val networkInterfaceList: List<NetworkInterface> =
                Collections.list(NetworkInterface.getNetworkInterfaces())
            var stringMac = ""
            for (networkInterface in networkInterfaceList) {
                if (networkInterface.name.contains("wlon0", true))
                    run {
                        for (i in 0 until networkInterface.hardwareAddress.size) {
                            var stringMacByte = Integer.toHexString(
                                networkInterface.hardwareAddress[i].toInt()
                            )
                            if (stringMacByte.length == 1) {
                                stringMacByte = "0$stringMacByte"
                            }
                            stringMac =
                                stringMac + stringMacByte.uppercase(Locale.getDefault()) + ":"
                        }
                    }
            }
            return stringMac
        } catch (e: SocketException) {
            e.printStackTrace()
        }
        return "0"
    }
}