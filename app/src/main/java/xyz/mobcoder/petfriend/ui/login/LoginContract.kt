package xyz.mobcoder.petfriend.ui.login

import xyz.mobcoder.petfriend.ui.base.BaseContract

class LoginContract {

    interface View: BaseContract.View {
        fun onLogin(token: String)
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
    }

    interface Presenter:
        BaseContract.Presenter<View> {
        fun login(email: String, password: String)
    }
}