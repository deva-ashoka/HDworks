package org.hdworks.hdworks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by Dhruv on 08/01/18.
 */

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
public class MapsMarkerActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user receives a prompt to install
     * Play services inside the SupportMapFragment. The API invokes this method after the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        // get the locations in an array, then iterate through it add markers
        ArrayList<LatLng> locations = new ArrayList();

        // this can be done interatively through a for loop with the latitudes and longitudes coming from an array
        locations.add(new LatLng(30.243442, -1.432320));
        locations.add(new LatLng(-33.852, 151.211));
        locations.add(new LatLng(28.7041, 77.1025));

        // now mark the locations on the map
        for(LatLng location: locations){
            Marker marker = googleMap.addMarker(new MarkerOptions().position(location)
                    .title("Location Name")
                    .snippet("Work ID: XYZ"));
        }

        // move the map camera to the location of the ward (currently just moving to Delhi's coordinates)
        LatLng camera_location = new LatLng(28.7041, 77.1025);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(camera_location));
    }
}