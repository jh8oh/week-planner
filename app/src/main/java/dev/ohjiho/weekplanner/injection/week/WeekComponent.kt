package dev.ohjiho.weekplanner.injection.week

import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Subcomponent
import dev.ohjiho.weekplanner.ui.week.single.WeekFragment
import dev.ohjiho.weekplanner.ui.week.single.options.TaskOptionsBottomSheetDialog
import dev.ohjiho.weekplanner.ui.week.viewpager.WeekViewPagerFragment

@WeekScope
@Subcomponent(modules = [WeekModule::class])
interface WeekComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: AppCompatActivity): WeekComponent
    }

    fun inject(weekViewPagerFragment: WeekViewPagerFragment)
    fun inject(weekFragment: WeekFragment)
    fun inject(taskOptionsBottomSheetDialog: TaskOptionsBottomSheetDialog)
}