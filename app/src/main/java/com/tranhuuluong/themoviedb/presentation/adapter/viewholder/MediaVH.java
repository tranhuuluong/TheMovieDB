package com.tranhuuluong.themoviedb.presentation.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.tranhuuluong.themoviedb.R;
import com.tranhuuluong.themoviedb.domain.model.ImageConfig;
import com.tranhuuluong.themoviedb.domain.model.ImageSize;
import com.tranhuuluong.themoviedb.domain.model.Media;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by luongtran on 9/26/18.
 */

public class MediaVH extends RecyclerView.ViewHolder {
    @Bind(R.id.imv_media_thumnail)
    ImageView imvMediaThumnail;
    @Bind(R.id.tv_rating)
    TextView tvRating;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    private ImageConfig imageConfig;

    public MediaVH(View itemView, ImageConfig imageConfig) {
        super(itemView);
        this.imageConfig = imageConfig;
        ButterKnife.bind(this, itemView);
    }

    public void bind(Media media) {
        tvRating.setText(String.valueOf(media.getRating()));
        tvTitle.setText(media.getTitle());
        String posterUrl = imageConfig.buildPosterUrl(media.getBackdropPath(), ImageSize.SMALL);
        Glide.with(itemView.getContext())
                .load(posterUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imvMediaThumnail);
    }
}
