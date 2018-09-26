package com.tranhuuluong.themoviedb.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tranhuuluong.themoviedb.R;
import com.tranhuuluong.themoviedb.domain.model.ImageConfig;
import com.tranhuuluong.themoviedb.domain.model.Media;
import com.tranhuuluong.themoviedb.presentation.adapter.viewholder.MediaVH;

import java.util.List;

/**
 * Created by luongtran on 9/26/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MediaVH> {
    private List<Media> medias;
    private LayoutInflater inflater;
    private ImageConfig imageConfig;

    public MovieAdapter(List<Media> medias, LayoutInflater inflater, ImageConfig imageConfig) {
        this.medias = medias;
        this.inflater = inflater;
        this.imageConfig = imageConfig;
    }

    @NonNull
    @Override
    public MediaVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MediaVH(inflater.inflate(R.layout.item_media, parent, false), imageConfig);
    }

    @Override
    public void onBindViewHolder(@NonNull MediaVH holder, int position) {
        holder.bind(medias.get(position));
    }

    @Override
    public int getItemCount() {
        return medias.size();
    }
}
