package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityLoginOtpBinding
import `in`.nafj.helper.Constants
import `in`.nafj.helper.GenericTextWatcher
import `in`.nafj.helper.RetrofitFunctions
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.bold
import androidx.databinding.DataBindingUtil
import java.net.NetworkInterface
import java.net.SocketException
import java.util.*

private const val TAG = "LoginOtpActivity"

class LoginOtpActivity : AppCompatActivity(), View.OnClickListener {

    interface SendOtpInterface {
        fun onOtpSent(finalResRandom: String, firebaseToken: String)
        fun onOtpSendingFailed()
    }

    interface CreateRowInServerInterface {
        fun onRowCreated()
        fun onRowCreationFailed()
    }

    interface VerifyOtpInterface {
        fun onOtpVerified()
        fun onOtpVerificationFailed()
    }

    private val editTextArray = ArrayList<EditText>()
    private lateinit var passedNumber: String
    private lateinit var progressDialog: ProgressDialog
    private lateinit var firebaseToken: String
    private lateinit var sharedPreferences: SharedPreferences

    private val sendOtpInterface = object : SendOtpInterface {
        override fun onOtpSent(finalResRandom: String, firebaseToken: String) {
            showProgressBar(false)
            RetrofitFunctions.createRecordInServer(
                passedNumber,
                createRowInServerInterface,
                finalResRandom,
                firebaseToken
            )
        }

        override fun onOtpSendingFailed() {
            showProgressBar(false)
        }

    }

    private val createRowInServerInterface = object : CreateRowInServerInterface {
        override fun onRowCreated() {
            showProgressBar(false)
        }

        override fun onRowCreationFailed() {
            showProgressBar(false)
        }

    }

    private val verifyOtpInterface = object : VerifyOtpInterface {
        override fun onOtpVerified() {

            val editor = sharedPreferences.edit()
            editor.putBoolean("loginStatus", true)
            editor.putString("loginNumber", passedNumber)
            editor.apply()

            showProgressBar(false)
            val intent = Intent(this@LoginOtpActivity, HomeActivity::class.java)

            activityHome.launch(intent)

        }

        override fun onOtpVerificationFailed() {
            showProgressBar(false)
            binding.errorOtp.visibility = View.VISIBLE
        }

    }

    companion object {
        var otpEnteredCounter = ""
        lateinit var binding: ActivityLoginOtpBinding
    }

    private val activityHome =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_otp)

        sharedPreferences = application.getSharedPreferences(
            Constants.sharedPrefFile,
            Context.MODE_PRIVATE
        )

        passedNumber = intent.getStringExtra("number").toString()
        val boldSpanned = SpannableStringBuilder().bold { append(passedNumber) }
        binding.submitOtpText.append(boldSpanned)

        firebaseToken = intent.getStringExtra("firebaseToken")!!

        progressDialog = ProgressDialog(this)
        progressDialog.setCancelable(false)
        progressDialog.setTitle("Sending OTP")

        showProgressBar(true)
        RetrofitFunctions.sendOtp(passedNumber, sendOtpInterface, getString(R.string.app_name), firebaseToken)


        editTextArray.add(binding.otpEditBox1)
        editTextArray.add(binding.otpEditBox2)
        editTextArray.add(binding.otpEditBox3)
        editTextArray.add(binding.otpEditBox4)
        editTextArray.add(binding.otpEditBox5)
        editTextArray.add(binding.otpEditBox6)

        binding.otpEditBox1.addTextChangedListener(
            GenericTextWatcher(
                binding.otpEditBox1,
                editTextArray
            )
        )
        binding.otpEditBox2.addTextChangedListener(
            GenericTextWatcher(
                binding.otpEditBox2,
                editTextArray
            )
        )
        binding.otpEditBox3.addTextChangedListener(
            GenericTextWatcher(
                binding.otpEditBox3,
                editTextArray
            )
        )
        binding.otpEditBox4.addTextChangedListener(
            GenericTextWatcher(
                binding.otpEditBox4,
                editTextArray
            )
        )
        binding.otpEditBox5.addTextChangedListener(
            GenericTextWatcher(
                binding.otpEditBox5,
                editTextArray
            )
        )
        binding.otpEditBox6.addTextChangedListener(
            GenericTextWatcher(
                binding.otpEditBox6,
                editTextArray
            )
        )

        binding.nextButton.setOnClickListener(this)
        binding.nextButton.isClickable = false

        binding.resendOtpButton.setOnClickListener {
            showProgressBar(true)
            RetrofitFunctions.sendOtp(passedNumber, sendOtpInterface, getString(R.string.app_name), firebaseToken)
        }


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.nextButton -> {
                Log.i(TAG, "onClick: $otpEnteredCounter")
                if (otpEnteredCounter.length == 6) {
                    binding.errorOtp.visibility = View.GONE
                    RetrofitFunctions.verifyOtp(passedNumber, verifyOtpInterface, otpEnteredCounter)
                } else {
                    binding.errorOtp.visibility = View.VISIBLE
                }
            }
        }
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
                    for (i in 0 until networkInterface.getHardwareAddress().size) {
                        var stringMacByte = Integer.toHexString(
                            networkInterface.hardwareAddress[i].toInt()
                        )
                        if (stringMacByte.length == 1) {
                            stringMacByte = "0$stringMacByte"
                        }
                        stringMac = stringMac + stringMacByte.toUpperCase() + ":"
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