package dev.ohjiho.weekplanner.ui.week

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dev.ohjiho.weekplanner.R
import dev.ohjiho.weekplanner.databinding.FragmentWeekBinding
import dev.ohjiho.weekplanner.injection.week.WeekComponentProvider
import dev.ohjiho.weekplanner.util.Converters
import javax.inject.Inject

class WeekFragment : Fragment() {

    @Inject
    lateinit var weekViewModel: WeekViewModel       // Creates a separate instance of view model for each fragment

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as WeekComponentProvider).weekComponent.inject(this)

        weekViewModel.currentAdapterItem = diffFromCurrentWeek
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_week, container, false)

        with(binding) {


            number = weekViewModel.currentAdapterItem
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            Converters.getDisplayFromWeekInt(diffFromCurrentWeek)
    }
}