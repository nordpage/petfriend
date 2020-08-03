package xyz.mobcoder.petfriend

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import xyz.mobcoder.petfriend.Extensions.getVersion

class MainActivity : AppCompatActivity() {
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

    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet
    ): View? {
        return super.onCreateView(parent, name, context, attrs)
    }
}