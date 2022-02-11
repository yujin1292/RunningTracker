package com.example.runningtracker.other

import android.Manifest
import android.content.Context
import android.os.Build
import pub.devrel.easypermissions.EasyPermissions
import java.util.concurrent.TimeUnit

object TrackingUtility {

    fun hasLocationPermissions(context: Context) =
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            EasyPermissions.hasPermissions(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        } else {
            EasyPermissions.hasPermissions(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }

    fun getFormattedStopWatchTime(ms: Long, includeMillis: Boolean = false): String {
        var milliseconds = ms
        val hours = TimeUnit.MILLISECONDS.toHours(milliseconds)
        milliseconds -= TimeUnit.HOURS.toMillis(hours)

        val minute = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
        milliseconds -= TimeUnit.MINUTES.toMillis(minute)

        val seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds)

        if(!includeMillis){
            return "${if(hours<10) "0" else ""}$hours:" +
                    "${if(minute<10) "0" else ""}$minute:" +
                    "${if(seconds<10) "0" else ""}$seconds"
        }

        milliseconds -= TimeUnit.SECONDS.toMillis(seconds)
        return "${if(hours<10) "0" else ""}$hours:" +
                "${if(minute<10) "0" else ""}$minute:" +
                "${if(seconds<10) "0" else ""}$seconds:" +
                "${if(milliseconds<10) "0" else ""}$milliseconds"


    }
}