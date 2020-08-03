package xyz.mobcoder.petfriend.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import xyz.mobcoder.petfriend.BaseApp
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return baseApp
    }
}