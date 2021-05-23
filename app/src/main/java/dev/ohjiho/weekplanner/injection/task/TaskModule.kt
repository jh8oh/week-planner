package dev.ohjiho.weekplanner.injection.task

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.ohjiho.weekplanner.injection.viewmodel.ViewModelKey
import dev.ohjiho.weekplanner.ui.task.editor.TaskEditorViewModel

@Module
interface TaskModule {

    @TaskScope
    @Binds
    @IntoMap
    @ViewModelKey(TaskEditorViewModel::class)
    fun bindTaskEditorViewModel(viewModel: TaskEditorViewModel): ViewModel
}