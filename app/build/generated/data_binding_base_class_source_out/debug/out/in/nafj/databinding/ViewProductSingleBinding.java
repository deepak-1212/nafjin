// Generated by data binding compiler. Do not edit!
package in.nafj.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.nafj.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ViewProductSingleBinding extends ViewDataBinding {
  @NonNull
  public final ImageView productImage;

  @NonNull
  public final TextView productName;

  protected ViewProductSingleBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView productImage, TextView productName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.productImage = productImage;
    this.productName = productName;
  }

  @NonNull
  public static ViewProductSingleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.view_product_single, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ViewProductSingleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ViewProductSingleBinding>inflateInternal(inflater, R.layout.view_product_single, root, attachToRoot, component);
  }

  @NonNull
  public static ViewProductSingleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.view_product_single, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ViewProductSingleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ViewProductSingleBinding>inflateInternal(inflater, R.layout.view_product_single, null, false, component);
  }

  public static ViewProductSingleBinding bind(@NonNull View view) {
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
  public static ViewProductSingleBinding bind(@NonNull View view, @Nullable Object component) {
    return (ViewProductSingleBinding)bind(component, view, R.layout.view_product_single);
  }
}
