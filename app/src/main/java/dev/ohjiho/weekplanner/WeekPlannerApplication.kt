package dev.ohjiho.weekplanner

import android.app.Application
import dev.ohjiho.weekplanner.injection.app.ApplicationComponent
import dev.ohjiho.weekplanner.injection.app.DaggerApplicationComponent

class WeekPlannerApplication : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    companion object {
        lateinit var INSTANCE: WeekPlannerApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}