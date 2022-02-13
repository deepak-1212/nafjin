package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityOrderListingBinding
import `in`.nafj.databinding.ToolbarHomeBinding
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class OrderListingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderListingBinding
    private lateinit var toolbarHomeBinding: ToolbarHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_listing)
        toolbarHomeBinding = binding.orderListingToolbar

        setSupportActionBar(toolbarHomeBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbarHomeBinding.toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbarHomeBinding.toolbar.setNavigationOnClickListener { onBackPressed() }

        toolbarHomeBinding.notifications.setOnClickListener {
            val viewProductActivity = Intent(this, NotificationListingActivity::class.java)
            startActivity(viewProductActivity)
        }
        toolbarHomeBinding.shoppingCart.setOnClickListener {
            val viewProductActivity = Intent(this, ViewCartActivity::class.java)
            startActivity(viewProductActivity)
        }

    }
}