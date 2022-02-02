package com.kintree.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\'\u00a8\u0006\u0006"}, d2 = {"Lcom/kintree/helper/RetrofitApi;", "", "sendOtp", "Lretrofit2/Call;", "Lcom/google/gson/JsonObject;", "jsonObject", "app_debug"})
public abstract interface RetrofitApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "sendOtp")
    public abstract retrofit2.Call<com.google.gson.JsonObject> sendOtp(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.google.gson.JsonObject jsonObject);
}