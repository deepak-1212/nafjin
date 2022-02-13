package in.nafj.databinding;
import in.nafj.R;
import in.nafj.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityViewProductBindingImpl extends ActivityViewProductBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(19);
        sIncludes.setIncludes(0, 
            new String[] {"toolbar_home"},
            new int[] {1},
            new int[] {in.nafj.R.layout.toolbar_home});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.centerView, 2);
        sViewsWithIds.put(R.id.viewProductImage, 3);
        sViewsWithIds.put(R.id.viewProductDetailsSection, 4);
        sViewsWithIds.put(R.id.viewProductName, 5);
        sViewsWithIds.put(R.id.viewProductCategory, 6);
        sViewsWithIds.put(R.id.viewProductDescription, 7);
        sViewsWithIds.put(R.id.viewProductPrice, 8);
        sViewsWithIds.put(R.id.addToCartSection, 9);
        sViewsWithIds.put(R.id.quantityText, 10);
        sViewsWithIds.put(R.id.totalAmountText, 11);
        sViewsWithIds.put(R.id.headerBarrier, 12);
        sViewsWithIds.put(R.id.subtractQuantity, 13);
        sViewsWithIds.put(R.id.totalQuantityText, 14);
        sViewsWithIds.put(R.id.addQuantity, 15);
        sViewsWithIds.put(R.id.totalQuantityValue, 16);
        sViewsWithIds.put(R.id.addToCartBarrier, 17);
        sViewsWithIds.put(R.id.addToCart, 18);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityViewProductBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private ActivityViewProductBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.imageview.ShapeableImageView) bindings[15]
            , (androidx.appcompat.widget.AppCompatButton) bindings[18]
            , (androidx.constraintlayout.widget.Barrier) bindings[17]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[9]
            , (android.widget.ScrollView) bindings[2]
            , (androidx.constraintlayout.widget.Barrier) bindings[12]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[10]
            , (com.google.android.material.imageview.ShapeableImageView) bindings[13]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[11]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[14]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[16]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[8]
            , (in.nafj.databinding.ToolbarHomeBinding) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setContainedBinding(this.viewProductToolbar);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        viewProductToolbar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (viewProductToolbar.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        viewProductToolbar.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewProductToolbar((in.nafj.databinding.ToolbarHomeBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewProductToolbar(in.nafj.databinding.ToolbarHomeBinding ViewProductToolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
        executeBindingsOn(viewProductToolbar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewProductToolbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}