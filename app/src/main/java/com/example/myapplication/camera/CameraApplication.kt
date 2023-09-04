package com.example.myapplication.camera

import android.app.Application
import androidx.camera.camera2.Camera2Config
import androidx.camera.core.CameraXConfig

class CameraApplication : Application(), CameraXConfig.Provider {

    override fun getCameraXConfig(): CameraXConfig =
            Camera2Config.defaultConfig()
}