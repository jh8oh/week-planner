package dev.ohjiho.weekplanner.injection.task

import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Subcomponent
import dev.ohjiho.weekplanner.ui.task.editor.TaskEditorFragment

@TaskScope
@Subcomponent(modules = [TaskModule::class])
interface TaskComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: AppCompatActivity): TaskComponent
    }

    fun inject(taskEditorFragment: TaskEditorFragment)
}