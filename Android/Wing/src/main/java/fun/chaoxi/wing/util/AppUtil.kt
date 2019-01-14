package `fun`.chaoxi.wing.util

import android.content.Context
import android.location.LocationManager


/**
 * @author Wing Gao
 * @date 2019/1/4 10:13
 * @description
 */

/**
 * 判断GPS是否可用
 */
fun isGpsEnable(context: Context): Boolean {
    val locationManager  = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    val gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    val network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    return gps || network
}