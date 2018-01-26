package com.myanmar.tmn.buroole.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myanmar.tmn.buroole.R;
import com.myanmar.tmn.buroole.data.vo.GuidesVO;
import com.myanmar.tmn.buroole.viewHolder.ItemGuidesViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msi on 1/5/2018.
 */

public class ItemBurppleGuidesAdapter extends RecyclerView.Adapter<ItemGuidesViewHolder> {

    private List<GuidesVO> guidesList;

    public ItemBurppleGuidesAdapter() {
        guidesList = new ArrayList<>();
    }

    @Override
    public ItemGuidesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View newsItems = inflater.inflate(R.layout.activity_burpple_guides,parent,false);
        ItemGuidesViewHolder itemBruppleGuidesViewHolder = new ItemGuidesViewHolder(newsItems);
        return itemBruppleGuidesViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemGuidesViewHolder holder, int position) {
        holder.setGuides(guidesList.get(position));
    }

    @Override
    public int getItemCount() {
        return guidesList.size();
    }

    public void setGuides(List<GuidesVO> guidesList) {
        this.guidesList = guidesList;
        notifyDataSetChanged();
    }
}
