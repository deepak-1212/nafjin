// Generated by data binding compiler. Do not edit!
package in.nafj.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.imageview.ShapeableImageView;
import in.nafj.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ViewCartSingleBinding extends ViewDataBinding {
  @NonNull
  public final ShapeableImageView addQuantity;

  @NonNull
  public final ImageView cartItemImage;

  @NonNull
  public final TextView categoryName;

  @NonNull
  public final Barrier imageBarrier;

  @NonNull
  public final TextView productName;

  @NonNull
  public final ImageView removeItem;

  @NonNull
  public final ShapeableImageView subtractQuantity;

  @NonNull
  public final AppCompatTextView totalQuantityText;

  @NonNull
  public final AppCompatTextView totalQuantityValue;

  protected ViewCartSingleBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ShapeableImageView addQuantity, ImageView cartItemImage, TextView categoryName,
      Barrier imageBarrier, TextView productName, ImageView removeItem,
      ShapeableImageView subtractQuantity, AppCompatTextView totalQuantityText,
      AppCompatTextView totalQuantityValue) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addQuantity = addQuantity;
    this.cartItemImage = cartItemImage;
    this.categoryName = categoryName;
    this.imageBarrier = imageBarrier;
    this.productName = productName;
    this.removeItem = removeItem;
    this.subtractQuantity = subtractQuantity;
    this.totalQuantityText = totalQuantityText;
    this.totalQuantityValue = totalQuantityValue;
  }

  @NonNull
  public static ViewCartSingleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.view_cart_single, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ViewCartSingleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ViewCartSingleBinding>inflateInternal(inflater, R.layout.view_cart_single, root, attachToRoot, component);
  }

  @NonNull
  public static ViewCartSingleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.view_cart_single, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ViewCartSingleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ViewCartSingleBinding>inflateInternal(inflater, R.layout.view_cart_single, null, false, component);
  }

  public static ViewCartSingleBinding bind(@NonNull View view) {
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
  public static ViewCartSingleBinding bind(@NonNull View view, @Nullable Object component) {
    return (ViewCartSingleBinding)bind(component, view, R.layout.view_cart_single);
  }
}
