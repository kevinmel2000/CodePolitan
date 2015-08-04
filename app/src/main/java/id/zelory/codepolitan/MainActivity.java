/*
 * Copyright (c) 2015 Zelory.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package id.zelory.codepolitan;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import id.zelory.benih.BenihActivity;
import id.zelory.benih.fragment.BenihFragment;
import id.zelory.codepolitan.adapter.MainPagerAdapter;
import id.zelory.codepolitan.fragment.CategoryFragment;
import id.zelory.codepolitan.fragment.HomeFragment;
import id.zelory.codepolitan.fragment.NewsFragment;
import id.zelory.codepolitan.fragment.SettingFragment;
import id.zelory.codepolitan.fragment.TagFragment;
import id.zelory.codepolitan.fragment.UserFragment;
import timber.log.Timber;

public class MainActivity extends BenihActivity implements TabLayout.OnTabSelectedListener
{
    @Bind(R.id.view_pager) ViewPager viewPager;
    @Bind(R.id.tab_layout) TabLayout tabLayout;
    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected int getActivityView()
    {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewReady(Bundle bundle)
    {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        setUpViewPager();
        setUpTabLayout();

    }

    private void setUpViewPager()
    {
        List<BenihFragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new TagFragment());
        fragments.add(new UserFragment());
        fragments.add(new SettingFragment());

        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
    }

    private void setUpTabLayout()
    {
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.category);
        tabLayout.getTabAt(2).setIcon(R.drawable.tag);
        tabLayout.getTabAt(3).setIcon(R.drawable.user);
        tabLayout.getTabAt(4).setIcon(R.drawable.setting);
        tabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab)
    {
        switch (tab.getPosition())
        {
            case 0:
                getSupportActionBar().setTitle("Home");
                break;
            case 1:
                getSupportActionBar().setTitle("Category");
                break;
            case 2:
                getSupportActionBar().setTitle("Tag");
                break;
            case 3:
                getSupportActionBar().setTitle("Yours");
                break;
            case 4:
                getSupportActionBar().setTitle("Settings");
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab)
    {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab)
    {

    }
}
