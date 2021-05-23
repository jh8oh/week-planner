package dev.ohjiho.weekplanner.ui.task.editor

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import dev.ohjiho.weekplanner.R
import dev.ohjiho.weekplanner.databinding.DialogTaskDueWeekBinding
import dev.ohjiho.weekplanner.util.lazyLifecycleBind

class TaskDueWeekDialog : DialogFragment() {

    private val binding by lazyLifecycleBind { DialogTaskDueWeekBinding.bind(requireView()) }

    companion object {
        const val TAG = "TaskDueWeekDialog"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setTitle(R.string.dialog_task_due_week_title)
                setView(it.layoutInflater.inflate(R.layout.dialog_task_due_week, null))
                setPositiveButton(R.string.dialog_task_due_week_positive_button) { dialog, _ ->
                    dialog.dismiss()
                }
                setNegativeButton(R.string.dialog_task_due_week_negative_button) { dialog, _ ->
                    dialog.cancel()
                }
            }.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}