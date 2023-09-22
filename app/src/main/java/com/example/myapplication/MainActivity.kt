package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.camera.CameraActivity
import android.content.pm.PackageManager.PERMISSION_GRANTED

/**
 * Main activity of the app.
 * This activity will be launched after tapping on the app icon on the home screen.
 * Put your code here.
 */
class MainActivity : CameraActivity() {
    override lateinit var previewView: PreviewView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        previewView = findViewById(R.id.preview_view)

        if (checkCameraPermission()) {
            launchCamera()
        } else {
            requestCameraPermission()
        }
    }

    private fun checkCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.CAMERA
        ) == PERMISSION_GRANTED
    }

    private fun requestCameraPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(android.Manifest.permission.CAMERA),
            CAMERA_PERMISSION_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PERMISSION_GRANTED) {
                launchCamera()
            } else {
                Toast.makeText(this, "Camera permission required for app", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
