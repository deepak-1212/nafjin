package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.database.DatabaseHelper
import `in`.nafj.databinding.ActivityProfileBinding
import `in`.nafj.databinding.ToolbarHomeBinding
import `in`.nafj.helper.Constants
import `in`.nafj.helper.RetrofitFunctions
import `in`.nafj.helper.toast
import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil

interface UpdateProfileInterface {
    fun onUpdateSuccess(
        number: String,
        name: String,
        email: String
    )

    fun onUpdateFailure(message: String)
}

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var toolbarBinding: ToolbarHomeBinding
    private lateinit var progressDialog: ProgressDialog

    private val updateProfileInterface = object : UpdateProfileInterface {
        override fun onUpdateSuccess(
            number: String,
            name: String,
            email: String
        ) {

            val db = DatabaseHelper(this@ProfileActivity)
            db.insertIntoProfile(number, name, email)
            db.close()

            progressDialog.dismiss()

            toast("Profile updated!")
        }

        override fun onUpdateFailure(message: String) {
            binding.errorMessage.text = message
            binding.errorMessage.visibility = View.VISIBLE

            progressDialog.dismiss()
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        toolbarBinding = binding.homeToolbar
        toolbarBinding.notifications.visibility = View.GONE
        toolbarBinding.shoppingCart.visibility = View.GONE

        toolbarBinding.hamburger.setImageDrawable(
            AppCompatResources.getDrawable(
                this,
                R.drawable.back_arrow
            )
        )
        toolbarBinding.hamburger.visibility = View.VISIBLE

        toolbarBinding.hamburger.setOnClickListener {
            onBackPressed()
        }

        progressDialog = ProgressDialog(this)
        progressDialog.setCancelable(false)
        progressDialog.setTitle("updating profile")

        toolbarBinding.headerTextView.text = "Profile Details"
        setData()

        binding.submitProfile.setOnClickListener {
            val name = binding.name.text.toString().trim()
            val number = binding.mobileNo.text.toString().trim()
            val email = binding.emailAddress.text.toString().trim()

            if (name.isEmpty()) {
                binding.name.error = "Field cannot be empty!"
                return@setOnClickListener
            }

            if (number.isEmpty()) {
                binding.mobileNo.error = "Field cannot be empty!"
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                binding.emailAddress.error = "Field cannot be empty!"
                return@setOnClickListener
            }

            if (name.length < 3) {
                binding.name.error = "Invalid name"
                return@setOnClickListener
            }

            if (number.length != 10) {
                binding.mobileNo.error = "Invalid number"
                return@setOnClickListener
            }


            updateProfileDetails(name, number, email)
        }
    }

    private fun setData() {

        val db = DatabaseHelper(this)
        val updateProfileDetailModel = db.getProfileDetails(
            getSharedPreferences(
                Constants.sharedPrefFile,
                Context.MODE_PRIVATE
            ).getString("loginNumber", "")!!
        )
        binding.name.setText(updateProfileDetailModel.name)
        binding.mobileNo.setText(updateProfileDetailModel.number)
        binding.emailAddress.setText(updateProfileDetailModel.email)
        db.close()
    }

    private fun updateProfileDetails(name: String, number: String, email: String) {
        progressDialog.show()
        RetrofitFunctions.updateProfile(number, name, email, updateProfileInterface)
    }
}