package com.bawei.dianshangjin06.util;

import com.bawei.dianshangjin06.bean.Commodity;
import com.bawei.dianshangjin06.bean.DataBean;
import com.bawei.dianshangjin06.bean.HomeList;
import com.bawei.dianshangjin06.bean.LoginInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * IRequest接口，用于描述网络请求
 */
public interface IRequest {
    //注册接口
    @POST("small/user/v1/register")
    @FormUrlEncoded
    Observable<DataBean> register(@Field("phone") String phone, @Field("pwd") String pwd);
    //登录接口
    @POST("small/user/v1/login")
    @FormUrlEncoded
    Observable<DataBean<LoginInfo>> login(@Field("phone") String phone, @Field("pwd") String pwd);
    //首页展示接口
    @GET("small/commodity/v1/commodityList")
    Observable<DataBean<HomeList>> commodityList();
    //查找商品接口
    @GET("small/commodity/v1/findCommodityByKeyword")
    Observable<DataBean<List<Commodity>>> findCommodityByKeyword(@Query("keyword") String keyword,
                                                           @Query("page") int page, @Query("count") int count);
}
