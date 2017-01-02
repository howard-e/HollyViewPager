package com.github.florent37.hollyviewpager;

import android.view.View;

/**
 * Created by florentchampigny on 10/08/15.
 */
public interface HollyViewPagerConfigurator {

    View[] getHeaderViews();

    float getHeightPercentForPage(int page);

}
