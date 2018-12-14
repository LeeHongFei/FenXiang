package com.fenxiang.config.retrofit;

import com.fenxiang.bean.BanKuaiLunBo;
import com.fenxiang.config.Api;


import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

public interface JavaApi {

    /**
     * 功能类
     *
     * @param paramsMap
     * @return
     */

    //检查更新开屏广告
    @Headers({"Content-type:application/json;charset=utf-8","Accept:application/json"})
    @POST(Api.bankuaiguanggaourl)
    Observable<BanKuaiLunBo> getLunBo(@Body RequestBody requestBody);

    //上传图片类
//    @Multipart
//    @POST("upload.php")
//    Observable<UpLoadResult> getUpload(@Part List<MultipartBody.Part> partList, @Part("noncestr") RequestBody noncestr, @Part("stamp") RequestBody stamp, @Part("signature") RequestBody signature);

}
