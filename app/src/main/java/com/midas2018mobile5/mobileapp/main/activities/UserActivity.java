package com.midas2018mobile5.mobileapp.main.activities;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.midas2018mobile5.mobileapp.R;
import com.midas2018mobile5.mobileapp.fragments.UserFragment1;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //fragment4개
        Fragment[] arrFragments = new Fragment[2];
        arrFragments[0] = new UserFragment1();
        arrFragments[1] = new UserFragment1();
        //arrFragments[2] = new UserFragment1();
        //arrFragments[3] = new UserFragment1();


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        MypagerAdapter adapter = new MypagerAdapter(getSupportFragmentManager(),arrFragments);
        viewPager.setAdapter(adapter);


        // 탭레이아웃이랑 viewpager연결
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        //view pager를 setup하면 getPageTitle에서 탭이름을 리턴해줘야함
    }
}

class MypagerAdapter extends FragmentPagerAdapter {

    Fragment[] arrFragments;

    public MypagerAdapter(FragmentManager fm, Fragment[] arrFragments) {
        super(fm);
        this.arrFragments = arrFragments;
    }

    // 0번째 아이템, 1번째 아이템 ...
    @Override
    public Fragment getItem(int position) {
        return arrFragments[position];
    }

    @Override
    public int getCount() {
        return arrFragments.length;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "메뉴";
            case 1:
                return "마이페이지";
            case 2:
                return "탭3";
            case 3:
                return "탭4";
            default:
                return "";
        }
    }
}
