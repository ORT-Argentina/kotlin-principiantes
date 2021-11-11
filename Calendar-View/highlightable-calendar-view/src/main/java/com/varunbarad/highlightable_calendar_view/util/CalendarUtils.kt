@file:JvmName("CalendarUtils")

package com.varunbarad.highlightable_calendar_view.util

import java.util.*

/**
 * Checks if both dates fall under same month
 *
 * @param other date to compare against
 *
 * @return true if both are in same month, false otherwise
 */
internal fun Calendar.isSameMonth(other: Calendar): Boolean {
    return ((this.get(Calendar.ERA) == other.get(Calendar.ERA))
            && (this.get(Calendar.YEAR) == other.get(Calendar.YEAR))
            && (this.get(Calendar.MONTH) == other.get(Calendar.MONTH)))
}

/**
 * Checks if both dates are for same day
 *
 * @param other date to compare against
 *
 * @return true if both are for same date, false otherwise
 */
internal fun Calendar.isSameDay(other: Calendar): Boolean {
    return this.isSameMonth(other) && (this.get(Calendar.DAY_OF_MONTH) == other.get(Calendar.DAY_OF_MONTH))
}


/**
 * Checks if this date is for today
 *
 * @return true if the date is of today
 */
internal fun Calendar.isToday(): Boolean {
    return this.isSameDay(Calendar.getInstance())
}

/**
 * Check if the passed date is in the past
 *
 * @param date The date to check
 *
 * @return true if the passed date is older than today, false otherwise
 */
fun isPastDay(date: Date): Boolean {
    val calendar = Calendar.getInstance().removeTime()

    return date.before(calendar.time)
}

internal fun Calendar.getFullNameOfMonth(): String {
    return this.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
        ?: throw IllegalStateException()
}

internal fun Calendar.isThisCalendarOfPreviousMonthFrom(reference: Calendar): Boolean {
    val temp = (reference.clone() as Calendar).apply {
        add(Calendar.MONTH, -1)
    }
    return (temp.get(Calendar.MONTH) == this.get(Calendar.MONTH))
}

internal fun Calendar.isThisCalendarOfNextMonthFrom(reference: Calendar): Boolean {
    val temp = (reference.clone() as Calendar).apply {
        add(Calendar.MONTH, 1)
    }
    return (temp.get(Calendar.MONTH) == this.get(Calendar.MONTH))
}

internal fun Calendar.removeTime(): Calendar {
    return this.apply {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }
}
