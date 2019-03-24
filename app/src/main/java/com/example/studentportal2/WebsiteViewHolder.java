package com.example.studentportal2;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class WebsiteViewHolder extends RecyclerView.ViewHolder{
    public TextView portalName;
    public View view;

    public WebsiteViewHolder(View view) {
        super(view);
        portalName = itemView.findViewById(R.id.portalText);
        this.view = view;
    }
}
