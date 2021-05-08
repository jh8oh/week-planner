package dev.ohjiho.weekplanner.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.ohjiho.weekplanner.R
import dev.ohjiho.weekplanner.WeekPlannerApplication
import dev.ohjiho.weekplanner.injection.task.TaskComponentProvider

class MainActivity : AppCompatActivity(), TaskComponentProvider {

    override val taskComponent by lazy {
        WeekPlannerApplication.INSTANCE.applicationComponent.taskComponentFactory.create(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}