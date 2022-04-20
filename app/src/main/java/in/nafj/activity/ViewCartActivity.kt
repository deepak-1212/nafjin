package `in`.nafj.activity

import `in`.nafj.R
import `in`.nafj.database.DatabaseHelper
import `in`.nafj.databinding.ActivityViewCartBinding
import `in`.nafj.databinding.ToolbarHomeBinding
import `in`.nafj.databinding.ViewCartSingleBinding
import `in`.nafj.helper.Constants
import `in`.nafj.helper.setImage
import `in`.nafj.helper.toast
import `in`.nafj.sheets.RemoveItemOrderList
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*


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
    val productCategory: String = "",
    val productImage: String = ""
)

private const val TAG = "ViewCart"

class ViewCartActivity : AppCompatActivity() {

    interface RemoveItemInterface {
        fun onRemoveSelected(position: Int, viewCartDataModel: ViewCartDataModel)
        fun onRemoveCancelled()
    }

    private val removeItemInterface = object : RemoveItemInterface {
        override fun onRemoveSelected(position: Int, viewCartDataModel: ViewCartDataModel) {
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
    private lateinit var sharedPreferences: SharedPreferences
    private var number = ""

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

        sharedPreferences = application.getSharedPreferences(
            Constants.sharedPrefFile,
            Context.MODE_PRIVATE
        )

        binding.viewCartRecycler.layoutManager = LinearLayoutManager(this)
        viewCartAdapter = ViewCartAdapter()

        val db = DatabaseHelper(this)
        val cursor = db.getRowsFromCart()
        if (cursor.count > 0) {
            binding.noItemInCart.visibility = View.GONE
            binding.placeOrderBottom.visibility = View.VISIBLE

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
                            cursor.getString(10),
                            cursor.getString(11)
                        )
                    )
                } while (cursor.moveToNext())
            }
            cursor.close()

            binding.viewCartRecycler.adapter = viewCartAdapter
            binding.totalAmount.text = totalCartValue.toString()

            binding.placeOrderButton.setOnClickListener {

//                val number = sharedPreferences.getString("loginNumber", "")!!
                number = "8898310860"

                val db1 = DatabaseHelper(this)
                Log.i(TAG, "onCreate: ${db1.checkNamePresent(number)}")
                if (db1.checkNamePresent(number)) {
                    placeOrderProcess()
                } else {
                    showNamePopup()
                }

            }

        } else {
            binding.noItemInCart.visibility = View.VISIBLE
            binding.placeOrderBottom.visibility = View.GONE
        }

    }

    private fun showNamePopup() {
        val builder = AlertDialog.Builder(this)
        builder.setView(R.layout.enter_name)

        val alertDialog: AlertDialog = builder.create()
        alertDialog.window!!.setBackgroundDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.white_box_without_border
            )
        )
        alertDialog.show()
        val back = ColorDrawable(Color.TRANSPARENT)
        val inset = InsetDrawable(back, 50)
        alertDialog.window!!.setBackgroundDrawable(inset)

        val editText =
            alertDialog.findViewById<AppCompatEditText>(R.id.nameEnter) as AppCompatEditText
        val submitName =
            alertDialog.findViewById<AppCompatButton>(R.id.submitName) as AppCompatButton

        submitName.setOnClickListener {
            if (editText.text.toString().trim().isNotEmpty()) {
                alertDialog.dismiss()
                val db = DatabaseHelper(this)
                db.insertIntoProfile(number, editText.text.toString().trim())
                if (db.checkNamePresent(number)) {
                    placeOrderProcess()
                } else {
                    showNamePopup()
                }
                db.close()
            } else {
                toast("Name cannot be black")
            }

        }

    }

    private fun placeOrderProcess() {
        val message = StringBuilder()
        val db = DatabaseHelper(this)
        val profileName = db.getProfileName(number)

        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat.getDateTimeInstance() //or use getDateInstance()
        val formattedDate = formatter.format(date)
        for (item in cartList) {
            message.append("Name: $profileName\n")
            message.append("Date: $formattedDate\n")
            message.append("Item: ${item.productId} - ${item.productName}\n")
            message.append("Rate: ${item.productPrice}\n")
            message.append("Image: ${item.productImage}\n")
            message.append("Quantity: ${item.productCartCount}\n")
            message.append("Mobile Number: $number\n\n")
        }
        Log.i(TAG, "placeOrderProcess: $message")
        try {
            val toNumber = "919892710566" // Replace with mobile phone number without +Sign or leading zeros, but with country code
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber&text=${message.trim()}")
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        /*try {
            val sendIntent = Intent("android.intent.action.MAIN")
            sendIntent.putExtra("jid", "$toNumber@s.whatsapp.net")
            sendIntent.putExtra(Intent.EXTRA_TEXT, message.toString())
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.setPackage("com.whatsapp")
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        } catch (e: Exception) {
        }*/

        val db2 = DatabaseHelper(this)
        db2.clearCart(number)
        db2.close()

        cartList.clear()
        viewCartAdapter.notifyDataSetChanged()

        binding.noItemInCart.visibility = View.VISIBLE
        binding.placeOrderBottom.visibility = View.GONE

    }

    private fun whatsappInstalledOrNot(uri: String): Boolean {
        val pm = packageManager
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {
        }
        return false
    }

    inner class ViewCartAdapter : RecyclerView.Adapter<ViewCartAdapter.ViewHolder>() {

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
                holder.binding.cartItemImage.setImage(productImage)

                holder.binding.removeItem.setOnClickListener {
                    val fragment = RemoveItemOrderList(removeItemInterface, position, this)
                    fragment.show(supportFragmentManager, TAG)
                }

                holder.binding.addQuantity.setOnClickListener {
                    productCartCount++
                    setTotalCount(holder.binding.totalQuantityText, productCartCount)
                    setTotalAmount(
                        holder.binding.totalQuantityValue,
                        calculateTotal(productCartCount, productPrice)
                    )
                    calculateTotalCartValue(1, productPrice)
                    val db = DatabaseHelper(this@ViewCartActivity)
                    db.updateCartProduct(this, productCartCount)
                    db.close()
                }

                holder.binding.subtractQuantity.setOnClickListener {
                    if (productCartCount > 1) {
                        productCartCount--
                        setTotalCount(holder.binding.totalQuantityText, productCartCount)
                        setTotalAmount(
                            holder.binding.totalQuantityValue,
                            calculateTotal(productCartCount, productPrice)
                        )
                        calculateTotalCartValue(-1, productPrice)
                    }
                    val db = DatabaseHelper(this@ViewCartActivity)
                    db.updateCartProduct(this, productCartCount)
                    db.close()
                }

            }
        }

        override fun getItemCount() = cartList.size


    }

    private fun calculateTotalCartValue(requiredStock: Int, productPrice: Int) {
        totalCartValue += requiredStock.times(productPrice)
        binding.totalAmount.text = totalCartValue.toString()
    }

    private fun calculateTotal(totalQuantityCount: Int, productPrice: Int) =
        totalQuantityCount.times(productPrice)

    private fun setTotalCount(view: TextView, totalQuantityCount: Int) {
        view.text = totalQuantityCount.toString()
    }

    private fun setTotalAmount(view: TextView, calculateTotal: Int) {
        view.text = calculateTotal.toString()
    }

}