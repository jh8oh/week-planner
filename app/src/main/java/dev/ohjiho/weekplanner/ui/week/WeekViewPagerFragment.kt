package dev.ohjiho.weekplanner.ui.week

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import dev.ohjiho.weekplanner.R
import dev.ohjiho.weekplanner.databinding.FragmentWeekViewpagerBinding
import dev.ohjiho.weekplanner.injection.week.WeekComponentProvider
import dev.ohjiho.weekplanner.util.Constants.MIDDLE_VALUE
import javax.inject.Inject

class WeekViewPagerFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentWeekViewpagerBinding
    private val weekViewModel by viewModels<WeekViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as WeekComponentProvider).weekComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_week_viewpager, container, false)

        with(binding) {
            val weekAdapter = WeekViewPagerAdapter(this@WeekViewPagerFragment)
            weekVp.apply {
                adapter = weekAdapter
                setCurrentItem(MIDDLE_VALUE + weekViewModel.currentAdapterItem, false)

                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        weekViewModel.currentAdapterItem = position - MIDDLE_VALUE
                    }
                })
            }

            addNewTaskFab.setOnClickListener {
                val action =
                    WeekViewPagerFragmentDirections.toTaskEditorFragment(weekViewModel.currentAdapterItem)
                root.findNavController().navigate(action)
            }
        }

        return binding.root
    }
}