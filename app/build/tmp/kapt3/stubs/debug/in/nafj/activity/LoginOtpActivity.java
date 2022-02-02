package in.nafj.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lin/nafj/activity/LoginOtpActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "activityHome", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "editTextArray", "Ljava/util/ArrayList;", "Landroid/widget/EditText;", "onClick", "", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class LoginOtpActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    private final java.util.ArrayList<android.widget.EditText> editTextArray = null;
    @org.jetbrains.annotations.NotNull()
    public static final in.nafj.activity.LoginOtpActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String otpEnteredCounter = "";
    public static in.nafj.databinding.ActivityLoginOtpBinding binding;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> activityHome = null;
    
    public LoginOtpActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lin/nafj/activity/LoginOtpActivity$Companion;", "", "()V", "binding", "Lin/nafj/databinding/ActivityLoginOtpBinding;", "getBinding", "()Lin/nafj/databinding/ActivityLoginOtpBinding;", "setBinding", "(Lin/nafj/databinding/ActivityLoginOtpBinding;)V", "otpEnteredCounter", "", "getOtpEnteredCounter", "()Ljava/lang/String;", "setOtpEnteredCounter", "(Ljava/lang/String;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getOtpEnteredCounter() {
            return null;
        }
        
        public final void setOtpEnteredCounter(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final in.nafj.databinding.ActivityLoginOtpBinding getBinding() {
            return null;
        }
        
        public final void setBinding(@org.jetbrains.annotations.NotNull()
        in.nafj.databinding.ActivityLoginOtpBinding p0) {
        }
    }
}