package dev.ohjiho.weekplanner.injection.app

import dagger.BindsInstance
import dagger.Component
import dev.ohjiho.weekplanner.WeekPlannerApplication
import dev.ohjiho.weekplanner.injection.task.TaskComponent
import dev.ohjiho.weekplanner.injection.viewmodel.ViewModelModule
import dev.ohjiho.weekplanner.injection.week.WeekComponent

@ApplicationScope
@Component(modules = [ApplicationModule::class, DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: WeekPlannerApplication): ApplicationComponent
    }

    val taskComponentFactory: TaskComponent.Factory
    val weekComponentFactory: WeekComponent.Factory
}