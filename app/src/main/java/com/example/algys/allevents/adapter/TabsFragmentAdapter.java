package com.example.algys.allevents.adapter;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.algys.allevents.dto.EventsDTO;
import com.example.algys.allevents.fragment.AbstractTabFragment;
import com.example.algys.allevents.fragment.AllFragment;
import com.example.algys.allevents.fragment.TomorrowFragment;
import com.example.algys.allevents.fragment.MyFragment;
import com.example.algys.allevents.fragment.TodayFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter{

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    private AllFragment allFragment;

    private List<EventsDTO> data;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        this.data = new ArrayList<>();
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
        allFragment = AllFragment.getInstance(context, data);

        tabs = new HashMap<>();
        tabs.put(0, allFragment);
        tabs.put(1, TomorrowFragment.getInstance(context));
        tabs.put(2, TodayFragment.getInstance(context));
        tabs.put(3, MyFragment.getInstance(context));
    }

    public void setData(List<EventsDTO> data) {
        this.data = data;
        allFragment.refreshData(data);
    }
}
