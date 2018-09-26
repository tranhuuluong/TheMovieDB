package com.tranhuuluong.themoviedb.repository.mapper;

import com.tranhuuluong.themoviedb.domain.model.ImageConfig;
import com.tranhuuluong.themoviedb.domain.model.ImageSize;
import com.tranhuuluong.themoviedb.repository.response.ImageConfigEntity;
import com.tranhuuluong.themoviedb.repository.response.ImageConfigResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by luongtran on 9/25/18.
 */

public class ImageConfigMapper extends ModelMapper<ImageConfig, ImageConfigResponse> {

    @Inject
    public ImageConfigMapper() {
    }

    @Override
    public ImageConfig transform(ImageConfigResponse imageConfigResponse) {
        ImageConfigEntity imageConfigEntity = imageConfigResponse.images;

        Map<ImageSize, String> mapBackdropSizes = new HashMap<>();
        mapBackdropSizes.put(ImageSize.SMALL, getSizeWithFallBack(imageConfigEntity.backdrop_sizes, "w300"));
        mapBackdropSizes.put(ImageSize.MEDIUM, getSizeWithFallBack(imageConfigEntity.backdrop_sizes, "w780"));
        mapBackdropSizes.put(ImageSize.SMALL, getSizeWithFallBack(imageConfigEntity.backdrop_sizes, "w1280"));
        mapBackdropSizes.put(ImageSize.SMALL, getSizeWithFallBack(imageConfigEntity.backdrop_sizes, "original"));

        Map<ImageSize, String> mapLogoSizes = new HashMap<>();
        mapLogoSizes.put(ImageSize.SMALL, getSizeWithFallBack(imageConfigEntity.logo_sizes, "w45"));
        mapLogoSizes.put(ImageSize.MEDIUM, getSizeWithFallBack(imageConfigEntity.logo_sizes, "w185"));
        mapLogoSizes.put(ImageSize.SMALL, getSizeWithFallBack(imageConfigEntity.logo_sizes, "w500"));
        mapLogoSizes.put(ImageSize.SMALL, getSizeWithFallBack(imageConfigEntity.logo_sizes, "original"));

        Map<ImageSize, String> mapPosterSizes = new HashMap<>();
        mapPosterSizes.put(ImageSize.SMALL, getSizeWithFallBack(imageConfigEntity.backdrop_sizes, "w342"));
        mapPosterSizes.put(ImageSize.MEDIUM, getSizeWithFallBack(imageConfigEntity.backdrop_sizes, "w500"));
        mapPosterSizes.put(ImageSize.SMALL, getSizeWithFallBack(imageConfigEntity.backdrop_sizes, "780"));
        mapPosterSizes.put(ImageSize.SMALL, getSizeWithFallBack(imageConfigEntity.backdrop_sizes, "original"));

        Map<ImageSize, String> mapProfileSizes = new HashMap<>();
        mapProfileSizes.put(ImageSize.SMALL, getSizeWithFallBack(imageConfigEntity.backdrop_sizes, "w45"));
        mapProfileSizes.put(ImageSize.MEDIUM, getSizeWithFallBack(imageConfigEntity.backdrop_sizes, "w185"));
        mapProfileSizes.put(ImageSize.SMALL, getSizeWithFallBack(imageConfigEntity.backdrop_sizes, "h632"));
        mapProfileSizes.put(ImageSize.SMALL, getSizeWithFallBack(imageConfigEntity.backdrop_sizes, "original"));

        return new ImageConfig(
                imageConfigEntity.base_url,
                mapBackdropSizes,
                mapLogoSizes,
                mapPosterSizes,
                mapProfileSizes);
    }

    private String getSizeWithFallBack(List<String> listOfSize, String targetSize) {
        if (listOfSize.isEmpty()) {
            return "";
        }
        if (listOfSize.contains(targetSize)) {
            return targetSize;
        } else if (listOfSize.contains("original")) {
            return "original";
        } else {
            return listOfSize.get(listOfSize.size() -1);
        }
    }
}
