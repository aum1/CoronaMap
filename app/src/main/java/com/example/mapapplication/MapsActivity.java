package com.example.mapapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Instrumentation;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private FusedLocationProviderClient lc;
    private final int PERMISSION_REQUEST_CODE = 3;
    private double userLan;
    private double userLon;
    public Button switchViewButton;

    ArrayList<Center> locations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        switchViewButton = (Button) findViewById(R.id.switchView);

        lc = LocationServices.getFusedLocationProviderClient(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // say hi

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.style_json));

        lc.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    userLan = location.getLatitude();
                    userLon = location.getLongitude();

                }
            }
        });

        LatLng user = new LatLng(userLan, userLon);

        locations.add(new Center(37.235640, -121.964760, "CareNow Urgent Care - Los Gatos", false));
        locations.add(new Center(37.288280, -121.995087, "CVS Health Drive Thru Testing", true));
        locations.add(new Center(37.291910, -121.985920, "Action Urgent Care", true));
        locations.add(new Center(37.310500, -122.023660, "Walgreens Drive Thru COVID-19 Testing", false));
        locations.add(new Center(37.325267, -122.011816, "San Joaquin County Public Health Lab", false));
        locations.add(new Center(37.323442, -121.989600, "Instant Urgent Care", true));
        locations.add(new Center(37.325517, -121.945539, "Forward Clinic", true));
        locations.add(new Center(37.351648, -121.992250, "Instant Urgent Care", true));
        locations.add(new Center(37.358561, -122.028159, "Elite Medical Center", true));
        locations.add(new Center(37.332017, -121.906899, "CVS Health Drive Thru Testing", true));
        locations.add(new Center(37.371209, -122.047440, "Instant Urgent Care", true));
        locations.add(new Center(37.387384, -121.988904, "One Medical", true));
        locations.add(new Center(37.262879, -121.813405, "Instant Urgent Care", true));
        locations.add(new Center(37.382301, -121.898331, "CareNow Urgent Care - San Jose", false));
        locations.add(new Center(37.405614, -122.139731, "Palo Alto Division", true));
        locations.add(new Center(37.546164, -122.301847, "Community Testing - San Mateo", true));
        locations.add(new Center(37.753259, -122.400119, "Community Testing - San Francisco", true));
        locations.add(new Center(37.808420, -122.253467, "Carbon Health - Oakland", true));
        locations.add(new Center(37.415623, -121.877517, "CareNow Urgent Care - Milpitas", false));
        locations.add(new Center(37.520822, 37.520822, "CVS - San Mateo", true));
        locations.add(new Center(37.462358, -122.431577, "Community Testing - Half Moon Bay", true));
        locations.add(new Center(37.465177, -122.142565, "Community Testing - East Palo Alto", true));
        locations.add(new Center(36.696667, -121.632409, "Natividad Hospital", true));
        locations.add(new Center(36.573612, -121.804832, "ARCpoint Labs of Monterey Bay", true));
        locations.add(new Center(36.578842, -121.913314, "Community Hospital of the Monterey Peninsula", true));
        locations.add(new Center(37.129183, -121.638430, "CVS Health Drive Thru Testing - Morgan Hill", true));
        locations.add(new Center(37.129183, -121.638430, "Community Testing San-Jose", true));
        locations.add(new Center(37.698228, -122.089797, "Eden Medical Center", false));
        locations.add(new Center(37.716403, -122.143628, "CityHealth Urgent Care", true));
        locations.add(new Center(37.743274, -122.169970, "Community Testing - Oakland", true));
        locations.add(new Center(37.767222, -122.177882, "CVS - Oakland", true));
        locations.add(new Center(37.797827, -122.261456, "Brown & Toland", true));
        locations.add(new Center(37.803802, -122.269464, "LifeLong Trust Health Center", true));
        locations.add(new Center(37.808420, -122.253467, "Carbon Health - Oakland", true));
        locations.add(new Center(37.926136, -122.052154, "John Muir Health Outpatient Center", true));
        locations.add(new Center(37.640018, -122.422398, "Dignity Health-GoHealth Urgent Care", true));
        locations.add(new Center(37.667845, -122.478519, "Community Testing - Daly City", true));
        locations.add(new Center(37.875980, -122.459011, "CVS - Tiburon", true));
        locations.add(new Center(37.782392, -122.442928, "Kaiser Permanente San Franciso", true));
        locations.add(new Center(37.786107, -122.448031, "UCSF Laurel Heights", true));
        locations.add(new Center(37.933833, -122.359390, "LifeLong William Jenkins Health Center", true));
        locations.add(new Center(36.080637, -119.069933, "CVS - Porterville", true));
        locations.add(new Center(36.196223, -119.314147, "CVS - Tulare", true));
        locations.add(new Center(36.297860, -119.330795, "CVS - Visalia", true));
        locations.add(new Center(36.340591, -119.347599, "Maj Medical Clinic", true));
        locations.add(new Center(36.327847, -119.295226, "Kaweah Delta Medical Center", true));
        locations.add(new Center(36.326497, -119.664563, "Community Testing - Hanford", true));
        locations.add(new Center(36.328792, -119.654581, "CVS - Hanford", true));
        locations.add(new Center(36.572887, -119.629057, "United Health Centers", true));
        locations.add(new Center(36.707153, -119.546998, "Sanger Community Center", true));
        locations.add(new Center(36.737549, -119.682811, "CVS - Fresno", true));
        locations.add(new Center(36.773334, -119.779366, "VA Central California Health Care System", true));
        locations.add(new Center(36.808662, -119.859383, "AFC Urgent Care Fresno", true));
        locations.add(new Center(36.809031, -119.687570, "Clovis Urgent Care", true));





        //red is yes appointment
        // cyan is no appointment

        for (int i = 0; i < locations.size(); i++) {

            if (locations.get(i).requiresAppt()) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(locations.get(i).getLan(), locations.get(i).getLng())).title(locations.get(i).getname()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            }
            else {
                mMap.addMarker(new MarkerOptions().position(new LatLng(locations.get(i).getLan(), locations.get(i).getLng())).title(locations.get(i).getname()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
            }

        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(locations.get(0).getLan(), locations.get(0).getLng()), 7.0f));

        mMap.setTrafficEnabled(true);

    }


    @Override
    public void onLocationChanged(Location location) {
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 7.0f);
        mMap.animateCamera(cameraUpdate);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public void switchView(View v) {

        if (switchViewButton.getText().toString().equals("Showing all")) {
            mMap.clear();
            showApptMarkers();
            switchViewButton.setText("Showing appointments only");

        }

        else if (switchViewButton.getText().toString().equals("Showing appointments only")) {
            mMap.clear();
            showNonMarkers();
            switchViewButton.setText("Showing nonappointments only");

        }

        else if (switchViewButton.getText().toString().equals("Showing nonappointments only"))  {
            mMap.clear();
            showAllMarkers();
            switchViewButton.setText("Showing all");

        }


    }

    public void showAllMarkers() {

        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).requiresAppt()) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(locations.get(i).getLan(), locations.get(i).getLng())).title(locations.get(i).getname()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            }
            else {
                mMap.addMarker(new MarkerOptions().position(new LatLng(locations.get(i).getLan(), locations.get(i).getLng())).title(locations.get(i).getname()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
            }
        }

    }

    public void showApptMarkers() {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).requiresAppt()) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(locations.get(i).getLan(), locations.get(i).getLng())).title(locations.get(i).getname()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

            }
        }
    }

    public void showNonMarkers() {
        for (int i = 0; i < locations.size(); i++) {
            if (!(locations.get(i).requiresAppt())) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(locations.get(i).getLan(), locations.get(i).getLng())).title(locations.get(i).getname()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

            }
        }
    }



}

