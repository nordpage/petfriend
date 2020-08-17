package xyz.mobcoder.petfriend.di.component

import androidx.appcompat.app.AppCompatActivity
import dagger.Component
import xyz.mobcoder.petfriend.BaseApp
import xyz.mobcoder.petfriend.di.module.ActivityModule
import xyz.mobcoder.petfriend.di.module.ApplicationModule
import xyz.mobcoder.petfriend.di.module.FragmentModule
import xyz.mobcoder.petfriend.ui.list.ListFragment
import xyz.mobcoder.petfriend.ui.login.LoginContract
import xyz.mobcoder.petfriend.ui.login.LoginFragment

@Component(modules = arrayOf(ApplicationModule::class, FragmentModule::class, ActivityModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)
    fun inject(fragment: LoginFragment)

}