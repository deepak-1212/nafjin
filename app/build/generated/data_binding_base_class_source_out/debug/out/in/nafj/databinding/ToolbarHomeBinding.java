// Generated by data binding compiler. Do not edit!
package in.nafj.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.nafj.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ToolbarHomeBinding extends ViewDataBinding {
  @NonNull
  public final TextView headerTextView;

  @NonNull
  public final ImageView notifications;

  @NonNull
  public final ImageView shoppingCart;

  @NonNull
  public final Toolbar toolbar;

  protected ToolbarHomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView headerTextView, ImageView notifications, ImageView shoppingCart, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.headerTextView = headerTextView;
    this.notifications = notifications;
    this.shoppingCart = shoppingCart;
    this.toolbar = toolbar;
  }

  @NonNull
  public static ToolbarHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.toolbar_home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ToolbarHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ToolbarHomeBinding>inflateInternal(inflater, R.layout.toolbar_home, root, attachToRoot, component);
  }

  @NonNull
  public static ToolbarHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.toolbar_home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ToolbarHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ToolbarHomeBinding>inflateInternal(inflater, R.layout.toolbar_home, null, false, component);
  }

  public static ToolbarHomeBinding bind(@NonNull View view) {
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
  public static ToolbarHomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (ToolbarHomeBinding)bind(component, view, R.layout.toolbar_home);
  }
}
