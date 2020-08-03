package xyz.mobcoder.petfriend

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import kotlinx.android.synthetic.main.activity_main.*

object Extensions {

    fun getVersion(context: Context) : String {
        var ver:String? = null
        try {
            val pInfo: PackageInfo = context.getPackageManager().getPackageInfo(context.packageName, 0)
            ver = pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return ver!!
    }
}