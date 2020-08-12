package xyz.mobcoder.petfriend.ui.login

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import xyz.mobcoder.petfriend.api.ApiService
import xyz.mobcoder.petfriend.model.Response
import xyz.mobcoder.petfriend.model.Token

class LoginPresenter: LoginContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: ApiService = ApiService.create()
    private lateinit var view: LoginContract.View

    override fun login(email: String, password: String) {
        var subscribe = api.loginUser(email, password).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({result: Response<Token>? ->
                view.showProgress(true)
                view.onLogin(result!!.data!!.token!!)
            },{error ->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            })
        subscriptions.add(subscribe)
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: LoginContract.View) {
        this.view = view
    }
}