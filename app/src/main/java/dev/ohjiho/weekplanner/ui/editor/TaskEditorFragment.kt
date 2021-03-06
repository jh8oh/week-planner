package dev.ohjiho.weekplanner.ui.editor

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
import androidx.navigation.fragment.navArgs
import dev.ohjiho.weekplanner.R
import dev.ohjiho.weekplanner.databinding.FragmentTaskEditorBinding
import dev.ohjiho.weekplanner.injection.task.TaskComponentProvider
import javax.inject.Inject

class TaskEditorFragment : Fragment() {

    @Inject
    lateinit var taskEditorViewModel: TaskEditorViewModel

    private lateinit var binding: FragmentTaskEditorBinding
    private val args by navArgs<TaskEditorFragmentArgs>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as TaskComponentProvider).taskComponent.inject(this)

        taskEditorViewModel.editingTask = args.editingTask
        taskEditorViewModel.diffFromCurrentWeek = args.diffFromCurrentWeek
        taskEditorViewModel.updateTaskWeek()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_editor, container, false)

        with(binding) {
            lifecycleOwner = viewLifecycleOwner
            viewModel = taskEditorViewModel

            taskDueDateEt.setOnClickListener {
                root.findNavController().navigate(TaskEditorFragmentDirections.toNavTaskDueWeekDialog())
            }

            taskAddSaveButton.setOnClickListener {
                val success = taskEditorViewModel.trySaveTask()
                if (success){
                    root.findNavController()
                        .navigate(TaskEditorFragmentDirections.toNavWeekViewPagerFragment())
                }
            }
        }

        return binding.root
    }
}