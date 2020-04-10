package com.marius.waterplants.dagger

import android.content.Context
import com.marius.waterplants.MyApplication
import com.marius.waterplants.model.RoomModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        ViewModelModule::class,
        MainModule::class,
        RoomModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(myApplication: MyApplication)
}