package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.databinding.ActivitySubCategoryListingBinding
import `in`.nafj.databinding.ViewSubCategorySingleBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class SubCategory(val id: Int, val name: String, val imageUrl: String)

class SubCategoryListingActivity : AppCompatActivity() {

    interface SubCategoryInterface {
        fun onSubCategorySelected(position: Int)
    }

    private lateinit var binding: ActivitySubCategoryListingBinding
    private val subCategoryList = ArrayList<SubCategory>()
    private val subCategoryInterface = object : SubCategoryInterface {
        override fun onSubCategorySelected(position: Int) {

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub_category_listing)

        binding.subCategoryListing.layoutManager =
            GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        binding.subCategoryListing.adapter =
            SubCategoryListingAdapter(subCategoryList, subCategoryInterface)
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }


    inner class SubCategoryListingAdapter(
        private var subCategoryList: ArrayList<SubCategory>,
        private val subCategoryInterface: SubCategoryInterface
    ) : RecyclerView.Adapter<SubCategoryListingAdapter.ViewHolder>() {

        inner class ViewHolder(val binding: ViewSubCategorySingleBinding) :
            RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): SubCategoryListingAdapter.ViewHolder {
            return ViewHolder(
                ViewSubCategorySingleBinding.inflate(
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

        override fun onBindViewHolder(holder: SubCategoryListingAdapter.ViewHolder, position: Int) {
            with(subCategoryList[position]) {

//                holder.binding.categoryImage
                holder.binding.subCategoryName.text = name

                holder.binding.root.setOnClickListener {
                    subCategoryInterface.onSubCategorySelected(holder.adapterPosition)
                }
            }
        }
    }
}