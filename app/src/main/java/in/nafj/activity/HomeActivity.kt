package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityCategoryListingBinding
import `in`.nafj.databinding.ViewCategorySingleBinding
import `in`.nafj.helper.ListingResponse
import `in`.nafj.helper.RetrofitFunctions
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

data class Category(val id: Int, val name: String, val imageUrl: String)

private const val TAG = "HomeActivity"
class HomeActivity : AppCompatActivity() {

    interface CategoryInterface {
        fun onCategorySelected(position: Int)
    }

    interface CategoryListingInterface{
        fun onListingSuccess(body: ListingResponse)
        fun onListingFailure()
    }

    private var firebaseToken = ""
    private lateinit var binding: ActivityCategoryListingBinding
    private val categoryList = ArrayList<Category>()
    private val categoryInterface = object : CategoryInterface {
        override fun onCategorySelected(position: Int) {

        }

    }

    private val categoryListingInterface = object : CategoryListingInterface {
        override fun onListingSuccess(body: ListingResponse) {
            Log.i(TAG, "onListingSuccess: $body")
        }

        override fun onListingFailure() {

        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category_listing)

        RetrofitFunctions.categoryListing(categoryListingInterface)

        binding.categoryListing.layoutManager =
            GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        binding.categoryListing.adapter = CategoryListingAdapter(categoryList, categoryInterface)

        retrieveToken()

    }

    override fun onStop() {
        super.onStop()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    inner class CategoryListingAdapter(
        private var categoryList: ArrayList<Category>,
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

//                holder.binding.categoryImage
                holder.binding.categoryName.text = name

                holder.binding.root.setOnClickListener {
                    categoryInterface.onCategorySelected(holder.adapterPosition)
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