package br.zup.com.beagle.android

import android.app.Application

class DemoAndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BeagleSetup().init(this)
    }
}