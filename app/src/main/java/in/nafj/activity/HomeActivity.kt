package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityCategoryListingBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryListingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category_listing)



    }

    override fun onStop() {
        super.onStop()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}