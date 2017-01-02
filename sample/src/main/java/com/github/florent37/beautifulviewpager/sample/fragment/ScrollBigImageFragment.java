package com.github.florent37.beautifulviewpager.sample.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.beautifulviewpager.sample.R;
import com.github.florent37.hollyviewpager.HollyViewPagerBus;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Howard.
 */

public class ScrollBigImageFragment extends Fragment {

    @Bind(R.id.scrollView)
    ObservableScrollView scrollView;

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.image)
    ImageView image;

    public static ScrollBigImageFragment newInstance(String title, int image) {
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putInt("image", image);
        ScrollBigImageFragment fragment = new ScrollBigImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_scroll_big_image, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        title.setText(getArguments().getString("title"));
        image.setImageResource(getArguments().getInt("image"));
        HollyViewPagerBus.registerScrollView(getActivity(), scrollView);
    }
}