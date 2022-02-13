package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityNotificationListingBinding
import `in`.nafj.databinding.ToolbarHomeBinding
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class NotificationListingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationListingBinding
    private lateinit var toolbarHomeBinding: ToolbarHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification_listing)
        toolbarHomeBinding = binding.notificationListingToolbar

        setSupportActionBar(toolbarHomeBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbarHomeBinding.toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbarHomeBinding.toolbar.setNavigationOnClickListener { onBackPressed() }

        toolbarHomeBinding.notifications.visibility = View.GONE
        toolbarHomeBinding.headerTextView.text = "Notifications"

        toolbarHomeBinding.shoppingCart.setOnClickListener {
            val viewProductActivity = Intent(this, ViewCartActivity::class.java)
            startActivity(viewProductActivity)
        }
    }

}