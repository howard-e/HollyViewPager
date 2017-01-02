package com.github.florent37.beautifulviewpager.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.crashlytics.android.Crashlytics;
import com.github.florent37.beautifulviewpager.sample.fragment.ScrollBigImageFragment;
import com.github.florent37.hollyviewpager.HollyViewPager;
import com.github.florent37.hollyviewpager.HollyViewPagerConfigurator;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    int pageCount = 3;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.hollyViewPager)
    HollyViewPager hollyViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        hollyViewPager.getViewPager().setPageMargin(getResources().getDimensionPixelOffset(R.dimen.viewpager_margin));
        hollyViewPager.setConfigurator(new HollyViewPagerConfigurator() {
            @Override
            public View[] getHeaderViews() {
                // Custom header MUST have a cardview w/ id 'card' and a textview with id 'title' for now
                View thumbnail1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.thumbnail_header, null);
                ImageView thumbnailImage = (ImageView) thumbnail1.findViewById(R.id.thumbnail);
                thumbnailImage.setImageResource(R.drawable.background1);

                View thumbnail2 = LayoutInflater.from(MainActivity.this).inflate(R.layout.thumbnail_header, null);
                thumbnailImage = (ImageView) thumbnail2.findViewById(R.id.thumbnail);
                thumbnailImage.setImageResource(R.drawable.background2);

                View thumbnail3 = LayoutInflater.from(MainActivity.this).inflate(R.layout.thumbnail_header, null);
                thumbnailImage = (ImageView) thumbnail3.findViewById(R.id.thumbnail);
                thumbnailImage.setImageResource(R.drawable.background3);

                return new View[]{thumbnail1, thumbnail2, thumbnail3};
            }

            @Override
            public float getHeightPercentForPage(int page) {
                // return ((page + 4) % 10) / 10f;
                return -1;
            }
        });

        hollyViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            int[] imageViews = {R.drawable.background1, R.drawable.background2, R.drawable.background3};

            @Override
            public Fragment getItem(int position) {
                // return ScrollViewFragment.newInstance((String) getPageTitle(position));
                return ScrollBigImageFragment.newInstance((String) getPageTitle(position), getImage(position));
            }

            @Override
            public int getCount() {
                return pageCount;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "TITLE " + position;
            }

            public int getImage(int position) {
                return imageViews[position];
            }
        });
    }
}
