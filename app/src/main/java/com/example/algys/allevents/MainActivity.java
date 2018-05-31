package com.example.algys.allevents;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.algys.allevents.adapter.TabsFragmentAdapter;
import com.example.algys.allevents.dto.EventsDTO;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private static final int LAYOUT = R.layout.activity_main;

    private Toolbar toolbar;
    private Drawer.Result drawerResult;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;

    private TabsFragmentAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar();
        initNavigationView();
        initTabs();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem){
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu);
    }

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new TabsFragmentAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        new AllEventsTask().execute();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onBackPressed() {
        if (drawerResult != null && drawerResult.isDrawerOpen()){
            drawerResult.closeDrawer();
        }
        else {
            super.onBackPressed();
        }
    }

    private void initNavigationView() {
        AccountHeader.Result accountHeader = createAccountHeader();

        drawerResult = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggleAnimated(true)
                .withAccountHeader(accountHeader)
                .addDrawerItems(
                        new SecondaryDrawerItem()
                        .withName(R.string.menu_item_profile)
                        .withIdentifier(1)
                        .withIcon(R.drawable.account),
                        new SecondaryDrawerItem()
                        .withName(R.string.menu_item_setting)
                        .withIdentifier(2)
                        .withIcon(R.mipmap.ic_settings),
                        new SecondaryDrawerItem()
                        .withName(R.string.menu_item_help)
                        .withIdentifier(3)
                        .withIcon(R.mipmap.ic_help_circle_outline),
                        new SecondaryDrawerItem()
                        .withName(R.string.menu_item_info)
                        .withIdentifier(4)
                        .withIcon(R.mipmap.ic_information_outline)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        switch (drawerItem.getIdentifier()) {
                            case 1:
                                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                                break;
                            case 2:
                                startActivity(new Intent(MainActivity.this, SettingActivity.class));
                                break;
                            case 3:
                                startActivity(new Intent(MainActivity.this, HelpActivity.class));
                                break;
                            case 4:
                                startActivity(new Intent(MainActivity.this, InfoActivity.class));
                                break;
                        }
                    }
                })
                .build();

    }

    private AccountHeader.Result createAccountHeader() {
        IProfile profile = new ProfileDrawerItem()
                .withEmail("Гость");

        return new AccountHeader()
                    .withActivity(this)
                    .withHeaderBackground(R.drawable.background_material)
                .addProfiles(profile)
                    .build();
    }

    private class AllEventsTask extends AsyncTask<Void, Void, EventsDTO>{

        @Override
        protected EventsDTO doInBackground(Void... voids) {
            RestTemplate template = new RestTemplate();
            template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            EventsDTO datat = new EventsDTO();
            return datat;
            //return template.getForObject(Constants.URL.GET_EVENTS_ITEM , EventsDTO.class);
        }

        @Override
        protected void onPostExecute(EventsDTO eventsDTO) {
            List<EventsDTO> data = new ArrayList<>();
            data.add(eventsDTO);
            adapter.setData(data);
        }
    }
}
