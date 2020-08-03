package xyz.mobcoder.petfriend.di.component

import dagger.Component
import xyz.mobcoder.petfriend.BaseApp
import xyz.mobcoder.petfriend.di.module.ApplicationModule

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}