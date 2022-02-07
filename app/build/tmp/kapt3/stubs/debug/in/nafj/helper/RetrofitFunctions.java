package in.nafj.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lin/nafj/helper/RetrofitFunctions;", "", "()V", "Companion", "app_debug"})
public final class RetrofitFunctions {
    @org.jetbrains.annotations.NotNull()
    public static final in.nafj.helper.RetrofitFunctions.Companion Companion = null;
    
    public RetrofitFunctions() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J&\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ&\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ\u001e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t\u00a8\u0006\u0016"}, d2 = {"Lin/nafj/helper/RetrofitFunctions$Companion;", "", "()V", "categoryListing", "", "categoryListingInterface", "Lin/nafj/activity/HomeActivity$CategoryListingInterface;", "createRecordInServer", "passedNumber", "", "createRowInServerInterface", "Lin/nafj/activity/LoginOtpActivity$CreateRowInServerInterface;", "finalResRandom", "firebaseToken", "sendOtp", "sendOtpInterface", "Lin/nafj/activity/LoginOtpActivity$SendOtpInterface;", "appName", "verifyOtp", "verifyOtpInterface", "Lin/nafj/activity/LoginOtpActivity$VerifyOtpInterface;", "otpEntered", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void sendOtp(@org.jetbrains.annotations.NotNull()
        java.lang.String passedNumber, @org.jetbrains.annotations.NotNull()
        in.nafj.activity.LoginOtpActivity.SendOtpInterface sendOtpInterface, @org.jetbrains.annotations.NotNull()
        java.lang.String appName, @org.jetbrains.annotations.NotNull()
        java.lang.String firebaseToken) {
        }
        
        public final void createRecordInServer(@org.jetbrains.annotations.NotNull()
        java.lang.String passedNumber, @org.jetbrains.annotations.NotNull()
        in.nafj.activity.LoginOtpActivity.CreateRowInServerInterface createRowInServerInterface, @org.jetbrains.annotations.NotNull()
        java.lang.String finalResRandom, @org.jetbrains.annotations.NotNull()
        java.lang.String firebaseToken) {
        }
        
        public final void verifyOtp(@org.jetbrains.annotations.NotNull()
        java.lang.String passedNumber, @org.jetbrains.annotations.NotNull()
        in.nafj.activity.LoginOtpActivity.VerifyOtpInterface verifyOtpInterface, @org.jetbrains.annotations.NotNull()
        java.lang.String otpEntered) {
        }
        
        public final void categoryListing(@org.jetbrains.annotations.NotNull()
        in.nafj.activity.HomeActivity.CategoryListingInterface categoryListingInterface) {
        }
    }
}