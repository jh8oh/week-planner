package dev.ohjiho.weekplanner.ui.task.editor

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dev.ohjiho.weekplanner.databinding.FragmentTaskEditorBinding
import dev.ohjiho.weekplanner.injection.task.TaskComponentProvider
import dev.ohjiho.weekplanner.util.lazyLifecycleBind

class TaskEditorFragment : Fragment() {

    private val binding by lazyLifecycleBind { FragmentTaskEditorBinding.bind(requireView()) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as TaskComponentProvider).taskComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.taskDueDateEt.setOnClickListener {
            val dialog = TaskDueWeekDialog()
            dialog.show(childFragmentManager, TaskDueWeekDialog.TAG)
        }

        binding.taskAddSaveButton.setOnClickListener {

        }
    }
}