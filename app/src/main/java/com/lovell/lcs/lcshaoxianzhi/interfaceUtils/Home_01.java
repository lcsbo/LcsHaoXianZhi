package com.lovell.lcs.lcshaoxianzhi.interfaceUtils;

import com.lovell.lcs.lcshaoxianzhi.Bean.HomeBean_01;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/1/6.
 * 这一部分的数据是：首页：精品推荐之前
 */

public interface Home_01 {


    @GET(value = "baseInfoApi/getMainCategoryList")
    Call<HomeBean_01> getData();

}
