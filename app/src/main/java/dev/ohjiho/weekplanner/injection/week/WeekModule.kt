package dev.ohjiho.weekplanner.injection.week

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.ohjiho.weekplanner.injection.viewmodel.ViewModelKey
import dev.ohjiho.weekplanner.ui.week.WeekViewModel
import dev.ohjiho.weekplanner.ui.week.WeekViewPagerViewModel

@Module
interface WeekModule {

    @WeekScope
    @Binds
    @IntoMap
    @ViewModelKey(WeekViewPagerViewModel::class)
    fun bindWeekViewPagerViewModel(viewModel: WeekViewPagerViewModel): ViewModel

    @WeekScope
    @Binds
    @IntoMap
    @ViewModelKey(WeekViewModel::class)
    fun bindWeekViewModel(viewModel: WeekViewModel): ViewModel
}