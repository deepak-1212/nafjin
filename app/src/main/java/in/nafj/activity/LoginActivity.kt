package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityLoginBinding
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

private const val TAG = "LoginActivity"

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private val activityLoginActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val rePassedNumber = it.data?.getStringExtra("number")
                binding.mobileNo.setText(rePassedNumber.toString())
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)


        binding.nextButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.nextButton -> {
                if (binding.mobileNo.text?.length == 10) {
                    Log.i(TAG, "onClick: ${binding.mobileNo.text}")
                    val intent = Intent(this, LoginOtpActivity::class.java)
                    intent.putExtra("number", binding.mobileNo.text.toString())
                    activityLoginActivity.launch(intent)
                } else {
                    binding.mobileNo.error = "Please enter a correct number"
                }
            }
        }
    }
}