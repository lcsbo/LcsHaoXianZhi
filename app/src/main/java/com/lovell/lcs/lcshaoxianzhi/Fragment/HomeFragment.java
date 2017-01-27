package com.lovell.lcs.lcshaoxianzhi.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lovell.lcs.lcshaoxianzhi.Bean.HomeBean_01;
import com.lovell.lcs.lcshaoxianzhi.R;
import com.lovell.lcs.lcshaoxianzhi.interfaceUtils.Home_01;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {
//    private ListView homeListView;
    private ImageView homeFragmentImage1;
    private ImageView homeFragmentImage5;
    private ImageView homeFragmentImage4;
    private ImageView homeFragmentImage3;
    private ImageView homeFragmentImage2;

    private TextView homeFragmentText1;
    private TextView homeFragmentText2;
    private TextView homeFragmentText3;
    private TextView homeFragmentText4;
    private TextView homeFragmentText5;
    private ViewPager home_ViewPager_ads;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);

        ///种类的网络请求
        initHomeRetrofit01();
        return view;

    }

    private void initHomeRetrofit01() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://api.haoxianzhi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Home_01 home_01 = retrofit.create(Home_01.class);
        Call<HomeBean_01> call = home_01.getData();
        call.enqueue(new Callback<HomeBean_01>() {
            @Override
            public void onResponse(Call<HomeBean_01> call, Response<HomeBean_01> response) {
                HomeBean_01.DataBean data = response.body().getData();


                String cate_name1 = data.getMainCategory().get(0).getCate_name();
                String cate_name2 = data.getMainCategory().get(1).getCate_name();
                String cate_name3 = data.getMainCategory().get(2).getCate_name();
                String cate_name4 = data.getMainCategory().get(3).getCate_name();
                String cate_name5 = data.getMainCategory().get(4).getCate_name();

                homeFragmentText1.setText(cate_name1);
                homeFragmentText2.setText(cate_name2);
                homeFragmentText3.setText(cate_name3);
                homeFragmentText4.setText(cate_name4);
                homeFragmentText5.setText(cate_name5);
//                Log.e("!!!!!!!!", "onResponse: "+cate_name1 );

                String main_img_url1 = data.getMainCategory().get(0).getMain_img_url();
                String main_img_url2 = data.getMainCategory().get(1).getMain_img_url();
                String main_img_url3 = data.getMainCategory().get(2).getMain_img_url();
                String main_img_url4 = data.getMainCategory().get(3).getMain_img_url();
                String main_img_url5 = data.getMainCategory().get(4).getMain_img_url();

                Picasso.with(getActivity()).load(main_img_url1).into(homeFragmentImage1);
                Picasso.with(getActivity()).load(main_img_url2).into(homeFragmentImage2);
                Picasso.with(getActivity()).load(main_img_url3).into(homeFragmentImage3);
                Picasso.with(getActivity()).load(main_img_url4).into(homeFragmentImage4);
                Picasso.with(getActivity()).load(main_img_url5).into(homeFragmentImage5);


            }

            @Override
            public void onFailure(Call<HomeBean_01> call, Throwable t) {

            }
        });


    }

    private void initView(View view) {

        homeFragmentImage1= (ImageView) view.findViewById(R.id.homeFragment_image1);
        homeFragmentImage2= (ImageView) view.findViewById(R.id.homeFragment_image2);
        homeFragmentImage3= (ImageView) view.findViewById(R.id.homeFragment_image3);
        homeFragmentImage4= (ImageView) view.findViewById(R.id.homeFragment_image4);
        homeFragmentImage5= (ImageView) view.findViewById(R.id.homeFragment_image5);

        homeFragmentText1= (TextView) view.findViewById(R.id.homeFragment_text1);
        homeFragmentText2= (TextView) view.findViewById(R.id.homeFragment_text2);
        homeFragmentText3= (TextView) view.findViewById(R.id.homeFragment_text3);
        homeFragmentText4= (TextView) view.findViewById(R.id.homeFragment_text4);
        homeFragmentText5= (TextView) view.findViewById(R.id.homeFragment_text5);


        //广告轮播
        home_ViewPager_ads = ((ViewPager) view.findViewById(R.id.home_viewPager_ads));

    }

}
