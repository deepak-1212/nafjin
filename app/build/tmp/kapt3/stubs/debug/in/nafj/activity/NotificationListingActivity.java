package in.nafj.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lin/nafj/activity/NotificationListingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lin/nafj/databinding/ActivityNotificationListingBinding;", "notificationList", "Ljava/util/ArrayList;", "Lin/nafj/activity/NotificationsDataModel;", "toolbarHomeBinding", "Lin/nafj/databinding/ToolbarHomeBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "NotificationAdapter", "app_debug"})
public final class NotificationListingActivity extends androidx.appcompat.app.AppCompatActivity {
    private in.nafj.databinding.ActivityNotificationListingBinding binding;
    private in.nafj.databinding.ToolbarHomeBinding toolbarHomeBinding;
    private final java.util.ArrayList<in.nafj.activity.NotificationsDataModel> notificationList = null;
    
    public NotificationListingActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lin/nafj/activity/NotificationListingActivity$NotificationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/nafj/activity/NotificationListingActivity$NotificationAdapter$ViewHolder;", "Lin/nafj/activity/NotificationListingActivity;", "(Lin/nafj/activity/NotificationListingActivity;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
    public final class NotificationAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<in.nafj.activity.NotificationListingActivity.NotificationAdapter.ViewHolder> {
        
        public NotificationAdapter() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public in.nafj.activity.NotificationListingActivity.NotificationAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        in.nafj.activity.NotificationListingActivity.NotificationAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lin/nafj/activity/NotificationListingActivity$NotificationAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lin/nafj/databinding/ViewNotificationSingleBinding;", "(Lin/nafj/activity/NotificationListingActivity$NotificationAdapter;Lin/nafj/databinding/ViewNotificationSingleBinding;)V", "getBinding", "()Lin/nafj/databinding/ViewNotificationSingleBinding;", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final in.nafj.databinding.ViewNotificationSingleBinding binding = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull()
            in.nafj.databinding.ViewNotificationSingleBinding binding) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull()
            public final in.nafj.databinding.ViewNotificationSingleBinding getBinding() {
                return null;
            }
        }
    }
}