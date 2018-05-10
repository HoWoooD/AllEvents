package com.example.algys.allevents.adapter;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.algys.allevents.fragment.AbstractTabFragment;
import com.example.algys.allevents.fragment.AllFragment;
import com.example.algys.allevents.fragment.CategoryFragment;
import com.example.algys.allevents.fragment.PopularFragment;
import com.example.algys.allevents.fragment.TodayFragment;

import java.util.HashMap;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter{

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        initTabsMap(context);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap(Context context) {
        tabs = new HashMap<>();
        tabs.put(0, AllFragment.getInstance(context));
        tabs.put(1, TodayFragment.getInstance(context));
        tabs.put(2, PopularFragment.getInstance(context));
        tabs.put(3, CategoryFragment.getInstance(context));
    }
}
