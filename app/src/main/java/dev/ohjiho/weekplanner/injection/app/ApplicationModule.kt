package dev.ohjiho.weekplanner.injection.app

import android.content.Context
import dagger.Module
import dagger.Provides
import dev.ohjiho.weekplanner.WeekPlannerApplication

@Module
class ApplicationModule {
    @Provides
    @ApplicationScope
    fun provideContext(application: WeekPlannerApplication): Context =
        application.applicationContext
}