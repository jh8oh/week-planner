package dev.ohjiho.weekplanner.ui.week

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dev.ohjiho.weekplanner.R
import dev.ohjiho.weekplanner.databinding.FragmentWeekBinding

class WeekFragment : Fragment() {

    private lateinit var binding: FragmentWeekBinding

    private val diffFromCurrentWeek by lazy { requireArguments().getInt(DIFF) }

    companion object {
        private const val DIFF = "Difference from current week"

        fun newInstance(diffFromCurrentWeek: Int): Fragment {
            return WeekFragment().apply {
                arguments = bundleOf(DIFF to diffFromCurrentWeek)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_week, container, false)

        with(binding) {
            number = diffFromCurrentWeek
        }

        return binding.root
    }
}