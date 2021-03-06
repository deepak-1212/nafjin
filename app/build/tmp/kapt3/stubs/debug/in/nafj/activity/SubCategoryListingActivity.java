package in.nafj.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lin/nafj/activity/SubCategoryListingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lin/nafj/databinding/ActivitySubCategoryListingBinding;", "subCategoryInterface", "Lin/nafj/activity/SubCategoryListingActivity$SubCategoryInterface;", "subCategoryList", "Ljava/util/ArrayList;", "Lin/nafj/activity/SubCategory;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "SubCategoryInterface", "SubCategoryListingAdapter", "app_debug"})
public final class SubCategoryListingActivity extends androidx.appcompat.app.AppCompatActivity {
    private in.nafj.databinding.ActivitySubCategoryListingBinding binding;
    private final java.util.ArrayList<in.nafj.activity.SubCategory> subCategoryList = null;
    private final in.nafj.activity.SubCategoryListingActivity.SubCategoryInterface subCategoryInterface = null;
    
    public SubCategoryListingActivity() {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lin/nafj/activity/SubCategoryListingActivity$SubCategoryInterface;", "", "onSubCategorySelected", "", "position", "", "app_debug"})
    public static abstract interface SubCategoryInterface {
        
        public abstract void onSubCategorySelected(int position);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0018B%\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u0014\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lin/nafj/activity/SubCategoryListingActivity$SubCategoryListingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/nafj/activity/SubCategoryListingActivity$SubCategoryListingAdapter$ViewHolder;", "Lin/nafj/activity/SubCategoryListingActivity;", "subCategoryList", "Ljava/util/ArrayList;", "Lin/nafj/activity/SubCategory;", "Lkotlin/collections/ArrayList;", "subCategoryInterface", "Lin/nafj/activity/SubCategoryListingActivity$SubCategoryInterface;", "(Lin/nafj/activity/SubCategoryListingActivity;Ljava/util/ArrayList;Lin/nafj/activity/SubCategoryListingActivity$SubCategoryInterface;)V", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
    public final class SubCategoryListingAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<in.nafj.activity.SubCategoryListingActivity.SubCategoryListingAdapter.ViewHolder> {
        private java.util.ArrayList<in.nafj.activity.SubCategory> subCategoryList;
        private final in.nafj.activity.SubCategoryListingActivity.SubCategoryInterface subCategoryInterface = null;
        
        public SubCategoryListingAdapter(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<in.nafj.activity.SubCategory> subCategoryList, @org.jetbrains.annotations.NotNull()
        in.nafj.activity.SubCategoryListingActivity.SubCategoryInterface subCategoryInterface) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public in.nafj.activity.SubCategoryListingActivity.SubCategoryListingAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
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
        in.nafj.activity.SubCategoryListingActivity.SubCategoryListingAdapter.ViewHolder holder, int position) {
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lin/nafj/activity/SubCategoryListingActivity$SubCategoryListingAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lin/nafj/databinding/ViewSubCategorySingleBinding;", "(Lin/nafj/activity/SubCategoryListingActivity$SubCategoryListingAdapter;Lin/nafj/databinding/ViewSubCategorySingleBinding;)V", "getBinding", "()Lin/nafj/databinding/ViewSubCategorySingleBinding;", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final in.nafj.databinding.ViewSubCategorySingleBinding binding = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull()
            in.nafj.databinding.ViewSubCategorySingleBinding binding) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull()
            public final in.nafj.databinding.ViewSubCategorySingleBinding getBinding() {
                return null;
            }
        }
    }
}