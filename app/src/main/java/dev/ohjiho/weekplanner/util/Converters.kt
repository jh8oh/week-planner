package dev.ohjiho.weekplanner.util

import kotlin.math.absoluteValue

object Converters {

    @JvmStatic
    fun getDisplayFromWeekInt(index: Int): String {
        return when (index) {
            -1 -> "Last Week"
            0 -> "This Week"
            1 -> "Next Week"
            else -> {
                if (index > 0) {
                    "$index Weeks Later"
                } else {
                    "${index.absoluteValue} Weeks Ago"
                }
            }
        }
    }
}