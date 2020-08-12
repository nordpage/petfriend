package xyz.mobcoder.petfriend.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_login.*
import xyz.mobcoder.petfriend.R
import xyz.mobcoder.petfriend.di.module.FragmentModule
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(), LoginContract.View {


    @Inject lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
        presenter.attach(this)

        loginBtn.setOnClickListener {
            presenter.login(login_field.text.toString(), password_field.text.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            LoginFragment()
    }

    private fun injectDependency() {
        val loginComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        loginComponent.inject(this)
    }

    override fun onLogin(token: String) {
        Toast.makeText(requireContext(), token, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress(show: Boolean) {
        prog.visibility = if (show) View.VISIBLE else View.GONE
        loginBtn.visibility = if (show) View.GONE else View.VISIBLE
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()

    }
}