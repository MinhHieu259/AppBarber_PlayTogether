package com.codingwithmitch.googlemaps1412022.Maker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.codingwithmitch.googlemaps1412022.Model.SalonGoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class ClusterMarker implements ClusterItem{
    private LatLng position;
    private String title;
    private String snippet;
    private String iconPicture;
    private SalonGoogleMap salon;

    public ClusterMarker(LatLng position, String title, String snippet, String iconPicture, SalonGoogleMap salon) {
        this.position = position;
        this.title = title;
        this.snippet = snippet;
        this.iconPicture = iconPicture;
        this.salon = salon;
    }

    public ClusterMarker() {
    }

    @NonNull
    @Override
    public LatLng getPosition() {
        return position;
    }

    @Nullable
    @Override
    public String getTitle() {
        return title;
    }

    @Nullable
    @Override
    public String getSnippet() {
        return snippet;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getIconPicture() {
        return iconPicture;
    }

    public void setIconPicture(String iconPicture) {
        this.iconPicture = iconPicture;
    }

    public SalonGoogleMap getSalon() {
        return salon;
    }

    public void setSalon(SalonGoogleMap salon) {
        this.salon = salon;
    }
}
