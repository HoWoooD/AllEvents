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

import java.util.ArrayList;
import java.util.List;

public class AllFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_all;

    public static AllFragment getInstance(Context context){
        Bundle args = new Bundle();
        AllFragment fragment = new AllFragment();
        fragment.setArguments(args);
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
        rv.setAdapter(new EventsListAdapter(createMockEventsListData()));

        return view;
    }

    private List<EventsDTO> createMockEventsListData() {
        List<EventsDTO> data = new ArrayList<>();
        data.add(new EventsDTO("Item 1"));
        data.add(new EventsDTO("Item 2"));
        data.add(new EventsDTO("Item 3"));
        data.add(new EventsDTO("Item 4"));
        data.add(new EventsDTO("Item 5"));
        data.add(new EventsDTO("Item 6"));

        return data;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}


