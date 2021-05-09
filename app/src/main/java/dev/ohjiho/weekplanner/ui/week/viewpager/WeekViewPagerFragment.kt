package dev.ohjiho.weekplanner.ui.week.viewpager

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import dev.ohjiho.weekplanner.R
import dev.ohjiho.weekplanner.databinding.FragmentWeekViewpagerBinding
import dev.ohjiho.weekplanner.util.Converters.getDisplayFromWeekInt
import dev.ohjiho.weekplanner.util.lazyLifecycleBind

class WeekViewPagerFragment : Fragment(R.layout.fragment_week_viewpager) {

    private val binding by lazyLifecycleBind { FragmentWeekViewpagerBinding.bind(requireView()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initial change to label toolbar
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getDisplayFromWeekInt(0)

        val weekAdapter = WeekViewPagerAdapter(this)
        binding.weekVp.apply {
            adapter = weekAdapter
            currentItem = weekAdapter.firstElementPosition

            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    // Change label on toolbar
                    (requireActivity() as AppCompatActivity).supportActionBar?.title =
                        getDisplayFromWeekInt(position - weekAdapter.firstElementPosition)
                }
            })
        }
    }
}