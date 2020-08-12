package xyz.mobcoder.petfriend.ui.bottom

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.NonNull
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import xyz.mobcoder.petfriend.Extensions
import xyz.mobcoder.petfriend.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomDialogFragment : BottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.Widget_AppTheme_BottomSheet
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
FullScreencall()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_bottom_dialog, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        version.text = "Версия: ${Extensions.getVersion(requireContext())}"

    }
    companion object {

        @JvmStatic
        fun newInstance() = BottomDialogFragment()
    }

    fun FullScreencall() {
        if (Build.VERSION.SDK_INT < 19) {
            val v = requireActivity().window.decorView
            v.systemUiVisibility = View.GONE
        } else {
            //for higher api versions.
            val decorView = requireActivity().window.decorView
            val uiOptions =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            decorView.systemUiVisibility = uiOptions
        }
    }


}