package dev.ohjiho.weekplanner.ui.week.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import dev.ohjiho.weekplanner.R
import dev.ohjiho.weekplanner.databinding.FragmentWeekViewpagerBinding
import dev.ohjiho.weekplanner.util.Converters.getDisplayFromWeekInt

class WeekViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentWeekViewpagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_week_viewpager, container, false)

        with(binding) {
            // Initial change to label toolbar
            (requireActivity() as AppCompatActivity).supportActionBar?.title =
                getDisplayFromWeekInt(0)

            val weekAdapter = WeekViewPagerAdapter(this@WeekViewPagerFragment)
            var diffFromCurrentWeek = 0
            weekVp.apply {
                adapter = weekAdapter
                currentItem = weekAdapter.firstElementPosition

                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)

                        diffFromCurrentWeek = position - weekAdapter.firstElementPosition

                        // Change label on toolbar
                        (requireActivity() as AppCompatActivity).supportActionBar?.title =
                            getDisplayFromWeekInt(diffFromCurrentWeek)
                    }
                })
            }

            addNewTaskFab.setOnClickListener {
                val action =
                    WeekViewPagerFragmentDirections.toTaskEditorFragment(diffFromCurrentWeek)
                root.findNavController().navigate(action)
            }
        }

        return binding.root
    }
}