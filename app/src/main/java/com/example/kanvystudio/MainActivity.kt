package com.example.kanvystudio

import android.Manifest.permission
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kanvystudio.fragments.Splash_Screen
import java.util.*

class MainActivity : AppCompatActivity() {
    public var REQUEST_ID_MULTIPLE_PERMISSIONS =1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            checkAndRequestPermissions1()
            supportFragmentManager.beginTransaction().add(R.id.content_frame,Splash_Screen.newInstance("","")).commit()
    }
    private fun checkAndRequestPermissions1(): Boolean {
        val location = ContextCompat.checkSelfPermission(this, permission.ACCESS_COARSE_LOCATION)
        val finelocation =ContextCompat.checkSelfPermission(this, permission.ACCESS_FINE_LOCATION)
        val listPermissionsNeeded: MutableList<String> = ArrayList()
        if (location != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(permission.ACCESS_FINE_LOCATION)
            listPermissionsNeeded.add(permission.ACCESS_COARSE_LOCATION)
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(
                this,
                listPermissionsNeeded.toTypedArray(),
                REQUEST_ID_MULTIPLE_PERMISSIONS
            )
            return false
        }
        return true
    }
}