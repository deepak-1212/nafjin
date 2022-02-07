package in.nafj.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH\'Jn\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\fH\'J\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\u0016"}, d2 = {"Lin/nafj/helper/RetrofitApi;", "", "categoryListing", "Lretrofit2/Call;", "Lin/nafj/helper/ListingResponse;", "loginRegister", "Lin/nafj/helper/CreateRecordInServerResponse;", "storeOtpModel", "Lin/nafj/model/StoreOtpModel;", "sendSms", "Lokhttp3/ResponseBody;", "user", "", "key", "mobile", "message", "senderid", "accusage", "entityid", "tempid", "verifyOtp", "Lin/nafj/helper/VerifyOtpResponse;", "app_debug"})
public abstract interface RetrofitApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "login_register.php")
    public abstract retrofit2.Call<in.nafj.helper.CreateRecordInServerResponse> loginRegister(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    in.nafj.model.StoreOtpModel storeOtpModel);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "verifyOtp.php")
    public abstract retrofit2.Call<in.nafj.helper.VerifyOtpResponse> verifyOtp(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    in.nafj.model.StoreOtpModel storeOtpModel);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "listing.php")
    public abstract retrofit2.Call<in.nafj.helper.ListingResponse> categoryListing();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "submitsms.jsp")
    public abstract retrofit2.Call<okhttp3.ResponseBody> sendSms(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "user")
    java.lang.String user, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "key")
    java.lang.String key, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "mobile")
    java.lang.String mobile, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "message")
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "senderid")
    java.lang.String senderid, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "accusage")
    java.lang.String accusage, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "entityid")
    java.lang.String entityid, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "tempid")
    java.lang.String tempid);
}