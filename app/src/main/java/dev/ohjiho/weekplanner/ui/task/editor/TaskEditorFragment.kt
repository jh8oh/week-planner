package dev.ohjiho.weekplanner.ui.task.editor

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import dev.ohjiho.weekplanner.R
import dev.ohjiho.weekplanner.databinding.FragmentTaskEditorBinding
import dev.ohjiho.weekplanner.injection.task.TaskComponentProvider
import dev.ohjiho.weekplanner.util.lazyLifecycleBind
import javax.inject.Inject

class TaskEditorFragment : Fragment(R.layout.fragment_task_editor) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val binding by lazyLifecycleBind { FragmentTaskEditorBinding.bind(requireView()) }
    private val viewModel by viewModels<TaskEditorViewModel> { viewModelFactory }
    private val args by navArgs<TaskEditorFragmentArgs>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as TaskComponentProvider).taskComponent.inject(this)
        viewModel.diffFromCurrentWeek = args.diffFromCurrentWeek
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.taskDueDateEt.setOnClickListener {
            val dialog = TaskDueWeekDialog()
            dialog.show(parentFragmentManager, TaskDueWeekDialog.TAG)
        }

        binding.taskAddSaveButton.setOnClickListener {

        }
    }
}