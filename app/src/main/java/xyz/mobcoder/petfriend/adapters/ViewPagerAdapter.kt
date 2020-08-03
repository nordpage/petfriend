package xyz.mobcoder.petfriend

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import xyz.mobcoder.petfriend.ui.login.LoginFragment
import xyz.mobcoder.petfriend.ui.register.RegisterFragment
import java.lang.IllegalArgumentException

class ViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
      return when(position) {
            0 -> LoginFragment.newInstance()
            1 -> RegisterFragment.newInstance()
          else -> throw IllegalArgumentException("Error")
      }
    }
}