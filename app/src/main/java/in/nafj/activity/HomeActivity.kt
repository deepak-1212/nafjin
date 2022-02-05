package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivityCategoryListingBinding
import `in`.nafj.databinding.ViewCategorySingleBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Category(val id: Int, val name: String, val imageUrl: String)

class HomeActivity : AppCompatActivity() {

    interface CategoryInterface {
        fun onCategorySelected(position: Int)
    }

    private lateinit var binding: ActivityCategoryListingBinding
    private val categoryList = ArrayList<Category>()
    private val categoryInterface = object : CategoryInterface {
        override fun onCategorySelected(position: Int) {

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category_listing)

        binding.categoryListing.layoutManager =
            GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        binding.categoryListing.adapter = CategoryListingAdapter(categoryList, categoryInterface)

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

}