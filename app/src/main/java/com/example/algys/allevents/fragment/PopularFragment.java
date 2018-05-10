package com.example.algys.allevents.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.algys.allevents.R;

public class PopularFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_example;

    public static PopularFragment getInstance(Context context){
        Bundle args = new Bundle();
        PopularFragment fragment = new PopularFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_popular));
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container,false);
        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }


}
