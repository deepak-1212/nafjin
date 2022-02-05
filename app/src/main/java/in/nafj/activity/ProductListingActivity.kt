package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityProductListingBinding
import `in`.nafj.databinding.ViewProductSingleBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Product(val id: Int, val name: String, val imageUrl: String)

class ProductListingActivity : AppCompatActivity() {

    interface ProductInterface {
        fun onProductSelected(position: Int)
    }
    private lateinit var binding: ActivityProductListingBinding
    private val productList = ArrayList<Product>()
    private val productInterface = object : ProductInterface {
        override fun onProductSelected(position: Int) {

        }


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_listing)

        binding.productListing.layoutManager =
            GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        binding.productListing.adapter =
            ProductListAdapter(productList, productInterface)

    }

    override fun onStop() {
        super.onStop()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


    inner class ProductListAdapter(
        private var subCategoryList: ArrayList<Product>,
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

//                holder.binding.categoryImage
                holder.binding.productName.text = name

                holder.binding.root.setOnClickListener {
                    productInterface.onProductSelected(holder.adapterPosition)
                }
            }
        }
    }
    
}