package dev.ohjiho.weekplanner.ui.week.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.ohjiho.weekplanner.ui.week.WeekFragment

class WeekViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    val firstElementPosition = 50

    override fun createFragment(position: Int): Fragment {
        return WeekFragment.newInstance(position - firstElementPosition)
    }

    override fun getItemCount() = 150
}