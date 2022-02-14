package in.nafj.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lin/nafj/activity/ViewCartActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lin/nafj/databinding/ActivityViewCartBinding;", "cartList", "Ljava/util/ArrayList;", "Lin/nafj/activity/ViewCartDataModel;", "removeItemInterface", "Lin/nafj/activity/ViewCartActivity$RemoveItemInterface;", "toolbarHomeBinding", "Lin/nafj/databinding/ToolbarHomeBinding;", "totalCartValue", "", "viewCartAdapter", "Lin/nafj/activity/ViewCartActivity$ViewCartAdapter;", "calculateTotal", "totalQuantityCount", "productPrice", "calculateTotalCartValue", "", "requiredStock", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setTotalAmount", "view", "Landroid/widget/TextView;", "setTotalCount", "RemoveItemInterface", "ViewCartAdapter", "app_debug"})
public final class ViewCartActivity extends androidx.appcompat.app.AppCompatActivity {
    private final in.nafj.activity.ViewCartActivity.RemoveItemInterface removeItemInterface = null;
    private in.nafj.databinding.ActivityViewCartBinding binding;
    private in.nafj.databinding.ToolbarHomeBinding toolbarHomeBinding;
    private final java.util.ArrayList<in.nafj.activity.ViewCartDataModel> cartList = null;
    private in.nafj.activity.ViewCartActivity.ViewCartAdapter viewCartAdapter;
    private int totalCartValue = 0;
    
    public ViewCartActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void calculateTotalCartValue(int requiredStock, int productPrice) {
    }
    
    private final int calculateTotal(int totalQuantityCount, int productPrice) {
        return 0;
    }
    
    private final void setTotalCount(android.widget.TextView view, int totalQuantityCount) {
    }
    
    private final void setTotalAmount(android.widget.TextView view, int calculateTotal) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lin/nafj/activity/ViewCartActivity$RemoveItemInterface;", "", "onRemoveCancelled", "", "onRemoveSelected", "position", "", "viewCartDataModel", "Lin/nafj/activity/ViewCartDataModel;", "app_debug"})
    public static abstract interface RemoveItemInterface {
        
        public abstract void onRemoveSelected(int position, @org.jetbrains.annotations.NotNull()
        in.nafj.activity.ViewCartDataModel viewCartDataModel);
        
        public abstract void onRemoveCancelled();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lin/nafj/activity/ViewCartActivity$ViewCartAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/nafj/activity/ViewCartActivity$ViewCartAdapter$ViewHolder;", "Lin/nafj/activity/ViewCartActivity;", "(Lin/nafj/activity/ViewCartActivity;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
    public final class ViewCartAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<in.nafj.activity.ViewCartActivity.ViewCartAdapter.ViewHolder> {
        
        public ViewCartAdapter() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public in.nafj.activity.ViewCartActivity.ViewCartAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        in.nafj.activity.ViewCartActivity.ViewCartAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lin/nafj/activity/ViewCartActivity$ViewCartAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lin/nafj/databinding/ViewCartSingleBinding;", "(Lin/nafj/activity/ViewCartActivity$ViewCartAdapter;Lin/nafj/databinding/ViewCartSingleBinding;)V", "getBinding", "()Lin/nafj/databinding/ViewCartSingleBinding;", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final in.nafj.databinding.ViewCartSingleBinding binding = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull()
            in.nafj.databinding.ViewCartSingleBinding binding) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull()
            public final in.nafj.databinding.ViewCartSingleBinding getBinding() {
                return null;
            }
        }
    }
}