package `in`.nafj.helper

import `in`.nafj.R
import `in`.nafj.activity.LoginOtpActivity
import android.text.Editable
import android.text.SpannableString
import android.text.SpannedString
import android.text.TextWatcher
import android.view.View
import android.widget.EditText


class GenericTextWatcher(
    private val editText: EditText,
    private val editTextView: ArrayList<EditText>
) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        val text = s.toString()
        when (editText.id) {
            R.id.otp_edit_box1 -> {
                if (text.length == 1) {
                    editTextView[1].requestFocus()
                }
            }
            R.id.otp_edit_box2 -> {
                if (text.length == 1) {
                    editTextView[2].requestFocus()
                } else
                    editTextView[0].requestFocus()
            }
            R.id.otp_edit_box3 -> {
                if (text.length == 1) {
                    editTextView[3].requestFocus()
                } else
                    editTextView[1].requestFocus()
            }
            R.id.otp_edit_box4 -> {
                if (text.length == 1) {
                    editTextView[4].requestFocus()
                } else
                    editTextView[2].requestFocus()
            }
            R.id.otp_edit_box5 -> {
                if (text.length == 1) {
                    editTextView[5].requestFocus()
                } else
                    editTextView[3].requestFocus()
            }
            R.id.otp_edit_box6 -> {
                if (text.isEmpty()) {
                    editTextView[4].requestFocus()
                } else {
                    LoginOtpActivity.binding.errorOtp.visibility = View.GONE
                    LoginOtpActivity.binding.nextButton.isClickable = true
                }
            }
        }
        LoginOtpActivity.otpEnteredCounter = ""
        val textString = StringBuffer()
        for (item in editTextView) {
            textString.append(item.text)
        }
        LoginOtpActivity.otpEnteredCounter = textString.toString()

    }
}