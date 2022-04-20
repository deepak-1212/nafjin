package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.database.DatabaseHelper
import `in`.nafj.databinding.ActivityLoginBinding
import `in`.nafj.helper.Constants
import `in`.nafj.helper.RetrofitFunctions
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.databinding.DataBindingUtil
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import java.net.NetworkInterface
import java.net.SocketException
import java.util.*

private const val TAG = "LoginActivity"

interface LoginWithPasswordInterface {
    fun onLoginSuccess(number: String, name: String, email: String)
    fun onLoginFailure(message: String)
}

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val loginWithPasswordInterface = object : LoginWithPasswordInterface {
        override fun onLoginSuccess(number: String, name: String, email: String) {
            val db = DatabaseHelper(this@LoginActivity)
            db.insertIntoProfile(number, name, email)
            db.close()
            showProgressBar(false)

            val editor = sharedPreferences.edit()
            editor.putBoolean("loginStatus", true)
            editor.putString("loginNumber", number)
            editor.apply()

            showProgressBar(false)
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        override fun onLoginFailure(message: String) {
            showProgressBar(false)
            Log.i(TAG, "onLoginFailure: $message")
            binding.emptyPassword.visibility = View.VISIBLE
            binding.emptyPassword.text = message
        }

    }

    private lateinit var binding: ActivityLoginBinding
    private lateinit var progressDialog: ProgressDialog
    private var firebaseToken = ""

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        FirebaseApp.initializeApp(this)
        DatabaseHelper(this).writableDatabase
        retrieveToken()

        sharedPreferences = application.getSharedPreferences(
            Constants.sharedPrefFile,
            Context.MODE_PRIVATE
        )

        binding.submitLogin.setOnClickListener(this)
        createNotificationChannel()

//        val loginStatus = true
        val loginStatus = sharedPreferences.getBoolean("loginStatus", false)
        if (loginStatus) {
            val editor = sharedPreferences.edit()
            editor.putString("firebaseToken", firebaseToken)
            editor.apply()
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                "Nafj_All",
                "All Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true)
            notificationChannel.enableVibration(true)
            notificationChannel.description = "All the notifications will be shown in this category"
            notificationChannel.lockscreenVisibility = NotificationCompat.VISIBILITY_PUBLIC


            (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(
                notificationChannel
            )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.submitLogin -> {

                binding.emptyPassword.visibility = View.GONE
                val number = binding.mobileNo.text.toString().trim()
                val password = binding.passwordLogin.text.toString().trim()
                if (number.isEmpty()) {
                    binding.mobileNo.error = "Mobile number cannot be empty"
                    return
                }

                if (password.isEmpty()) {
                    binding.passwordLogin.error = "Password cannot be empty"
                    return
                }

                if (number.length != 10) {
                    binding.mobileNo.error = "Invalid number, please enter a mobile number"
                    return
                }

                if (password.length < 6) {
                    binding.passwordLogin.error = "Password must be at least 6 characters long"
                    return
                }
                progressDialog = ProgressDialog(this)
                progressDialog.setCancelable(false)
                progressDialog.setTitle("Logging in")
                progressDialog.show()


                RetrofitFunctions.loginWithPassword(
                    number,
                    password,
                    loginWithPasswordInterface,
                    firebaseToken
                )
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

    private fun showProgressBar(status: Boolean) {
        if (status) {
            progressDialog.show()
        } else {
            progressDialog.dismiss()
        }
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