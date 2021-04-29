package dev.ohjiho.weekplanner.ui.week

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import dev.ohjiho.weekplanner.R
import dev.ohjiho.weekplanner.databinding.FragmentWeekBinding
import dev.ohjiho.weekplanner.util.lazyLifecycleBind

class WeekFragment : Fragment(R.layout.fragment_week) {

    private val binding by lazyLifecycleBind { FragmentWeekBinding.bind(requireView()) }

    private val diffFromCurrentWeek by lazy { requireArguments().getInt(DIFF) }

    companion object {
        private const val DIFF = "Difference from current week"

        fun newInstance(diffFromCurrentWeek: Int): Fragment {
            return WeekFragment().apply {
                arguments = bundleOf(DIFF to diffFromCurrentWeek)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.number = diffFromCurrentWeek
    }
}