package `in`.nafj.database

import `in`.nafj.helper.SingleProductResponse
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

private const val TAG = "DatabaseHelper"
class DatabaseHelper(private val context: Context) :
    SQLiteOpenHelper(context, "nafjin.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE CartDetails (Id INTEGER PRIMARY KEY, user_number TEXT, product_id INTEGER, product_code TEXT, product_name TEXT, product_price INTEGER, product_description TEXT, product_stock INTEGER, product_order_status Boolean, product_total_count INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.i(TAG, "onUpgrade: $oldVersion > $newVersion")
    }

    fun insertRowInCart(singleProductResponse: SingleProductResponse, userNumber: String?, totalCount: Int): Long {
        val db = writableDatabase
        val sql =
            "insert into CartDetails (user_number, product_id, product_code , product_name, product_description, product_stock, product_order_status,product_total_count, product_price)values (?,?,?,?,?,?,?,?,?);";
        val stmt = db.compileStatement(sql)
        stmt.bindString(1, userNumber)
        stmt.bindString(2, singleProductResponse.postId.toString())
        stmt.bindString(3, singleProductResponse.productDetails._sku)
        stmt.bindString(4, singleProductResponse.title)
        stmt.bindString(5, singleProductResponse.desc)
        stmt.bindString(6, singleProductResponse.productDetails._stock.toString())
        stmt.bindString(7, "false")
        stmt.bindString(8, totalCount.toString())
        stmt.bindString(9, singleProductResponse.productDetails._price.toString())
        val returnValue = stmt.executeInsert()
        stmt.clearBindings()

        return returnValue
    }

    fun getRowsFromCart() {

    }

    fun getProductFromCart(productId: Int): Boolean {
        val db = writableDatabase
        val detailsQuery = "select * from CartDetails where product_id = $productId"
        val c = db.rawQuery(detailsQuery, null)
        if (c.count > 0) {
            return true
        }
        c.close()
        return false
    }

    fun deleteProductFromCart() {

    }

    fun updateProductInCart() {

    }

}