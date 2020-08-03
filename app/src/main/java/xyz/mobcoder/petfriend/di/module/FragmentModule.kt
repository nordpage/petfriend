package xyz.mobcoder.petfriend.di.module


import dagger.Module
import dagger.Provides
import xyz.mobcoder.petfriend.api.ApiService
import xyz.mobcoder.petfriend.ui.list.ListContract
import xyz.mobcoder.petfriend.ui.list.ListPresenter

/**
 * Created by ogulcan on 07/02/2018.
 */
@Module
class FragmentModule {


    @Provides
    fun provideListPresenter(): ListContract.Presenter {
        return ListPresenter()
    }

    @Provides
    fun provideApiService(): ApiService {
        return ApiService.create()
    }
}