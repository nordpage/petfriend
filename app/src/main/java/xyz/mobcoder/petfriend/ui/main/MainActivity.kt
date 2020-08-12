package xyz.mobcoder.petfriend.ui.main

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import xyz.mobcoder.petfriend.Extensions.getVersion
import xyz.mobcoder.petfriend.R
import xyz.mobcoder.petfriend.ViewPagerAdapter
import xyz.mobcoder.petfriend.ui.bottom.BottomDialogFragment
import xyz.mobcoder.petfriend.ui.list.ListFragment
import javax.inject.Inject


class MainActivity : AppCompatActivity(){

    @Inject lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pager!!.adapter = ViewPagerAdapter(this)
        version.text = "Ver: ${getVersion(this)}"



        version.setOnClickListener {
            val bottomDialogFragment: BottomDialogFragment =
                BottomDialogFragment.newInstance()
            bottomDialogFragment.show(
                supportFragmentManager,
                "dialog_fragment"
            )
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        FullScreencall()
    }

    fun FullScreencall() {
        if (Build.VERSION.SDK_INT < 19) {
            val v = this.window.decorView
            v.systemUiVisibility = View.GONE
        } else {
            //for higher api versions.
            val decorView = window.decorView
            val uiOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            decorView.systemUiVisibility = uiOptions
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }


}