package dev.ohjiho.weekplanner.data.model

interface Task {
    var uid: Int
    var name: String
    var completed: Boolean
    var weekOfYear: Int
}