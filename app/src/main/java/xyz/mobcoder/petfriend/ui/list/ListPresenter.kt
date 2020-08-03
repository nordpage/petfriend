package xyz.mobcoder.petfriend.ui.list

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers
import xyz.mobcoder.petfriend.Pet
import xyz.mobcoder.petfriend.api.ApiService
import xyz.mobcoder.petfriend.model.Response

/**
 * Created by ogulcan on 07/02/2018.
 */
class ListPresenter: ListContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: ApiService = ApiService.create()
    private lateinit var view: ListContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: ListContract.View) {
        this.view = view
    }

    override suspend fun loadData(token: String) {
        var subscribe = api.getPets(token).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list: Response<List<Pet>>? ->
                view.showProgress(false)
                view.loadDataSuccess(list!!.data!!.take(10))
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            })

        subscriptions.add(subscribe)
    }

    override fun deleteItem(item: Pet) {
      //  api.deleteUser(item.id)
    }
}