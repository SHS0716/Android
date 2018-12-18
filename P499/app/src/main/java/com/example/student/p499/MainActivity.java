package com.example.student.p499;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng korea = new LatLng(37 , 126);
        mMap.addMarker(new MarkerOptions().position(korea).title("Marker in Korea"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(korea));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                GroundOverlayOptions groundOverlayOptions;
                groundOverlayOptions = new GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.iconarrowdownb128)).position(latLng,100f,100f);
                mMap.addGroundOverlay(groundOverlayOptions);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button2){
            goMap("1");
        }else if(v.getId()==R.id.button3){
            goMap("2");
        }else if(v.getId()==R.id.button4){
            goMap("3");
        }
    }

    private void goMap(String s) {
        LatLng go = null;
        String loc = "";
        switch (s){
            case "1 ": go = new LatLng(51.5154368,-0.2181006);
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case "2 ": go = new LatLng(40.4530541,-3.6905332);
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case "3 ": go = new LatLng(34.678395,135.4601306);
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
        }
        mMap.addMarker(new MarkerOptions().position(go).title("Marker in "));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(go,15));

    }


}
