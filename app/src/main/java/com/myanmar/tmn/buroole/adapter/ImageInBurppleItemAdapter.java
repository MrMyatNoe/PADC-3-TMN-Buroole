package com.myanmar.tmn.buroole.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myanmar.tmn.buroole.R;
import com.myanmar.tmn.buroole.viewItems.ImageInBurppleItem;

/**
 * Created by msi on 1/5/2018.
 */

public class ImageInBurppleItemAdapter extends PagerAdapter {

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ImageInBurppleItem inflater = (ImageInBurppleItem) layoutInflater.
                inflate(R.layout.activity_burpple_images,container,false);
        container.addView(inflater);
        return inflater;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
