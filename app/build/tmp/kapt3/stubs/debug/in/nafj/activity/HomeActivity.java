package in.nafj.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0017H\u0014J\b\u0010\u001c\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lin/nafj/activity/HomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lin/nafj/databinding/ActivityCategoryListingBinding;", "categoryInterface", "Lin/nafj/activity/HomeActivity$CategoryInterface;", "categoryList", "Ljava/util/ArrayList;", "Lin/nafj/helper/SingleCategoryResponse;", "categoryListingAdapter", "Lin/nafj/activity/HomeActivity$CategoryListingAdapter;", "categoryListingInterface", "Lin/nafj/activity/HomeActivity$CategoryListingInterface;", "firebaseToken", "", "removeItemInterface", "Lin/nafj/sheets/RemoveItemOrderList$RemoveItemInterface;", "sharedPreferences", "Landroid/content/SharedPreferences;", "toolbarBinding", "Lin/nafj/databinding/ToolbarHomeBinding;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "retrieveToken", "CategoryInterface", "CategoryListingAdapter", "CategoryListingInterface", "app_debug"})
public final class HomeActivity extends androidx.appcompat.app.AppCompatActivity {
    private java.lang.String firebaseToken = "";
    private in.nafj.databinding.ActivityCategoryListingBinding binding;
    private in.nafj.databinding.ToolbarHomeBinding toolbarBinding;
    private final java.util.ArrayList<in.nafj.helper.SingleCategoryResponse> categoryList = null;
    private in.nafj.activity.HomeActivity.CategoryListingAdapter categoryListingAdapter;
    private android.content.SharedPreferences sharedPreferences;
    private final in.nafj.activity.HomeActivity.CategoryInterface categoryInterface = null;
    private final in.nafj.activity.HomeActivity.CategoryListingInterface categoryListingInterface = null;
    private final in.nafj.sheets.RemoveItemOrderList.RemoveItemInterface removeItemInterface = null;
    
    public HomeActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void retrieveToken() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lin/nafj/activity/HomeActivity$CategoryInterface;", "", "onCategorySelected", "", "position", "", "singleCategoryResponse", "Lin/nafj/helper/SingleCategoryResponse;", "categoryName", "", "app_debug"})
    public static abstract interface CategoryInterface {
        
        public abstract void onCategorySelected(int position, @org.jetbrains.annotations.NotNull()
        in.nafj.helper.SingleCategoryResponse singleCategoryResponse, @org.jetbrains.annotations.NotNull()
        java.lang.String categoryName);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lin/nafj/activity/HomeActivity$CategoryListingInterface;", "", "onListingFailure", "", "onListingSuccess", "body", "Lin/nafj/helper/ListingResponse;", "app_debug"})
    public static abstract interface CategoryListingInterface {
        
        public abstract void onListingSuccess(@org.jetbrains.annotations.NotNull()
        in.nafj.helper.ListingResponse body);
        
        public abstract void onListingFailure();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0018B%\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u0014\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lin/nafj/activity/HomeActivity$CategoryListingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/nafj/activity/HomeActivity$CategoryListingAdapter$ViewHolder;", "Lin/nafj/activity/HomeActivity;", "categoryList", "Ljava/util/ArrayList;", "Lin/nafj/helper/SingleCategoryResponse;", "Lkotlin/collections/ArrayList;", "categoryInterface", "Lin/nafj/activity/HomeActivity$CategoryInterface;", "(Lin/nafj/activity/HomeActivity;Ljava/util/ArrayList;Lin/nafj/activity/HomeActivity$CategoryInterface;)V", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
    public final class CategoryListingAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<in.nafj.activity.HomeActivity.CategoryListingAdapter.ViewHolder> {
        private java.util.ArrayList<in.nafj.helper.SingleCategoryResponse> categoryList;
        private final in.nafj.activity.HomeActivity.CategoryInterface categoryInterface = null;
        
        public CategoryListingAdapter(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<in.nafj.helper.SingleCategoryResponse> categoryList, @org.jetbrains.annotations.NotNull()
        in.nafj.activity.HomeActivity.CategoryInterface categoryInterface) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public in.nafj.activity.HomeActivity.CategoryListingAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @java.lang.Override()
        public long getItemId(int position) {
            return 0L;
        }
        
        @java.lang.Override()
        public int getItemViewType(int position) {
            return 0;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        in.nafj.activity.HomeActivity.CategoryListingAdapter.ViewHolder holder, int position) {
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lin/nafj/activity/HomeActivity$CategoryListingAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lin/nafj/databinding/ViewCategorySingleBinding;", "(Lin/nafj/activity/HomeActivity$CategoryListingAdapter;Lin/nafj/databinding/ViewCategorySingleBinding;)V", "getBinding", "()Lin/nafj/databinding/ViewCategorySingleBinding;", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final in.nafj.databinding.ViewCategorySingleBinding binding = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull()
            in.nafj.databinding.ViewCategorySingleBinding binding) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull()
            public final in.nafj.databinding.ViewCategorySingleBinding getBinding() {
                return null;
            }
        }
    }
}