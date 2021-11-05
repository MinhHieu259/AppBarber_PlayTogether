package com.example.appbarber.activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

import com.example.appbarber.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.appbarber.databinding.ActivityMapsBinding;


public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener, OnMapReadyCallback {
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private FusedLocationProviderClient mfusedLocationProviderclient;


    private final LatLng UTE = new LatLng(16.0773016, 108.2134243);
    private final LatLng DUT = new LatLng(16.0738013, 108.1499142);
    private final LatLng DUE = new LatLng(16.0473935, 108.2394734);

    private Marker markerUTE;
    private Marker markerDUT;
    private Marker markerDUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Add some markers to the map, and add a data object to each marker.
        markerUTE = googleMap.addMarker(new MarkerOptions()
                .position(UTE)
                .title("UTE"));
        markerUTE.setTag(0);

        markerDUT = googleMap.addMarker(new MarkerOptions()
                .position(DUT)
                .title("DUT"));
        markerDUT.setTag(0);

        markerDUE = googleMap.addMarker(new MarkerOptions()
                .position(DUE)
                .title("DUE"));
        markerDUE.setTag(0);

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(UTE));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(19.0f));
        // Set a listener for marker click.
        googleMap.setOnMarkerClickListener(this);
    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {

        }
    };

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        // Retrieve the data from the marker.
        Integer clickCount = (Integer) marker.getTag();

        // Check if a click count was set, then display the click count.
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();
        }

        // Return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}