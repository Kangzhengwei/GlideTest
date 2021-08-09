package com.example.glidetest.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.glidetest.R;
import java.util.List;

public class CustomGalleryAdapter extends RecyclerView.Adapter<CustomGalleryAdapter.ViewHolder> {
    private static final float SCALE = 0.85f;
    private List<GalleryItemBean> data;
    private Context context;

    public CustomGalleryAdapter(List<GalleryItemBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null) {
            return null;
        }
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (context == null || holder == null || isEmptyList(data)) {
            return;
        }
     /*   ViewGroup.MarginLayoutParams lp = ((ViewGroup.MarginLayoutParams) holder.itemContent.getLayoutParams());
        if (position == 0) {
            holder.itemContent.setLayoutParams(lp);
        } else {
            lp.width = (int) (lp.width* SCALE);
            lp.height = (int) (lp.height * SCALE);
            holder.itemContent.setLayoutParams(lp);
        }*/
        Glide.with(context)
                .load(data.get(position).getImage())
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView itemContent;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            itemContent = itemView.findViewById(R.id.itemContent);
            imageView = itemView.findViewById(R.id.headView);
        }
    }

    public boolean isEmptyList(List list) {
        return list == null || list.size() == 0;
    }
}
