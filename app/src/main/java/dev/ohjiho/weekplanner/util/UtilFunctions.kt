package dev.ohjiho.weekplanner.util

import java.time.LocalDate
import java.time.temporal.WeekFields

fun getCurrentWeekInt() = LocalDate.now().get(WeekFields.ISO.weekOfYear())