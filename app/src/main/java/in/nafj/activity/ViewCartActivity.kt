package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityViewCartBinding
import `in`.nafj.databinding.ToolbarHomeBinding
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class ViewCartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewCartBinding
    private lateinit var toolbarHomeBinding: ToolbarHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_cart)
        toolbarHomeBinding = binding.viewCartToolbar

        setSupportActionBar(toolbarHomeBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbarHomeBinding.toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbarHomeBinding.toolbar.setNavigationOnClickListener { onBackPressed() }

        toolbarHomeBinding.shoppingCart.visibility = View.GONE
        toolbarHomeBinding.headerTextView.text = "Cart"

        toolbarHomeBinding.notifications.setOnClickListener {
            val viewProductActivity = Intent(this, NotificationListingActivity::class.java)
            startActivity(viewProductActivity)
        }

    }
}