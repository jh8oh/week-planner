package dev.ohjiho.weekplanner.data.model

import android.os.Parcelable

interface Task : Parcelable {
    var uid: Int
    var name: String
    var completed: Boolean
    var weekOfYear: Int
}