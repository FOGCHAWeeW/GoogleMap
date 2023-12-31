package com.example.googlemap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    FrameLayout map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        map=findViewById(R.id.map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);//объявление карты в фрагменте
        mapFragment.getMapAsync(this);//синхронизируем фрагмент и карту
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {//нужно implements OnMapReadyCallback чтобы запустить карту
        this.gMap = googleMap;
        LatLng mapRussia = new LatLng(60, 100);//добавляем координаты России
        this.gMap.addMarker(new MarkerOptions().position(mapRussia).title("Я РУССКИЙ!"));// добавление маркера
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapRussia));//делвем чтобы камера срузу переместилась на этот маркер

    }
}