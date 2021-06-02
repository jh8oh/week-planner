package dev.ohjiho.weekplanner.ui.task.editor

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dev.ohjiho.weekplanner.R
import dev.ohjiho.weekplanner.databinding.DialogTaskDueWeekBinding
import dev.ohjiho.weekplanner.injection.task.TaskComponentProvider
import javax.inject.Inject

class TaskDueWeekDialog : DialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val binding: DialogTaskDueWeekBinding by lazy{
        DataBindingUtil.inflate(
            LayoutInflater.from(requireContext()),
            R.layout.dialog_task_due_week,
            null,
            false
        )
    }
    private val viewModel by viewModels<TaskEditorViewModel> { viewModelFactory }

    companion object {
        const val TAG = "TaskDueWeekDialog"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as TaskComponentProvider).taskComponent.inject(this)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding.viewModel = viewModel

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setTitle(R.string.dialog_task_due_week_title)
                setView(binding.root)
                setPositiveButton(R.string.dialog_task_due_week_positive_button) { dialog, _ ->
                    viewModel.updateTaskWeek()
                    dialog.dismiss()
                }
                setNegativeButton(R.string.dialog_task_due_week_negative_button) { dialog, _ ->
                    dialog.cancel()
                }
            }.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}