package in.nafj.database;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\fJ(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0012J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u0010\u0019\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0006\u0010\u001c\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lin/nafj/database/DatabaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "deleteProductFromCart", "", "id", "getProductFromCart", "", "productId", "getRowsFromCart", "Landroid/database/Cursor;", "insertRowInCart", "", "singleProductResponse", "Lin/nafj/helper/SingleProductResponse;", "userNumber", "", "totalCount", "categoryName", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "updateProductInCart", "app_debug"})
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
    
    public final void updateProductInCart() {
    }
}