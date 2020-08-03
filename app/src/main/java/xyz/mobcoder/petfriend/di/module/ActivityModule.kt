package xyz.mobcoder.petfriend.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import xyz.mobcoder.petfriend.ui.main.MainContract
import xyz.mobcoder.petfriend.ui.main.MainPresenter

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}