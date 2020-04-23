package com.bawei.dianshangjin06;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.dianshangjin06.bean.Commodity;
import com.bawei.dianshangjin06.bean.DataBean;
import com.bawei.dianshangjin06.bean.HomeList;
import com.bawei.dianshangjin06.bean.LoginInfo;
import com.bawei.dianshangjin06.util.IRequest;
import com.bawei.dianshangjin06.util.RetrofitUtil;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    //定义
    @BindView(R.id.result_show)
    protected TextView resultShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    //注册
    @OnClick(R.id.register)
    protected void click01(){
        //发起请求
        IRequest iRequest = RetrofitUtil.getRetrofitUtil().create(IRequest.class);
        iRequest.register("17156891458","123456aa")
                //线程切换
                //把retrofit请求过程订阅到子线程中进行处理
                .subscribeOn(Schedulers.newThread())
                //把响应结果交给Android主线程进行处理
                .observeOn(AndroidSchedulers.mainThread())
                //响应结果
                .subscribe(new Consumer<DataBean>() {
                    @Override
                    public void accept(DataBean dataBean) throws Exception {
                        String toJson = new Gson().toJson(dataBean);
                        resultShow.setText(toJson);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        resultShow.setText("发生错误了，未接收到任何数据！");
                    }
                });
    }
    //登录
    @OnClick(R.id.login)
    protected void click02(){
        //发起请求
        IRequest iRequest = RetrofitUtil.getRetrofitUtil().create(IRequest.class);
        iRequest.login("17156891458","123456aa")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DataBean<LoginInfo>>() {
                    @Override
                    public void accept(DataBean<LoginInfo> loginInfoDataBean) throws Exception {
                        String toJson = new Gson().toJson(loginInfoDataBean);
                        resultShow.setText(toJson);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        resultShow.setText("发生错误了，未接收到任何数据！");
                    }
                });
    }
    //首页展示接口
    @OnClick(R.id.home_list)
    protected void click03(){
        //发起请求
        IRequest iRequest = RetrofitUtil.getRetrofitUtil().create(IRequest.class);
        iRequest.commodityList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DataBean<HomeList>>() {
                    @Override
                    public void accept(DataBean<HomeList> homeListDataBean) throws Exception {
                        String toJson = new Gson().toJson(homeListDataBean);
                        resultShow.setText(toJson);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        resultShow.setText("发生错误了，未接收到任何数据！");
                    }
                });
    }
    //查找商品接口
    @OnClick(R.id.search)
    protected void click04(){
        //发起请求
        IRequest iRequest = RetrofitUtil.getRetrofitUtil().create(IRequest.class);
        iRequest.findCommodityByKeyword("手机",1,10)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DataBean<List<Commodity>>>() {
                    @Override
                    public void accept(DataBean<List<Commodity>> listDataBean) throws Exception {
                        String toJson = new Gson().toJson(listDataBean);
                        resultShow.setText(toJson);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        resultShow.setText("发生错误了，未接收到任何数据！");
                    }
                });
    }
}
