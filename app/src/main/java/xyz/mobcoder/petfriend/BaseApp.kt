package xyz.mobcoder.petfriend

import android.app.Application
import xyz.mobcoder.petfriend.di.component.ApplicationComponent
import xyz.mobcoder.petfriend.di.module.ApplicationModule
import xyz.mobcoder.petfriend.di.component.DaggerApplicationComponent

class BaseApp: Application() {

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