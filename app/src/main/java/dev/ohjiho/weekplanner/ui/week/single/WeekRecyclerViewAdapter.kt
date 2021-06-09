package dev.ohjiho.weekplanner.ui.week.single

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.ohjiho.weekplanner.data.db.entity.TaskEntity
import dev.ohjiho.weekplanner.databinding.ItemTaskBinding

class WeekRecyclerViewAdapter :
    ListAdapter<TaskEntity, WeekRecyclerViewAdapter.TaskItemViewHolder>(TaskComparator()) {

    class TaskItemViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(task: TaskEntity) {
            binding.task = task
            binding.executePendingBindings()
        }
    }

    class TaskComparator : DiffUtil.ItemCallback<TaskEntity>() {
        override fun areContentsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areItemsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean {
            return oldItem === newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }
}