package com.lovell.lcs.lcshaoxianzhi;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.lovell.lcs.lcshaoxianzhi.Fragment.GuanZhuFragment;
import com.lovell.lcs.lcshaoxianzhi.Fragment.HomeFragment;
import com.lovell.lcs.lcshaoxianzhi.Fragment.MessageFragment;
import com.lovell.lcs.lcshaoxianzhi.Fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioButton homeButtonHome;
    private RadioButton homeButtonGuanzhu;
    private RadioButton homeButtonFaBu;
    private RadioButton homeButtonMessage;
    private RadioButton homeButtonMy;
    private ImageView homeImageZhao;

    private Fragment HomeFragment;
    private Fragment GuanZhuFragment;
    private Fragment MessageFragment;
    private Fragment MyFragment;
    private FrameLayout frameLayout;

    private List<Fragment> dataFragment=new ArrayList<>();

    private Boolean flagImage=false;
//    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();

        initData();
        initListener();

    }

    private void initListener() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_fragment,dataFragment.get(0)).commit();


        //这里是Fragment的替换
        homeButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_fragment,dataFragment.get(0)).commit();
            }
        });

        homeButtonGuanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_fragment,dataFragment.get(1)).commit();

            }
        });

        homeButtonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_fragment,dataFragment.get(2)).commit();
            }
        });

        homeButtonMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.home_fragment,dataFragment.get(3)).commit();
            }
        });

    }

    private void initData() {
        dataFragment.add(HomeFragment);
        dataFragment.add(GuanZhuFragment);
        dataFragment.add(MessageFragment);
        dataFragment.add(MyFragment);
//        transaction = getSupportFragmentManager().beginTransaction();


    }


    private void initview() {
        homeButtonHome = ((RadioButton) findViewById(R.id.home_button_home));
        homeButtonHome.setChecked(true);
        homeButtonGuanzhu = ((RadioButton) findViewById(R.id.home_button_guanzhu));
//        homeButtonFaBu = ((RadioButton) findViewById(R.id.home_button_fabu));
        homeImageZhao = ((ImageView) findViewById(R.id.home_image_zhaoxiang));
        homeButtonMessage = ((RadioButton) findViewById(R.id.home_button_message));
        homeButtonMy = ((RadioButton) findViewById(R.id.home_button_my));

        btnSetImage(homeButtonHome,R.drawable.home);
        btnSetImage(homeButtonGuanzhu,R.drawable.guanzhu);
//        btnSetImage(homeButtonFaBu,R.drawable.zhaoxiang);
        btnSetImage(homeButtonMessage,R.drawable.message);
        btnSetImage(homeButtonMy,R.drawable.my);

        HomeFragment=new HomeFragment();
        GuanZhuFragment=new GuanZhuFragment();
        MessageFragment=new MessageFragment();
        MyFragment=new MyFragment();

        frameLayout= (FrameLayout) findViewById(R.id.home_fragment);

        //图片的点击监听
        setOnClick(homeImageZhao);

    }

    private void setOnClick(final ImageView homeImageZhao) {
        homeImageZhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagImage == false) {
                    homeImageZhao.setImageResource(R.drawable.navigation_temaibutton_press);
                    flagImage=true;
                }else {

                   homeImageZhao.setImageResource(R.drawable.navigation_temaibutton_normal);
                    flagImage=false;
                }
            }
        });
    }

    private void btnSetImage(RadioButton handpick,int id) {
        Drawable drawable1 = getResources().getDrawable(id);
        drawable1.setBounds(0, 0, 45, 45);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        handpick.setCompoundDrawables(null, drawable1, null, null);//只放左边
    }


}
