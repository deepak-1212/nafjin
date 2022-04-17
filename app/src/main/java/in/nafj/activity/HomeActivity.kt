package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityCategoryListingBinding
import `in`.nafj.databinding.SingleProductSearchViewBinding
import `in`.nafj.databinding.ToolbarHomeBinding
import `in`.nafj.databinding.ViewCategorySingleBinding
import `in`.nafj.helper.*
import `in`.nafj.model.DeviceTokenModel
import `in`.nafj.model.DeviceTokenResponse
import `in`.nafj.model.ViewProductModel
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


private const val TAG = "HomeActivity"

class HomeActivity : AppCompatActivity() {


    interface CategoryInterface {
        fun onCategorySelected(
            position: Int,
            singleCategoryResponse: SingleCategoryResponse,
            categoryName: String
        )
    }

    interface CategoryListingInterface {
        fun onListingSuccess(body: ListingResponse)
        fun onListingFailure()
    }

    interface ProductInterface {
        fun onProductSelected(viewProductModel: ViewProductModel)
    }

    private lateinit var sharedPreferences: SharedPreferences
    private var firebaseToken = ""
    private lateinit var binding: ActivityCategoryListingBinding
    private lateinit var toolbarBinding: ToolbarHomeBinding
    private val categoryList = ArrayList<SingleCategoryResponse>()
    private lateinit var categoryListingAdapter: CategoryListingAdapter
    private lateinit var productAdapter: ProductListingAdapter

    private lateinit var productsListingForSearch: ArrayList<ViewProductModel>

    private val productInterface = object : ProductInterface {
        override fun onProductSelected(viewProductModel: ViewProductModel) {
            Log.i(TAG, "onProductSelected: $viewProductModel")

            val json = Gson().toJson(viewProductModel)
            val intent = Intent(this@HomeActivity, ViewProductActivity::class.java)
            intent.putExtra("singleProductResponse", json)
            startActivity(intent)


        }

    }

    private val categoryInterface = object : CategoryInterface {
        override fun onCategorySelected(
            position: Int,
            singleCategoryResponse: SingleCategoryResponse,
            categoryName: String
        ) {

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
        productsListingForSearch = ArrayList()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category_listing)
        toolbarBinding = binding.homeToolbar
        toolbarBinding.notifications.visibility = View.GONE
        toolbarBinding.shoppingCart.visibility = View.GONE
        setSupportActionBar(toolbarBinding.toolbar)

        sharedPreferences = application.getSharedPreferences(
            Constants.sharedPrefFile,
            Context.MODE_PRIVATE
        )

        RetrofitFunctions.categoryListing(categoryListingInterface)

        binding.categoryListing.layoutManager =
            GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        categoryListingAdapter = CategoryListingAdapter(categoryList, categoryInterface)
        binding.categoryListing.adapter = categoryListingAdapter


        productAdapter = ProductListingAdapter(productsListingForSearch, productInterface)
        binding.productListing.layoutManager = LinearLayoutManager(this)
        binding.productListing.adapter = productAdapter

        retrieveToken()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val menuItem = menu.findItem(R.id.action_search)
        val searchView = menuItem.actionView as SearchView
        searchView.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View?) {
                binding.categoryListing.visibility = View.GONE
                binding.productListing.visibility = View.VISIBLE

            }

            override fun onViewDetachedFromWindow(v: View?) {
                binding.categoryListing.visibility = View.VISIBLE
                binding.productListing.visibility = View.GONE

            }

        })
        searchView.setOnCloseListener {
            Log.i(TAG, "onCreateOptionsMenu: ")
            binding.categoryListing.visibility = View.VISIBLE
            binding.productListing.visibility = View.GONE
            return@setOnCloseListener false
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.i(TAG, "onQueryTextSubmit: ")

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.i(TAG, "onQueryTextChange: ")
//                binding.categoryListing.visibility = View.GONE
//                binding.productListing.visibility = View.VISIBLE
                return false

            }

        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_notifications -> {
                val viewProductActivity = Intent(this, NotificationListingActivity::class.java)
                startActivity(viewProductActivity)
            }

            R.id.action_cart -> {
                val viewProductActivity = Intent(this, ViewCartActivity::class.java)
                startActivity(viewProductActivity)
            }
        }


        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.i(TAG, "onBackPressed: ")
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

//                productsListingForSearch.addAll(categoryProducts)

                for (item in categoryProducts) {
                    productsListingForSearch.add(ViewProductModel(categoryName, item))
                }
                holder.binding.categoryName.text = categoryName
                holder.binding.categoryImage.setImage(categoryImage)

                holder.binding.root.setOnClickListener {
                    categoryInterface.onCategorySelected(holder.adapterPosition, this, categoryName)
                }
            }
        }
    }

    inner class ProductListingAdapter(
        private var categoryList: ArrayList<ViewProductModel>,
        private val productInterface: ProductInterface
    ) : RecyclerView.Adapter<ProductListingAdapter.ViewHolder>() {

        inner class ViewHolder(val binding: SingleProductSearchViewBinding) :
            RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ProductListingAdapter.ViewHolder {
            return ViewHolder(
                SingleProductSearchViewBinding.inflate(
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

        override fun onBindViewHolder(holder: ProductListingAdapter.ViewHolder, position: Int) {
            with(categoryList[position]) {

                holder.binding.productName.text = this.productList.title

                holder.binding.root.setOnClickListener {
                    productInterface.onProductSelected(this)
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
            deviceToken(firebaseToken)
        })
    }

    private fun deviceToken(token: String) {
        Log.i(TAG, "deviceToken token: $token")

        val number = "8898310860"
//        val number = sharedPreferences.getString("loginNumber", "")!!

        val retrofit: Retrofit? = RetrofitClient.getClient()
        val retrofitApi: RetrofitApi = retrofit?.create(RetrofitApi::class.java)!!

        val call = retrofitApi.deviceToken(DeviceTokenModel(number, token))
        call.enqueue(object : Callback<DeviceTokenResponse> {
            override fun onResponse(call: Call<DeviceTokenResponse>, response: Response<DeviceTokenResponse>) {
                Log.i(TAG, "onResponse deviceToken: ${response.body()!!}")
            }

            override fun onFailure(call: Call<DeviceTokenResponse>, t: Throwable) {
                Log.i(TAG, "onFailure deviceToken: ${t.message}")
            }

        })

    }

}