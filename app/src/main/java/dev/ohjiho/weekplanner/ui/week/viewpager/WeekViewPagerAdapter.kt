package dev.ohjiho.weekplanner.ui.week.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.ohjiho.weekplanner.ui.week.single.WeekFragment
import dev.ohjiho.weekplanner.util.Constants.MAX_VALUE
import dev.ohjiho.weekplanner.util.Constants.MIDDLE_VALUE

class WeekViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return WeekFragment.newInstance(position - MIDDLE_VALUE)
    }

    override fun getItemCount() = MAX_VALUE
}