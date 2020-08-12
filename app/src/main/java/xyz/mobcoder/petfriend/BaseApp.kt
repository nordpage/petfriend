package xyz.mobcoder.petfriend

import android.view.View
import android.view.WindowManager
import androidx.multidex.MultiDexApplication
import xyz.mobcoder.petfriend.di.component.ApplicationComponent
import xyz.mobcoder.petfriend.di.component.DaggerApplicationComponent
import xyz.mobcoder.petfriend.di.module.ApplicationModule

class BaseApp: MultiDexApplication() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()

    }

    fun setup() {
        component = DaggerApplicationComponent.builder()
            .applicationModule(
                ApplicationModule(
                    this
                )
            ).build()
        component.inject(this)

    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}