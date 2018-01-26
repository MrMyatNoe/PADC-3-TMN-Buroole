package com.myanmar.tmn.buroole.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myanmar.tmn.buroole.R;
import com.myanmar.tmn.buroole.data.vo.PromotionsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by msi on 1/5/2018.
 */

public class ItemPromotionViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_promotion_discount)
    TextView promotionDiscount;

    @BindView(R.id.tv_promotion_period)
    TextView promotionPeriod;

    @BindView(R.id.iv_promotion_item)
    ImageView promotionItem;

    @BindView(R.id.tv_shop_name)
    TextView shopName;

    @BindView(R.id.tv_reviewer)
    TextView reviewer;

    public ItemPromotionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setPromotions(PromotionsVO promotions){
        promotionDiscount.setText(promotions.getPromotionTitle());
        promotionPeriod.setText(promotions.getPromotionUntil());
        shopName.setText(promotions.getPromotionShopVO().getBuppleShopName());
        reviewer.setText(promotions.getPromotionShopVO().getBurppleShopArea());
        /*Glide.with(promotionItem.getContext()).load(promotions.getPromotionImage())
                .into(promotionItem);*/
    }
}
