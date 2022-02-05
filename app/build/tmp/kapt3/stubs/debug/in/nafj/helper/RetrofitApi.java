package in.nafj.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001Jp\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0004H\'J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\'\u00a8\u0006\u0011"}, d2 = {"Lin/nafj/helper/RetrofitApi;", "", "sendSms", "Lretrofit2/Call;", "", "user", "key", "mobile", "message", "senderid", "accusage", "entityid", "tempid", "storeOtp", "Lcom/google/gson/JsonObject;", "storeOtpModel", "Lin/nafj/model/StoreOtpModel;", "app_debug"})
public abstract interface RetrofitApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "store_otp.php")
    public abstract retrofit2.Call<com.google.gson.JsonObject> storeOtp(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    in.nafj.model.StoreOtpModel storeOtpModel);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "submitsms.jsp")
    public abstract retrofit2.Call<java.lang.String> sendSms(@org.jetbrains.annotations.Nullable()
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