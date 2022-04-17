package in.nafj.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\bJ(\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\bJ\u0012\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\"\u0010#\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016J\u0016\u0010&\u001a\u00020\n2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lin/nafj/database/DatabaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkNamePresent", "", "number", "", "clearCart", "", "deleteProductFromCart", "", "id", "getProductFromCart", "productId", "getProfileName", "getRowsFromCart", "Landroid/database/Cursor;", "insertIntoNotification", "", "notificationsDataModel", "Lin/nafj/activity/NotificationsDataModel;", "insertIntoProfile", "name", "email", "insertRowInCart", "singleProductResponse", "Lin/nafj/helper/SingleProductResponse;", "userNumber", "totalCount", "categoryName", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "updateCartProduct", "viewCartDataModel", "Lin/nafj/activity/ViewCartDataModel;", "actualCountFromCart", "app_debug"})
public final class DatabaseHelper extends android.database.sqlite.SQLiteOpenHelper {
    private final android.content.Context context = null;
    
    public DatabaseHelper(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null, null, null, 0);
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    
    public final long insertRowInCart(@org.jetbrains.annotations.NotNull()
    in.nafj.helper.SingleProductResponse singleProductResponse, @org.jetbrains.annotations.Nullable()
    java.lang.String userNumber, int totalCount, @org.jetbrains.annotations.NotNull()
    java.lang.String categoryName) {
        return 0L;
    }
    
    public final void updateCartProduct(@org.jetbrains.annotations.NotNull()
    in.nafj.activity.ViewCartDataModel viewCartDataModel, int actualCountFromCart) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.database.Cursor getRowsFromCart() {
        return null;
    }
    
    public final boolean getProductFromCart(int productId) {
        return false;
    }
    
    public final int deleteProductFromCart(int id) {
        return 0;
    }
    
    public final long insertIntoNotification(@org.jetbrains.annotations.NotNull()
    in.nafj.activity.NotificationsDataModel notificationsDataModel) {
        return 0L;
    }
    
    public final void insertIntoProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String number, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final boolean checkNamePresent(@org.jetbrains.annotations.NotNull()
    java.lang.String number) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProfileName(@org.jetbrains.annotations.NotNull()
    java.lang.String number) {
        return null;
    }
    
    public final void clearCart(@org.jetbrains.annotations.NotNull()
    java.lang.String number) {
    }
}