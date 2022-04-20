package `in`.nafj.database

import `in`.nafj.activity.NotificationsDataModel
import `in`.nafj.activity.ViewCartDataModel
import `in`.nafj.helper.SingleProductResponse
import `in`.nafj.model.ProfileDetails
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

private const val TAG = "DatabaseHelper"
class DatabaseHelper(private val context: Context) :
    SQLiteOpenHelper(context, "nafjin.db", null, 2) {

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE CartDetails (Id INTEGER PRIMARY KEY, user_number TEXT, product_id INTEGER, product_code TEXT, product_name TEXT, product_price INTEGER, product_description TEXT, product_stock INTEGER, product_order_status Boolean, product_total_count INTEGER, product_category TEXT, product_image TEXT)")
        db.execSQL("CREATE TABLE NotificationDetails (Id INTEGER PRIMARY KEY, product_id INTEGER, notification_title TEXT, notification_body TEXT, product_category TEXT, product_image TEXT, created_at DATETIME DEFAULT CURRENT_TIMESTAMP)")
        db.execSQL("CREATE TABLE ProfileDetails (Id INTEGER PRIMARY KEY, user_number TEXT, profile_name TEXT, profile_email TEXT, created_at DATETIME DEFAULT CURRENT_TIMESTAMP)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.i(TAG, "onUpgrade: $oldVersion > $newVersion")
        if (newVersion > oldVersion) {
            db!!.execSQL("CREATE TABLE NotificationDetails (Id INTEGER PRIMARY KEY, product_id INTEGER, notification_title TEXT, notification_body TEXT, product_category TEXT, product_image TEXT, created_at DATETIME DEFAULT CURRENT_TIMESTAMP)")
        }
    }

    fun insertRowInCart(
        singleProductResponse: SingleProductResponse,
        userNumber: String?,
        totalCount: Int,
        categoryName: String
    ): Long {
        val db = writableDatabase
        val sql =
            "insert into CartDetails (user_number, product_id, product_code , product_name, product_description, product_stock, product_order_status,product_total_count, product_price, product_category, product_image)values (?,?,?,?,?,?,?,?,?,?,?);";
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
        stmt.bindString(10, categoryName)
        stmt.bindString(11, singleProductResponse.image)
        val returnValue = stmt.executeInsert()
        stmt.clearBindings()

        return returnValue
    }

    fun updateCartProduct(viewCartDataModel: ViewCartDataModel, actualCountFromCart: Int) {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put("product_total_count", actualCountFromCart)
        db.update("CartDetails", contentValues, "Id=?",
            arrayOf(viewCartDataModel.id.toString())
        )
        db.close()
    }

    fun getRowsFromCart(): Cursor {
        val detailsQuery = "select * from CartDetails"
        return writableDatabase.rawQuery(detailsQuery, null)
    }

    fun getProductFromCart(productId: Int): Boolean {
        val db = writableDatabase
        val detailsQuery = "select * from CartDetails where product_id = $productId"
        val c = db.rawQuery(detailsQuery, null)
        if (c.count > 0) {
            return true
        }
        c.close()
        db.close()
        return false
    }

    fun deleteProductFromCart(id: Int) =
        writableDatabase.delete("CartDetails", "Id=$id", null)


    fun insertIntoNotification(notificationsDataModel: NotificationsDataModel): Long  {
        val db = writableDatabase
        val sql = "insert into NotificationDetails (product_id, notification_title , notification_body, product_category, product_image)values (?,?,?,?,?);";

        val stmt = db.compileStatement(sql)
        stmt.bindString(1, notificationsDataModel.notificationProductId.toString())
        stmt.bindString(2, notificationsDataModel.notificationTitle)
        stmt.bindString(3, notificationsDataModel.notificationBody)
        stmt.bindString(4, notificationsDataModel.notificationProductCategory)
        stmt.bindString(5, notificationsDataModel.notificationProductImage)

        val returnValue = stmt.executeInsert()
        stmt.clearBindings()

        db.close()
        return returnValue
    }

    fun insertIntoProfile(number: String, name: String, email: String = "") {
        val sql = "select profile_name from ProfileDetails where user_number=$number"
        val cursor = writableDatabase.rawQuery(sql, null)
        if (cursor.count > 0) {
            val contentValues = ContentValues()
            contentValues.put("user_number", number)
            contentValues.put("profile_name", name)
            contentValues.put("profile_email", email)

            writableDatabase.update("ProfileDetails", contentValues, "user_number=?", arrayOf(number))
        } else {
            val db = writableDatabase
            val contentValues = ContentValues()
            contentValues.put("user_number", number)
            contentValues.put("profile_name", name)
            contentValues.put("profile_email", email)
            db.insert("ProfileDetails", null, contentValues)
            db.close()
        }
        cursor.close()
    }

    fun checkNamePresent(number: String) : Boolean {
        val sql = "select profile_name from ProfileDetails where user_number=$number"
        val cursor = writableDatabase.rawQuery(sql, null)
        return if (cursor.count > 0) {
            cursor.moveToFirst()
            val profileName = cursor.getString(0)
            Log.i(TAG, "checkNamePresent: profileName: $profileName")
            cursor.close()
            profileName.isNotEmpty()
        } else {
            cursor.close()
            false
        }
    }

    fun getProfileName(number: String): String {
        val cursor = writableDatabase.rawQuery("Select profile_name from ProfileDetails where user_number=$number", null)
        cursor.moveToFirst()
        return cursor.getString(0)
    }

    fun getProfileDetails(number: String): ProfileDetails.UpdateProfileDetailModel {
        Log.i(TAG, "getProfileDetails: $number")
        val cursor = writableDatabase.rawQuery("Select profile_name, profile_email from ProfileDetails where user_number=$number", null)
        return if (cursor.moveToFirst())
            ProfileDetails.UpdateProfileDetailModel(cursor.getString(0), number, cursor.getString(1))
        else
            ProfileDetails.UpdateProfileDetailModel("", "", "")
    }

    fun clearCart(number: String) {
        writableDatabase.delete("CartDetails", "user_number=?", arrayOf(number))
    }

}