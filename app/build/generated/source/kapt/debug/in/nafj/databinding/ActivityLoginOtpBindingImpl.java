package in.nafj.databinding;
import in.nafj.R;
import in.nafj.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginOtpBindingImpl extends ActivityLoginOtpBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appIconName, 1);
        sViewsWithIds.put(R.id.submitOtpText, 2);
        sViewsWithIds.put(R.id.otpTextView, 3);
        sViewsWithIds.put(R.id.root_otp_layout, 4);
        sViewsWithIds.put(R.id.otp_edit_box1, 5);
        sViewsWithIds.put(R.id.otp_edit_box2, 6);
        sViewsWithIds.put(R.id.otp_edit_box3, 7);
        sViewsWithIds.put(R.id.otp_edit_box4, 8);
        sViewsWithIds.put(R.id.otp_edit_box5, 9);
        sViewsWithIds.put(R.id.otp_edit_box6, 10);
        sViewsWithIds.put(R.id.errorOtp, 11);
        sViewsWithIds.put(R.id.nextButton, 12);
        sViewsWithIds.put(R.id.resendOtpText, 13);
        sViewsWithIds.put(R.id.resendOtpButton, 14);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityLoginOtpBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }
    private ActivityLoginOtpBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (bindings[1] != null) ? in.nafj.databinding.AppIconNameBinding.bind((android.view.View) bindings[1]) : null
            , (androidx.appcompat.widget.AppCompatTextView) bindings[11]
            , (androidx.appcompat.widget.AppCompatButton) bindings[12]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[5]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[6]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[7]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[8]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[9]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[10]
            , (android.widget.TextView) bindings[3]
            , (androidx.appcompat.widget.AppCompatButton) bindings[14]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[13]
            , (android.widget.LinearLayout) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}