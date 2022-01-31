package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityLoginOtpBinding
import `in`.nafj.helper.GenericTextWatcher
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.bold
import androidx.databinding.DataBindingUtil

private const val TAG = "LoginOtpActivity"

class LoginOtpActivity : AppCompatActivity(), View.OnClickListener {


    private val editTextArray = ArrayList<EditText>()

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

        val passedNumber = intent.getStringExtra("number")
        val boldSpanned = SpannableStringBuilder().bold { append(passedNumber.toString()) }
        binding.submitOtpText.append(boldSpanned)

        binding.nextButton.setOnClickListener(this)
        binding.nextButton.isClickable = false


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.nextButton -> {
                Log.i(TAG, "onClick: $otpEnteredCounter")
                if (otpEnteredCounter.length == 6) {
                    binding.errorOtp.visibility = View.GONE
                } else {
                    binding.errorOtp.visibility = View.VISIBLE
                }
            }
        }
    }
}