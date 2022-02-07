package in.nafj;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.nafj.databinding.ActivityCategoryListingBindingImpl;
import in.nafj.databinding.ActivityLoginBindingImpl;
import in.nafj.databinding.ActivityLoginOtpBindingImpl;
import in.nafj.databinding.ActivityProductListingBindingImpl;
import in.nafj.databinding.ActivityProfileBindingImpl;
import in.nafj.databinding.ActivitySignUpBindingImpl;
import in.nafj.databinding.ActivitySubCategoryListingBindingImpl;
import in.nafj.databinding.ActivityViewCartBindingImpl;
import in.nafj.databinding.ActivityViewProductBindingImpl;
import in.nafj.databinding.ViewCategorySingleBindingImpl;
import in.nafj.databinding.ViewProductSingleBindingImpl;
import in.nafj.databinding.ViewSubCategorySingleBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCATEGORYLISTING = 1;

  private static final int LAYOUT_ACTIVITYLOGIN = 2;

  private static final int LAYOUT_ACTIVITYLOGINOTP = 3;

  private static final int LAYOUT_ACTIVITYPRODUCTLISTING = 4;

  private static final int LAYOUT_ACTIVITYPROFILE = 5;

  private static final int LAYOUT_ACTIVITYSIGNUP = 6;

  private static final int LAYOUT_ACTIVITYSUBCATEGORYLISTING = 7;

  private static final int LAYOUT_ACTIVITYVIEWCART = 8;

  private static final int LAYOUT_ACTIVITYVIEWPRODUCT = 9;

  private static final int LAYOUT_VIEWCATEGORYSINGLE = 10;

  private static final int LAYOUT_VIEWPRODUCTSINGLE = 11;

  private static final int LAYOUT_VIEWSUBCATEGORYSINGLE = 12;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(12);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_category_listing, LAYOUT_ACTIVITYCATEGORYLISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_login_otp, LAYOUT_ACTIVITYLOGINOTP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_product_listing, LAYOUT_ACTIVITYPRODUCTLISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_profile, LAYOUT_ACTIVITYPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_sign_up, LAYOUT_ACTIVITYSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_sub_category_listing, LAYOUT_ACTIVITYSUBCATEGORYLISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_view_cart, LAYOUT_ACTIVITYVIEWCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_view_product, LAYOUT_ACTIVITYVIEWPRODUCT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.view_category_single, LAYOUT_VIEWCATEGORYSINGLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.view_product_single, LAYOUT_VIEWPRODUCTSINGLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.view_sub_category_single, LAYOUT_VIEWSUBCATEGORYSINGLE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYCATEGORYLISTING: {
          if ("layout/activity_category_listing_0".equals(tag)) {
            return new ActivityCategoryListingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_category_listing is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGINOTP: {
          if ("layout/activity_login_otp_0".equals(tag)) {
            return new ActivityLoginOtpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login_otp is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRODUCTLISTING: {
          if ("layout/activity_product_listing_0".equals(tag)) {
            return new ActivityProductListingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_product_listing is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPROFILE: {
          if ("layout/activity_profile_0".equals(tag)) {
            return new ActivityProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSIGNUP: {
          if ("layout/activity_sign_up_0".equals(tag)) {
            return new ActivitySignUpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sign_up is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSUBCATEGORYLISTING: {
          if ("layout/activity_sub_category_listing_0".equals(tag)) {
            return new ActivitySubCategoryListingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sub_category_listing is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYVIEWCART: {
          if ("layout/activity_view_cart_0".equals(tag)) {
            return new ActivityViewCartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_view_cart is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYVIEWPRODUCT: {
          if ("layout/activity_view_product_0".equals(tag)) {
            return new ActivityViewProductBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_view_product is invalid. Received: " + tag);
        }
        case  LAYOUT_VIEWCATEGORYSINGLE: {
          if ("layout/view_category_single_0".equals(tag)) {
            return new ViewCategorySingleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for view_category_single is invalid. Received: " + tag);
        }
        case  LAYOUT_VIEWPRODUCTSINGLE: {
          if ("layout/view_product_single_0".equals(tag)) {
            return new ViewProductSingleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for view_product_single is invalid. Received: " + tag);
        }
        case  LAYOUT_VIEWSUBCATEGORYSINGLE: {
          if ("layout/view_sub_category_single_0".equals(tag)) {
            return new ViewSubCategorySingleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for view_sub_category_single is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(12);

    static {
      sKeys.put("layout/activity_category_listing_0", in.nafj.R.layout.activity_category_listing);
      sKeys.put("layout/activity_login_0", in.nafj.R.layout.activity_login);
      sKeys.put("layout/activity_login_otp_0", in.nafj.R.layout.activity_login_otp);
      sKeys.put("layout/activity_product_listing_0", in.nafj.R.layout.activity_product_listing);
      sKeys.put("layout/activity_profile_0", in.nafj.R.layout.activity_profile);
      sKeys.put("layout/activity_sign_up_0", in.nafj.R.layout.activity_sign_up);
      sKeys.put("layout/activity_sub_category_listing_0", in.nafj.R.layout.activity_sub_category_listing);
      sKeys.put("layout/activity_view_cart_0", in.nafj.R.layout.activity_view_cart);
      sKeys.put("layout/activity_view_product_0", in.nafj.R.layout.activity_view_product);
      sKeys.put("layout/view_category_single_0", in.nafj.R.layout.view_category_single);
      sKeys.put("layout/view_product_single_0", in.nafj.R.layout.view_product_single);
      sKeys.put("layout/view_sub_category_single_0", in.nafj.R.layout.view_sub_category_single);
    }
  }
}
