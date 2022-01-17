package com.example.appbarber.util;


import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.appbarber.R;
import com.example.appbarber.Constaint;
import com.example.appbarber.Maker.ClusterMarker;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.ui.IconGenerator;
import com.squareup.picasso.Picasso;

public class MyClusterManagerRenderer extends DefaultClusterRenderer<ClusterMarker> {

    private final IconGenerator iconGenerator;
    private final ImageView imageView;
    private final  int markerWidth;
    private final  int markerHeight;

    public MyClusterManagerRenderer(Context context, GoogleMap map, ClusterManager<ClusterMarker> clusterManager) {
        super(context, map, clusterManager);
        this.iconGenerator = new IconGenerator(context.getApplicationContext());
        this.imageView = new ImageView(context.getApplicationContext());
        this.markerWidth = (int) context.getResources().getDimension(R.dimen.custom_marker_image);
        this.markerHeight = (int) context.getResources().getDimension(R.dimen.custom_marker_image);
        this.imageView.setLayoutParams(new ViewGroup.LayoutParams(markerWidth, markerHeight));
        int padding = (int) context.getResources().getDimension(R.dimen.custom_marker_padding);
        this.imageView.setPadding(padding, padding, padding, padding);
        this.iconGenerator.setContentView(imageView);
    }

    /**
     * Rendering of the individual ClusterItems
     * @param item
     * @param markerOptions
     */
    @Override
    protected void onBeforeClusterItemRendered(ClusterMarker item, MarkerOptions markerOptions) {
        //imageView.setImageResource(R.drawable.cartman_cop);
        Picasso.get().load(Constaint.URL+"storage/salon/"+item.getIconPicture()).into(imageView);
        Bitmap icon = iconGenerator.makeIcon();
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon)).title(item.getTitle());
    }


    @Override
    protected boolean shouldRenderAsCluster(Cluster cluster) {
        return false;
    }
}
