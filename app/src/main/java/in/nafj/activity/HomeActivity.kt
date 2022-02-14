package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityCategoryListingBinding
import `in`.nafj.databinding.ToolbarHomeBinding
import `in`.nafj.databinding.ViewCategorySingleBinding
import `in`.nafj.helper.ListingResponse
import `in`.nafj.helper.RetrofitFunctions
import `in`.nafj.helper.SingleCategoryResponse
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson

private const val TAG = "HomeActivity"
class HomeActivity : AppCompatActivity() {

    interface CategoryInterface {
        fun onCategorySelected(
            position: Int,
            singleCategoryResponse: SingleCategoryResponse,
            categoryName: String
        )
    }

    interface CategoryListingInterface{
        fun onListingSuccess(body: ListingResponse)
        fun onListingFailure()
    }

    private var firebaseToken = ""
    private lateinit var binding: ActivityCategoryListingBinding
    private lateinit var toolbarBinding: ToolbarHomeBinding
    private val categoryList = ArrayList<SingleCategoryResponse>()
    private lateinit var categoryListingAdapter: CategoryListingAdapter
    private lateinit var sharedPreferences: SharedPreferences

    private val categoryInterface = object : CategoryInterface {
        override fun onCategorySelected(
            position: Int,
            singleCategoryResponse: SingleCategoryResponse,
            categoryName: String
        ) {

            Log.i(TAG, "onCategorySelected: single: $singleCategoryResponse")
            val json = Gson().toJson(singleCategoryResponse)
            val intent = Intent(this@HomeActivity, ProductListingActivity::class.java)
            intent.putExtra("singleCategoryResponse", json)
            intent.putExtra("categoryName", categoryName)
            startActivity(intent)
        }

    }

    private val categoryListingInterface = object : CategoryListingInterface {
        override fun onListingSuccess(body: ListingResponse) {
            Log.i(TAG, "onListingSuccess: $body")

            for (categoryDetails in body.categoryDetails) {
                categoryList.add(categoryDetails)
                categoryListingAdapter.notifyItemInserted(categoryList.size)
            }

        }

        override fun onListingFailure() {

        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category_listing)
        toolbarBinding = binding.homeToolbar

        RetrofitFunctions.categoryListing(categoryListingInterface)

        binding.categoryListing.layoutManager =
            GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        categoryListingAdapter = CategoryListingAdapter(categoryList, categoryInterface)
        binding.categoryListing.adapter = categoryListingAdapter

        retrieveToken()

        toolbarBinding.notifications.setOnClickListener {
            val viewProductActivity = Intent(this, NotificationListingActivity::class.java)
            startActivity(viewProductActivity)
        }
        toolbarBinding.shoppingCart.setOnClickListener {
            val viewProductActivity = Intent(this, ViewCartActivity::class.java)
            startActivity(viewProductActivity)
            /*val fragment = RemoveItemOrderList(removeItemInterface)
            fragment.show(supportFragmentManager, TAG)*/
        }

        /*sharedPreferences = application.getSharedPreferences(
            Constants.sharedPrefFile,
            Context.MODE_PRIVATE
        )

        val editor = sharedPreferences.edit()
        editor.putBoolean("loginStatus", true)
        editor.putString("loginNumber", "8898310860")
        editor.apply()*/


    }

    override fun onStop() {
        super.onStop()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    inner class CategoryListingAdapter(
        private var categoryList: ArrayList<SingleCategoryResponse>,
        private val categoryInterface: CategoryInterface
    ) : RecyclerView.Adapter<CategoryListingAdapter.ViewHolder>() {

        inner class ViewHolder(val binding: ViewCategorySingleBinding) :
            RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): CategoryListingAdapter.ViewHolder {
            return ViewHolder(
                ViewCategorySingleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun getItemCount() = categoryList.size

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItemViewType(position: Int): Int {
            return position
        }

        override fun onBindViewHolder(holder: CategoryListingAdapter.ViewHolder, position: Int) {
            with(categoryList[position]) {

                holder.binding.categoryName.text = categoryName

                holder.binding.root.setOnClickListener {

                    

                    categoryInterface.onCategorySelected(holder.adapterPosition, this, categoryName)
                }
            }
        }
    }

    private fun retrieveToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("TAG", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            firebaseToken = task.result
        })
    }

}