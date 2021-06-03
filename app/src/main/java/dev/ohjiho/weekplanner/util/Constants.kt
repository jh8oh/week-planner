package dev.ohjiho.weekplanner.util

object Constants {
    const val MIDDLE_VALUE = 49
    const val MAX_VALUE = 99
    const val MIN_VALUE = 0

    val DISPLAY_VALUES = (0..99).toList().mapIndexed { index, _ ->
        Converters.getDisplayFromWeekInt(index - MIDDLE_VALUE)
    }
}