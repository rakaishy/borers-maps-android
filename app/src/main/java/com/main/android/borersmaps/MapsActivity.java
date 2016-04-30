package com.main.android.borersmaps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ArrayList<String> rutasArray = new ArrayList<String>();

        rutasArray.add("Valle Dorado - Guadalupe");
        rutasArray.add("Sauzal - Maneadero");
        rutasArray.add("De aqui - Pa' allá");
        rutasArray.add("De un lado - Al otro");

        Spinner spinner = (Spinner) findViewById(R.id.rutas_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rutas_layout, rutasArray);
        adapter.setDropDownViewResource(R.layout.rutas_dropdown_layout);

        spinner.setAdapter(
                new NoSeleccion(
                        adapter,
                        R.layout.no_seleccion,
                        this));
        LinearLayout myLayout = (LinearLayout) findViewById(R.id.hl);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(10, 0, 0, 0);
        TextView a = new TextView(MapsActivity.this);
        a.setTextSize(15);
        a.setTextColor(Color.parseColor("#FFFFFF"));
        a.setLayoutParams(lp);
        a.setText("Costo: \n" +
                "Distancia:\n" +
                "Tiempo aproximado:\n");
        myLayout.addView(a);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        googleMap.setMyLocationEnabled(true);
        mMap = googleMap;
        mMap.setPadding(0, 100, 0, 0);
        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

        CameraUpdate center=
                CameraUpdateFactory.newLatLng(new LatLng(latitude,
                        longitude));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);

        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
    }

}
