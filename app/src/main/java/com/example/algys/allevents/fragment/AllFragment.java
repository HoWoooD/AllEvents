package com.example.algys.allevents.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.algys.allevents.R;
import com.example.algys.allevents.adapter.EventsListAdapter;
import com.example.algys.allevents.dto.EventsDTO;

import java.util.List;

public class AllFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_all;

    private List<EventsDTO> data;
    private EventsListAdapter adapter;

    public static AllFragment getInstance(Context context, List<EventsDTO> data){
        Bundle args = new Bundle();
        AllFragment fragment = new AllFragment();
        fragment.setArguments(args);
        fragment.setData(data);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_all));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container,false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        adapter = new EventsListAdapter(data);
        rv.setAdapter(adapter);

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<EventsDTO> data) {
        this.data = data;
    }

    public void refreshData(List<EventsDTO> data){
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}


