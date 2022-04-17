package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityProductListingBinding
import `in`.nafj.databinding.ToolbarHomeBinding
import `in`.nafj.databinding.ViewProductSingleBinding
import `in`.nafj.helper.SingleCategoryResponse
import `in`.nafj.helper.SingleProductResponse
import `in`.nafj.helper.setImage
import `in`.nafj.helper.toast
import `in`.nafj.model.ViewProductModel
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

private const val TAG = "ProductListing"

class ProductListingActivity : AppCompatActivity() {

    interface ProductInterface {
        fun onProductSelected(position: Int, singleProductResponse: SingleProductResponse)
    }

    private lateinit var binding: ActivityProductListingBinding
    private lateinit var toolbarBinding: ToolbarHomeBinding
    private lateinit var productListAdapter: ProductListAdapter
    private val productList = ArrayList<SingleProductResponse>()

    private lateinit var categoryName: String

    private val productInterface = object : ProductInterface {
        override fun onProductSelected(
            position: Int,
            singleProductResponse: SingleProductResponse
        ) {

            val json = Gson().toJson(ViewProductModel(categoryName, singleProductResponse))
            val intent = Intent(this@ProductListingActivity, ViewProductActivity::class.java)
            intent.putExtra("singleProductResponse", json)
            startActivity(intent)
        }


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_listing)
        toolbarBinding = binding.productListingToolbar

        val json = intent.getStringExtra("singleCategoryResponse")
        val singleCategoryResponse = Gson().fromJson(json, SingleCategoryResponse::class.java)
        categoryName = intent.getStringExtra("categoryName")!!

        toolbarBinding.headerTextView.text = categoryName

        setSupportActionBar(toolbarBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbarBinding.toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbarBinding.toolbar.setNavigationOnClickListener { onBackPressed() }

        binding.productListing.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        productListAdapter = ProductListAdapter(productList, productInterface)
        binding.productListing.adapter = productListAdapter

        productList.addAll(singleCategoryResponse.categoryProducts)
        productListAdapter.notifyItemRangeInserted(0, productList.size)

        if (productList.isEmpty()) {
            toast("Products not available!")
        }

        toolbarBinding.notifications.setOnClickListener {
            val viewProductActivity = Intent(this, NotificationListingActivity::class.java)
            startActivity(viewProductActivity)
        }
        toolbarBinding.shoppingCart.setOnClickListener {
            val viewProductActivity = Intent(this, ViewCartActivity::class.java)
            startActivity(viewProductActivity)
        }

    }


    inner class ProductListAdapter(
        private var subCategoryList: ArrayList<SingleProductResponse>,
        private val productInterface: ProductInterface
    ) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

        inner class ViewHolder(val binding: ViewProductSingleBinding) :
            RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ProductListAdapter.ViewHolder {
            return ViewHolder(
                ViewProductSingleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun getItemCount() = subCategoryList.size

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItemViewType(position: Int): Int {
            return position
        }

        override fun onBindViewHolder(holder: ProductListAdapter.ViewHolder, position: Int) {
            with(subCategoryList[position]) {

                holder.binding.productName.text = title
                holder.binding.productImage.setImage(this.image)

                holder.binding.root.setOnClickListener {
                    productInterface.onProductSelected(holder.adapterPosition, this)
                }
            }
        }
    }

}