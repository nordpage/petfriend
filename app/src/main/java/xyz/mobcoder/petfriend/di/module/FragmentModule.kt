package xyz.mobcoder.petfriend.di.module


import dagger.Module
import dagger.Provides
import xyz.mobcoder.petfriend.api.ApiService
import xyz.mobcoder.petfriend.ui.list.ListContract
import xyz.mobcoder.petfriend.ui.list.ListPresenter
import xyz.mobcoder.petfriend.ui.login.LoginContract
import xyz.mobcoder.petfriend.ui.login.LoginPresenter
import javax.inject.Singleton

/**
 * Created by ogulcan on 07/02/2018.
 */
@Module
class FragmentModule {


    @Provides
    @Singleton
    fun provideListPresenter(): ListContract.Presenter {
        return ListPresenter()
    }

    @Provides
    fun provideLoginPresenter(): LoginContract.Presenter {
        return LoginPresenter()
    }

    @Provides
    fun provideApiService(): ApiService {
        return ApiService.create()
    }
}