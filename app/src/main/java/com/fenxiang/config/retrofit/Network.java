package com.fenxiang.config.retrofit;

import android.os.Environment;
import com.fenxiang.config.Api;
import com.fenxiang.utils.LogUtils;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


//网络请求封装类，根据需求来定

public class Network {
    private static final long cacheSize = 1024 * 1024 * 20;// 缓存文件最大限制大小20M
    private static String cacheDirectory = Environment.getExternalStorageDirectory() + "/okttpcaches"; // 设置缓存文件路径
    private static final Cache cache = new Cache(new File(cacheDirectory), cacheSize);  //
    private static final OkHttpClient cacheClient = initOkhttp();
    private static JavaApi javaApi;
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create(new GsonBuilder().setLenient().create());
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    private static OkHttpClient initOkhttp() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtils.e("OkHttpClient", message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //如果无法生存缓存文件目录，检测权限使用已经加上，检测手机是否把文件读写权限禁止了
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.addNetworkInterceptor(logInterceptor);
        builder.connectTimeout(100, TimeUnit.SECONDS); // 设置连接超时时间
        builder.writeTimeout(100, TimeUnit.SECONDS);// 设置写入超时时间
        builder.readTimeout(100, TimeUnit.SECONDS);// 设置读取数据超时时间
        builder.retryOnConnectionFailure(true);// 设置进行连接失败重试
        builder.addInterceptor(httpLoggingInterceptor);
        return builder.build();
    }

    /**
     * 封装公共参数（Key和密码）
     * <p>
     */
    private static class CommonInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request oldRequest = chain.request();

            // 添加新的参数
            HttpUrl.Builder builder = oldRequest.url()
                    .newBuilder()
                    .scheme(oldRequest.url().scheme())
                    .host(oldRequest.url().host());
//                    .addQueryParameter(MarvelService.PARAM_HASH, marvelHash);

            // 新的请求
            Request newRequest = oldRequest.newBuilder()
                    .method(oldRequest.method(), oldRequest.body())
                    .url(builder.build())
                    .build();

            return chain.proceed(newRequest);
        }
    }

    /**
     * 统一的网络请求
     *
     * @return
     */
    public static JavaApi RequestJava() {
        if (javaApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(cacheClient)
                    .baseUrl(Api.BASE_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            javaApi = retrofit.create(JavaApi.class);
        }
        return javaApi;
    }

    /**
     * 添加接口加密
     *
     * @param hashMap
     */
//    public static void AddSignature(HashMap<String, String> hashMap) {
//        hashMap.put("noncestr", RandomBuffer.getRandomString());
//        hashMap.put("stamp", System.currentTimeMillis() / 1000 + "");
//        String signature = RsaHelper.sha256_HMAC(hashMap, "chainhoo");
//        hashMap.put("signature", signature);
//    }

}
