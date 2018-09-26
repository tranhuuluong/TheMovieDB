package com.tranhuuluong.themoviedb.domain.model;

import java.util.Map;

/**
 * Created by luongtran on 9/25/18.
 */

public class ImageConfig {
    private String baseUrl;
    private Map<ImageSize, String> mapBackdropSizes;
    private Map<ImageSize, String> mapLogoSizes;
    private Map<ImageSize, String> mapPosterSizes;
    private Map<ImageSize, String> mapProfileSizes;

    public ImageConfig(String baseUrl, Map<ImageSize, String> mapBackdropSizes, Map<ImageSize, String> mapLogoSizes, Map<ImageSize, String> mapPosterSizes, Map<ImageSize, String> mapProfileSizes) {
        this.baseUrl = baseUrl;
        this.mapBackdropSizes = mapBackdropSizes;
        this.mapLogoSizes = mapLogoSizes;
        this.mapPosterSizes = mapPosterSizes;
        this.mapProfileSizes = mapProfileSizes;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Map<ImageSize, String> getMapBackdropSizes() {
        return mapBackdropSizes;
    }

    public void setMapBackdropSizes(Map<ImageSize, String> mapBackdropSizes) {
        this.mapBackdropSizes = mapBackdropSizes;
    }

    public Map<ImageSize, String> getMapLogoSizes() {
        return mapLogoSizes;
    }

    public void setMapLogoSizes(Map<ImageSize, String> mapLogoSizes) {
        this.mapLogoSizes = mapLogoSizes;
    }

    public Map<ImageSize, String> getMapPosterSizes() {
        return mapPosterSizes;
    }

    public void setMapPosterSizes(Map<ImageSize, String> mapPosterSizes) {
        this.mapPosterSizes = mapPosterSizes;
    }

    public Map<ImageSize, String> getMapProfileSizes() {
        return mapProfileSizes;
    }

    public void setMapProfileSizes(Map<ImageSize, String> mapProfileSizes) {
        this.mapProfileSizes = mapProfileSizes;
    }

    public String buildPosterUrl(String posterPath, ImageSize targetSize) {
        return baseUrl + mapBackdropSizes.get(targetSize) + posterPath;
    }
}
