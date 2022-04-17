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
import in.nafj.databinding.ActivityNotificationListingBindingImpl;
import in.nafj.databinding.ActivityOrderListingBindingImpl;
import in.nafj.databinding.ActivityProductListingBindingImpl;
import in.nafj.databinding.ActivityProfileBindingImpl;
import in.nafj.databinding.ActivitySubCategoryListingBindingImpl;
import in.nafj.databinding.ActivityViewCartBindingImpl;
import in.nafj.databinding.ActivityViewProductBindingImpl;
import in.nafj.databinding.EnterNameBindingImpl;
import in.nafj.databinding.FragmentRemoveItemOrderListBindingImpl;
import in.nafj.databinding.ProductHomeListingBindingImpl;
import in.nafj.databinding.SingleProductSearchViewBindingImpl;
import in.nafj.databinding.ToolbarHomeBindingImpl;
import in.nafj.databinding.ViewCartSingleBindingImpl;
import in.nafj.databinding.ViewCategorySingleBindingImpl;
import in.nafj.databinding.ViewNotificationSingleBindingImpl;
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

  private static final int LAYOUT_ACTIVITYNOTIFICATIONLISTING = 4;

  private static final int LAYOUT_ACTIVITYORDERLISTING = 5;

  private static final int LAYOUT_ACTIVITYPRODUCTLISTING = 6;

  private static final int LAYOUT_ACTIVITYPROFILE = 7;

  private static final int LAYOUT_ACTIVITYSUBCATEGORYLISTING = 8;

  private static final int LAYOUT_ACTIVITYVIEWCART = 9;

  private static final int LAYOUT_ACTIVITYVIEWPRODUCT = 10;

  private static final int LAYOUT_ENTERNAME = 11;

  private static final int LAYOUT_FRAGMENTREMOVEITEMORDERLIST = 12;

  private static final int LAYOUT_PRODUCTHOMELISTING = 13;

  private static final int LAYOUT_SINGLEPRODUCTSEARCHVIEW = 14;

  private static final int LAYOUT_TOOLBARHOME = 15;

  private static final int LAYOUT_VIEWCARTSINGLE = 16;

  private static final int LAYOUT_VIEWCATEGORYSINGLE = 17;

  private static final int LAYOUT_VIEWNOTIFICATIONSINGLE = 18;

  private static final int LAYOUT_VIEWPRODUCTSINGLE = 19;

  private static final int LAYOUT_VIEWSUBCATEGORYSINGLE = 20;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(20);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_category_listing, LAYOUT_ACTIVITYCATEGORYLISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_login_otp, LAYOUT_ACTIVITYLOGINOTP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_notification_listing, LAYOUT_ACTIVITYNOTIFICATIONLISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_order_listing, LAYOUT_ACTIVITYORDERLISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_product_listing, LAYOUT_ACTIVITYPRODUCTLISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_profile, LAYOUT_ACTIVITYPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_sub_category_listing, LAYOUT_ACTIVITYSUBCATEGORYLISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_view_cart, LAYOUT_ACTIVITYVIEWCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.activity_view_product, LAYOUT_ACTIVITYVIEWPRODUCT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.enter_name, LAYOUT_ENTERNAME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.fragment_remove_item_order_list, LAYOUT_FRAGMENTREMOVEITEMORDERLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.product_home_listing, LAYOUT_PRODUCTHOMELISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.single_product_search_view, LAYOUT_SINGLEPRODUCTSEARCHVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.toolbar_home, LAYOUT_TOOLBARHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.view_cart_single, LAYOUT_VIEWCARTSINGLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.view_category_single, LAYOUT_VIEWCATEGORYSINGLE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(in.nafj.R.layout.view_notification_single, LAYOUT_VIEWNOTIFICATIONSINGLE);
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
        case  LAYOUT_ACTIVITYNOTIFICATIONLISTING: {
          if ("layout/activity_notification_listing_0".equals(tag)) {
            return new ActivityNotificationListingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_notification_listing is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYORDERLISTING: {
          if ("layout/activity_order_listing_0".equals(tag)) {
            return new ActivityOrderListingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_order_listing is invalid. Received: " + tag);
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
        case  LAYOUT_ENTERNAME: {
          if ("layout/enter_name_0".equals(tag)) {
            return new EnterNameBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for enter_name is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREMOVEITEMORDERLIST: {
          if ("layout/fragment_remove_item_order_list_0".equals(tag)) {
            return new FragmentRemoveItemOrderListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_remove_item_order_list is invalid. Received: " + tag);
        }
        case  LAYOUT_PRODUCTHOMELISTING: {
          if ("layout/product_home_listing_0".equals(tag)) {
            return new ProductHomeListingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for product_home_listing is invalid. Received: " + tag);
        }
        case  LAYOUT_SINGLEPRODUCTSEARCHVIEW: {
          if ("layout/single_product_search_view_0".equals(tag)) {
            return new SingleProductSearchViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for single_product_search_view is invalid. Received: " + tag);
        }
        case  LAYOUT_TOOLBARHOME: {
          if ("layout/toolbar_home_0".equals(tag)) {
            return new ToolbarHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for toolbar_home is invalid. Received: " + tag);
        }
        case  LAYOUT_VIEWCARTSINGLE: {
          if ("layout/view_cart_single_0".equals(tag)) {
            return new ViewCartSingleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for view_cart_single is invalid. Received: " + tag);
        }
        case  LAYOUT_VIEWCATEGORYSINGLE: {
          if ("layout/view_category_single_0".equals(tag)) {
            return new ViewCategorySingleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for view_category_single is invalid. Received: " + tag);
        }
        case  LAYOUT_VIEWNOTIFICATIONSINGLE: {
          if ("layout/view_notification_single_0".equals(tag)) {
            return new ViewNotificationSingleBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for view_notification_single is invalid. Received: " + tag);
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
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(20);

    static {
      sKeys.put("layout/activity_category_listing_0", in.nafj.R.layout.activity_category_listing);
      sKeys.put("layout/activity_login_0", in.nafj.R.layout.activity_login);
      sKeys.put("layout/activity_login_otp_0", in.nafj.R.layout.activity_login_otp);
      sKeys.put("layout/activity_notification_listing_0", in.nafj.R.layout.activity_notification_listing);
      sKeys.put("layout/activity_order_listing_0", in.nafj.R.layout.activity_order_listing);
      sKeys.put("layout/activity_product_listing_0", in.nafj.R.layout.activity_product_listing);
      sKeys.put("layout/activity_profile_0", in.nafj.R.layout.activity_profile);
      sKeys.put("layout/activity_sub_category_listing_0", in.nafj.R.layout.activity_sub_category_listing);
      sKeys.put("layout/activity_view_cart_0", in.nafj.R.layout.activity_view_cart);
      sKeys.put("layout/activity_view_product_0", in.nafj.R.layout.activity_view_product);
      sKeys.put("layout/enter_name_0", in.nafj.R.layout.enter_name);
      sKeys.put("layout/fragment_remove_item_order_list_0", in.nafj.R.layout.fragment_remove_item_order_list);
      sKeys.put("layout/product_home_listing_0", in.nafj.R.layout.product_home_listing);
      sKeys.put("layout/single_product_search_view_0", in.nafj.R.layout.single_product_search_view);
      sKeys.put("layout/toolbar_home_0", in.nafj.R.layout.toolbar_home);
      sKeys.put("layout/view_cart_single_0", in.nafj.R.layout.view_cart_single);
      sKeys.put("layout/view_category_single_0", in.nafj.R.layout.view_category_single);
      sKeys.put("layout/view_notification_single_0", in.nafj.R.layout.view_notification_single);
      sKeys.put("layout/view_product_single_0", in.nafj.R.layout.view_product_single);
      sKeys.put("layout/view_sub_category_single_0", in.nafj.R.layout.view_sub_category_single);
    }
  }
}
