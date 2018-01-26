package com.myanmar.tmn.buroole.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myanmar.tmn.buroole.R;
import com.myanmar.tmn.buroole.data.vo.PromotionsVO;
import com.myanmar.tmn.buroole.viewHolder.ItemPromotionViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msi on 1/5/2018.
 */

public class ItemBurpplePromotionsAdapter extends RecyclerView.Adapter<ItemPromotionViewHolder> {

    private List<PromotionsVO> mPromotionList;

    public ItemBurpplePromotionsAdapter() {
        mPromotionList = new ArrayList<>();
    }

    @Override
    public ItemPromotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View newsItems = inflater.inflate(R.layout.activity_burpple_promotions,parent,false);
        ItemPromotionViewHolder itemPromotionViewHolder = new ItemPromotionViewHolder(newsItems);
        return itemPromotionViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemPromotionViewHolder holder, int position) {
        holder.setPromotions(mPromotionList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPromotionList.size();
    }

    public void setPromotions(List<PromotionsVO> mPromotionList){
        this.mPromotionList = mPromotionList;
        notifyDataSetChanged();
    }
}
