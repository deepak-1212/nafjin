package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.database.DatabaseHelper
import `in`.nafj.databinding.ActivityViewProductBinding
import `in`.nafj.databinding.ToolbarHomeBinding
import `in`.nafj.helper.Constants
import `in`.nafj.helper.SingleProductResponse
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.gson.Gson

private const val TAG = "ViewProduct"

class ViewProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewProductBinding
    private lateinit var toolbarHomeBinding: ToolbarHomeBinding
    private lateinit var categoryName: String
    private var productPrice = 0
    private var totalQuantityCount = 1
    private lateinit var db: DatabaseHelper
    private var productPresentInCart = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_product)
        toolbarHomeBinding = binding.viewProductToolbar

        val json = intent.getStringExtra("singleProductResponse")
        val singleProductResponse = Gson().fromJson(json, SingleProductResponse::class.java)
        categoryName = intent.getStringExtra("categoryName")!!

        setSupportActionBar(toolbarHomeBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbarHomeBinding.toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbarHomeBinding.toolbar.setNavigationOnClickListener { onBackPressed() }

        toolbarHomeBinding.headerTextView.text = categoryName

        setView(singleProductResponse)

        toolbarHomeBinding.notifications.setOnClickListener {
            val viewProductActivity = Intent(this, NotificationListingActivity::class.java)
            startActivity(viewProductActivity)
        }
        toolbarHomeBinding.shoppingCart.setOnClickListener {
            val viewProductActivity = Intent(this, ViewCartActivity::class.java)
            startActivity(viewProductActivity)
        }

        binding.addQuantity.setOnClickListener {
            totalQuantityCount++
            setTotalCount()
            setTotalAmount(calculateTotal())
        }

        binding.subtractQuantity.setOnClickListener {
            if (totalQuantityCount > 1) {
                totalQuantityCount--
                setTotalCount()
                setTotalAmount(calculateTotal())
            }
        }

        binding.addToCart.setOnClickListener {
            if (!productPresentInCart) {
                db = DatabaseHelper(this)
                val userNumber = getSharedPreferences(Constants.sharedPrefFile, Context.MODE_PRIVATE).getString("loginNumber", "")
                val recordVal = db.insertRowInCart(singleProductResponse, userNumber, totalQuantityCount)

                if (recordVal > 0) {
                    Toast.makeText(this, "Item added to cart!", Toast.LENGTH_SHORT).show()
                    binding.addToCart.text = "Go to Cart"
                    productPresentInCart = true
                }

            } else {
                val viewProductActivity = Intent(this, ViewCartActivity::class.java)
                startActivity(viewProductActivity)
            }

        }

        db = DatabaseHelper(this)
        productPresentInCart = db.getProductFromCart(singleProductResponse.postId)
        if (productPresentInCart ) {
            binding.addToCart.text = "Go to Cart"
        }

    }

    private fun setView(singleProductResponse: SingleProductResponse) {
        val jsonObject = singleProductResponse.productDetails
        val productCode = jsonObject._sku
        productPrice = jsonObject._price
        val productStockCount = jsonObject._stock

        setTotalCount()
        setTotalAmount(calculateTotal())
        binding.viewProductName.text = "$productCode - ${singleProductResponse.title}"
        binding.viewProductCategory.text = categoryName
        binding.viewProductDescription.text = singleProductResponse.desc
//        binding.viewProductPrice.text = productPrice.toString()
    }

    private fun calculateTotal() = totalQuantityCount.times(productPrice)
    private fun setTotalCount() {
        binding.totalQuantityText.text = totalQuantityCount.toString()
    }
    private fun setTotalAmount(calculateTotal: Int) {
        binding.totalQuantityValue.text = calculateTotal.toString()
    }

}