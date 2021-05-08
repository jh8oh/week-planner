package dev.ohjiho.weekplanner.ui.task.editor

import android.content.Context
import androidx.fragment.app.Fragment
import dev.ohjiho.weekplanner.injection.task.TaskComponentProvider

class TaskEditorFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as TaskComponentProvider).taskComponent.inject(this)
    }
}