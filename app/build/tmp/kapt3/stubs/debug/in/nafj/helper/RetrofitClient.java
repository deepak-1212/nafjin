package in.nafj.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lin/nafj/helper/RetrofitClient;", "", "()V", "Companion", "app_debug"})
public final class RetrofitClient {
    @org.jetbrains.annotations.NotNull()
    public static final in.nafj.helper.RetrofitClient.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String url = "https://www.nafj.in/android/services/user/";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String SMS_BASE_URL = "http://netsms.netcomindia.net/";
    @org.jetbrains.annotations.Nullable()
    private static retrofit2.Retrofit retrofit;
    private static com.google.gson.Gson gson;
    
    public RetrofitClient() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lin/nafj/helper/RetrofitClient$Companion;", "", "()V", "SMS_BASE_URL", "", "getSMS_BASE_URL", "()Ljava/lang/String;", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "setRetrofit", "(Lretrofit2/Retrofit;)V", "url", "getUrl", "setUrl", "(Ljava/lang/String;)V", "getClient", "getClientSms", "okhttpClient", "Lokhttp3/OkHttpClient;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUrl() {
            return null;
        }
        
        public final void setUrl(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSMS_BASE_URL() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final retrofit2.Retrofit getRetrofit() {
            return null;
        }
        
        public final void setRetrofit(@org.jetbrains.annotations.Nullable()
        retrofit2.Retrofit p0) {
        }
        
        public final com.google.gson.Gson getGson() {
            return null;
        }
        
        public final void setGson(com.google.gson.Gson p0) {
        }
        
        private final okhttp3.OkHttpClient okhttpClient() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final retrofit2.Retrofit getClient() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final retrofit2.Retrofit getClientSms() {
            return null;
        }
    }
}