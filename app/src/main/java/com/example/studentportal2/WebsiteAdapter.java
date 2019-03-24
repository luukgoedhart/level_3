package com.example.studentportal2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WebsiteAdapter extends RecyclerView.Adapter<WebsiteViewHolder>{
    private List<Website> mPortalObjects;

    public WebsiteAdapter(List<Website> mPortalObjects){
        this.mPortalObjects = mPortalObjects;
    }


    @NonNull
    @Override
    public WebsiteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_cell, viewGroup, false);
        WebsiteViewHolder viewHolder = new WebsiteViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WebsiteViewHolder portalObjectViewHolder, int i) {
        Website portalObject = mPortalObjects.get(i);
        portalObjectViewHolder.portalName.setText(portalObject.getmPortalName());
    }


    @Override
    public int getItemCount() {
        return mPortalObjects.size();
    }
}

