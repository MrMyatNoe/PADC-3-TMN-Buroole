package com.myanmar.tmn.buroole.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myanmar.tmn.buroole.R;
import com.myanmar.tmn.buroole.data.vo.GuidesVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by msi on 1/5/2018.
 */

public class ItemGuidesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_burpple_guide)
    TextView burppleGuide;

    @BindView(R.id.img_burpple_guide_background)
    ImageView guideBackground;

    public ItemGuidesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setGuides(GuidesVO vo){
        //Glide.with(guideBackground.getContext()).load(vo.getBurppleGuideImage()).into(guideBackground);
        burppleGuide.setText(vo.getBurppleGuideTitle());
    }
}
