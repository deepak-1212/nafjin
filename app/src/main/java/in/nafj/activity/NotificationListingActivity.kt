package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityNotificationListingBinding
import `in`.nafj.databinding.ToolbarHomeBinding
import `in`.nafj.databinding.ViewNotificationSingleBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class NotificationsDataModel(val notificationName: String, val notificationProductId: Int, val notificationProductCategory: String, val notificationTime: String)

private const val TAG = "Notifications"
class NotificationListingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationListingBinding
    private lateinit var toolbarHomeBinding: ToolbarHomeBinding
    private val notificationList = ArrayList<NotificationsDataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification_listing)
        toolbarHomeBinding = binding.notificationListingToolbar

        setSupportActionBar(toolbarHomeBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbarHomeBinding.toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbarHomeBinding.toolbar.setNavigationOnClickListener { onBackPressed() }

        toolbarHomeBinding.shoppingCart.visibility = View.GONE
        toolbarHomeBinding.notifications.visibility = View.GONE
        toolbarHomeBinding.headerTextView.text = "Notifications"

        notificationList.add(NotificationsDataModel("Abcd", 123, "pendant", "2 days ago"))
        notificationList.add(NotificationsDataModel("edgh", 124, "Jwellery set", "1 days ago"))

        val notificationAdapter = NotificationAdapter()
        binding.notificationList.layoutManager = LinearLayoutManager(this)
        binding.notificationList.adapter = notificationAdapter

    }

    inner class NotificationAdapter() : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

        inner class ViewHolder(val binding: ViewNotificationSingleBinding): RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                ViewNotificationSingleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            with(notificationList[position]) {
                holder.binding.productName.text = this.notificationName
                holder.binding.productCode.text = this.notificationProductCategory
                holder.binding.productNotificationTime.text = this.notificationTime

            }
        }

        override fun getItemCount() = notificationList.size


    }

}