package dev.ohjiho.weekplanner.ui.task.editor

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dev.ohjiho.weekplanner.R
import dev.ohjiho.weekplanner.injection.task.TaskComponentProvider
import javax.inject.Inject

class TaskDueWeekDialog : DialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<TaskDueWeekViewModel> { viewModelFactory }
    private lateinit var listener: Listener

    interface Listener {
        fun onPositiveClick(week: Int)
    }

    companion object {
        const val TAG = "TaskDueWeekDialog"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as TaskComponentProvider).taskComponent.inject(this)
        try {
            listener = context as Listener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement TaskDueWeekDialog.Listener")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setTitle(R.string.dialog_task_due_week_title)
                setView(it.layoutInflater.inflate(R.layout.dialog_task_due_week, null))
                setPositiveButton(R.string.dialog_task_due_week_positive_button) { dialog, _ ->
                    viewModel.dueWeek.value?.let { value -> listener.onPositiveClick(value) }
                    dialog.dismiss()
                }
                setNegativeButton(R.string.dialog_task_due_week_negative_button) { dialog, _ ->
                    dialog.cancel()
                }
            }.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}