package dev.ohjiho.weekplanner.ui.week.single.options

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.ohjiho.weekplanner.R
import dev.ohjiho.weekplanner.databinding.BottomSheetDialogTaskOptionsBinding
import dev.ohjiho.weekplanner.injection.week.WeekComponentProvider
import dev.ohjiho.weekplanner.util.getCurrentWeekInt
import javax.inject.Inject

class TaskOptionsBottomSheetDialog : BottomSheetDialogFragment() {

    @Inject
    lateinit var taskOptionsBottomSheetViewModel: TaskOptionsBottomSheetViewModel

    private lateinit var binding: BottomSheetDialogTaskOptionsBinding
    private val args by navArgs<TaskOptionsBottomSheetDialogArgs>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as WeekComponentProvider).weekComponent.inject(this)

        taskOptionsBottomSheetViewModel.task = args.task
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.bottom_sheet_dialog_task_options,
            container,
            false
        )

        with(binding) {
            viewModel = taskOptionsBottomSheetViewModel

            bottomSheetDialogTaskOptionsCompleteButton.setOnClickListener {
                taskOptionsBottomSheetViewModel.completeTask()
                dismiss()
            }

            bottomSheetDialogTaskOptionsProcrastinateButton.setOnClickListener {
                taskOptionsBottomSheetViewModel.procrastinateTask()
                dismiss()
            }

            bottomSheetDialogTaskOptionsEditButton.setOnClickListener {
                val diffFromCurrentWeek = getCurrentWeekInt() - args.task.weekOfYear
                val action = TaskOptionsBottomSheetDialogDirections.toNavTaskEditorFragment(
                    diffFromCurrentWeek,
                    args.task
                )
                findNavController().navigate(action)
            }

            bottomSheetDialogTaskOptionsDeleteButton.setOnClickListener {
                taskOptionsBottomSheetViewModel.deleteTask()
                dismiss()
            }
        }

        return binding.root
    }
}