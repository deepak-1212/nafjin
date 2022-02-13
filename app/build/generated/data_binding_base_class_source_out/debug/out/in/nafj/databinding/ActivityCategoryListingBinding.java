// Generated by data binding compiler. Do not edit!
package in.nafj.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.nafj.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityCategoryListingBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView categoryListing;

  @NonNull
  public final ToolbarHomeBinding homeToolbar;

  protected ActivityCategoryListingBinding(Object _bindingComponent, View _root,
      int _localFieldCount, RecyclerView categoryListing, ToolbarHomeBinding homeToolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.categoryListing = categoryListing;
    this.homeToolbar = homeToolbar;
  }

  @NonNull
  public static ActivityCategoryListingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_category_listing, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCategoryListingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityCategoryListingBinding>inflateInternal(inflater, R.layout.activity_category_listing, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCategoryListingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_category_listing, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCategoryListingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityCategoryListingBinding>inflateInternal(inflater, R.layout.activity_category_listing, null, false, component);
  }

  public static ActivityCategoryListingBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityCategoryListingBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityCategoryListingBinding)bind(component, view, R.layout.activity_category_listing);
  }
}
