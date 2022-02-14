package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.database.DatabaseHelper
import `in`.nafj.databinding.ActivityViewCartBinding
import `in`.nafj.databinding.ToolbarHomeBinding
import `in`.nafj.databinding.ViewCartSingleBinding
import `in`.nafj.sheets.RemoveItemOrderList
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class ViewCartDataModel(
    val id: Int = -1,
    val userNumber: String = "",
    val productId: String = "",
    val productCode: String = "",
    val productName: String = "",
    val productPrice: Int = -1,
    val productDesc: String = "",
    val productStock: Int = -1,
    var productCartCount: Int = -1,
    val productCartPrice: Int = -1,
    val productCategory: String = ""
)

private const val TAG = "ViewCart"

class ViewCartActivity : AppCompatActivity() {

    interface RemoveItemInterface {
        fun onRemoveSelected(position: Int, viewCartDataModel: ViewCartDataModel)
        fun onRemoveCancelled()
    }

    private val removeItemInterface = object : RemoveItemInterface {
        override fun onRemoveSelected(position: Int, viewCartDataModel: ViewCartDataModel) {
            Log.i(TAG, "onRemoveSelected: remove item selected")
            Log.i(TAG, "onRemoveSelected: remove item selected position: $position")
            Log.i(TAG, "onRemoveSelected: remove item selected viewCartDataModel: $viewCartDataModel")

            val index = cartList.indexOf(viewCartDataModel)
            cartList.remove(viewCartDataModel)
            viewCartAdapter.notifyItemRemoved(index)

            totalCartValue -= viewCartDataModel.productCartPrice
            binding.totalAmount.text = totalCartValue.toString()

            val db = DatabaseHelper(this@ViewCartActivity)
            val deletedCount = db.deleteProductFromCart(viewCartDataModel.id)
            db.close()
            Log.i(TAG, "onRemoveSelected deletedCount: $deletedCount")
        }

        override fun onRemoveCancelled() {
            Log.i(TAG, "onRemoveCancelled")
        }

    }

    private lateinit var binding: ActivityViewCartBinding
    private lateinit var toolbarHomeBinding: ToolbarHomeBinding
    private val cartList = ArrayList<ViewCartDataModel>()
    private lateinit var viewCartAdapter: ViewCartAdapter
    private var totalCartValue = 0

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
        toolbarHomeBinding.notifications.visibility = View.GONE
        toolbarHomeBinding.headerTextView.text = "Cart"

        binding.viewCartRecycler.layoutManager = LinearLayoutManager(this)
        viewCartAdapter = ViewCartAdapter()

        val db = DatabaseHelper(this)
        val cursor = db.getRowsFromCart()
        if (cursor.count > 0) {
            binding.noOrders.visibility = View.GONE

            if (cursor.moveToFirst()) {
                do {
                    calculateTotalCartValue(cursor.getInt(9), cursor.getInt(5))
                    cartList.add(
                        ViewCartDataModel(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            cursor.getInt(5),
                            cursor.getString(6),
                            cursor.getInt(7),
                            cursor.getInt(9),
                            cursor.getInt(9).times(cursor.getInt(5)),
                            cursor.getString(10)
                        )
                    )
                } while (cursor.moveToNext())
            }
            cursor.close()

            binding.viewCartRecycler.adapter = viewCartAdapter
            binding.totalAmount.text = totalCartValue.toString()


        } else {
            binding.noOrders.visibility = View.VISIBLE
        }

    }

    inner class ViewCartAdapter() : RecyclerView.Adapter<ViewCartAdapter.ViewHolder>() {

        inner class ViewHolder(val binding: ViewCartSingleBinding) :
            RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ViewCartAdapter.ViewHolder {
            return ViewHolder(
                ViewCartSingleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: ViewCartAdapter.ViewHolder, position: Int) {
            with(cartList[position]) {
                holder.binding.productName.text = productName
                holder.binding.categoryName.text = productCategory
                holder.binding.totalQuantityText.text = productCartCount.toString()
                holder.binding.totalQuantityValue.text = productCartPrice.toString()

                holder.binding.removeItem.setOnClickListener {
                    val fragment = RemoveItemOrderList(removeItemInterface, position, this)
                    fragment.show(supportFragmentManager, TAG)
                }

                holder.binding.addQuantity.setOnClickListener {
                    productCartCount++
                    setTotalCount(holder.binding.totalQuantityText, productCartCount)
                    setTotalAmount(holder.binding.totalQuantityValue, calculateTotal(productCartCount, productPrice))
                    calculateTotalCartValue(1, productPrice)
                }

                holder.binding.subtractQuantity.setOnClickListener {
                    if (productCartCount > 1) {
                        productCartCount--
                        setTotalCount(holder.binding.totalQuantityText, productCartCount)
                        setTotalAmount(holder.binding.totalQuantityValue, calculateTotal(productCartCount, productPrice))
                        calculateTotalCartValue(-1, productPrice)
                    }
                }

            }
        }

        override fun getItemCount() = cartList.size


    }

    private fun calculateTotalCartValue(requiredStock: Int, productPrice: Int) {
        totalCartValue += requiredStock.times(productPrice)
        binding.totalAmount.text = totalCartValue.toString()
    }

    private fun calculateTotal(totalQuantityCount: Int, productPrice: Int) = totalQuantityCount.times(productPrice)
    private fun setTotalCount(view: TextView, totalQuantityCount: Int) {
        view.text = totalQuantityCount.toString()
    }
    private fun setTotalAmount(view: TextView, calculateTotal: Int) {
        view.text = calculateTotal.toString()
    }

}