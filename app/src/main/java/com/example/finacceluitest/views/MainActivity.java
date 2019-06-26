package com.example.finacceluitest.views;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.finacceluitest.BaseActivity;
import com.example.finacceluitest.R;
import com.example.finacceluitest.adapters.ViewPagerAdapter;
import com.example.finacceluitest.fragments.DataPackageFragment;
import com.example.finacceluitest.fragments.PulsaFragment;

public class MainActivity extends BaseActivity {

    private TabLayout mTabMenuLayout;
    private ViewPager mViewMenuPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        mViewMenuPager = findViewById(R.id.viewMenuPager);
        setupViewPager(mViewMenuPager);

        mTabMenuLayout = findViewById(R.id.tabMenu);
        mTabMenuLayout.setupWithViewPager(mViewMenuPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PulsaFragment(), getString(R.string.txt_pulsa));
        adapter.addFragment(new DataPackageFragment(), getString(R.string.txt_data_package));
        viewPager.setAdapter(adapter);
    }
}
