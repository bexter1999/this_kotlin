package com.platina125.googlemaps

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.platina125.googlemaps.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val LATLNG = LatLng(37.566418, 126.977943)

        val cameraPosition = CameraPosition.Builder()
            .target(LATLNG)
                // 줌 레벨이 높을수록 더 자세한 지도를 볼 수 있음
            .zoom(15.0f)
            .build()
        //지도에서 사용할 수 있는 카메라 정보가 생성
        val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
        //카메라 포지션을 기준으로 지도의 위치, 배율, 기울기 등이 변경되서 표시
        mMap.moveCamera(cameraUpdate)

        var bitmapDrawable: BitmapDrawable

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            bitmapDrawable = getDrawable(R.drawable.marker) as BitmapDrawable
        } else {
            bitmapDrawable = resources.getDrawable(R.drawable.marker) as BitmapDrawable
        }
        var scaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.bitmap, 100, 70, false)
        var discriptor = BitmapDescriptorFactory.fromBitmap(bitmapDrawable.bitmap)

        val markerOptions = MarkerOptions()
            .position(LATLNG)
            .title("Seoul City Hall")
            .snippet("37.566418, 126.977943")
            .icon(discriptor)

        // GoogleMap 객체의 addMarker() 메서드에 MarkerOptions를 전달하면 구글 지도에 마커가 추가됨
        mMap.addMarker(markerOptions)
    }
}