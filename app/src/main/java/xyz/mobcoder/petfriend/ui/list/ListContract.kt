package xyz.mobcoder.petfriend.ui.list

import xyz.mobcoder.petfriend.Pet
import xyz.mobcoder.petfriend.ui.base.BaseContract

class ListContract {

    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<Pet>)
//        fun loadDataAllSuccess(model: DetailsViewModel)
    }

    interface Presenter:
        BaseContract.Presenter<View> {
        fun loadData()
        fun loadDataAll()
        fun deleteItem(item: Pet)
    }
}