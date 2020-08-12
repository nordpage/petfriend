package xyz.mobcoder.petfriend.ui.main

import xyz.mobcoder.petfriend.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View {

    }

    interface Presenter:
        BaseContract.Presenter<View> {
        fun onDrawerOptionAboutClick()
    }
}