package xyz.mobcoder.petfriend.ui.main

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import xyz.mobcoder.petfriend.R
import xyz.mobcoder.petfriend.ViewPagerAdapter
import xyz.mobcoder.petfriend.ui.bottom.BottomDialogFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pager!!.adapter = ViewPagerAdapter(this)
        try {
            val pInfo: PackageInfo = this.getPackageManager().getPackageInfo(packageName, 0)
            val ver = pInfo.versionName
            version.text = "Ver: $ver"
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        version.setOnClickListener {
            val bottomDialogFragment: BottomDialogFragment =
                BottomDialogFragment.newInstance()
            bottomDialogFragment.show(
                supportFragmentManager,
                "dialog_fragment"
            )
        }
    }

    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet
    ): View? {
        return super.onCreateView(parent, name, context, attrs)
    }
}