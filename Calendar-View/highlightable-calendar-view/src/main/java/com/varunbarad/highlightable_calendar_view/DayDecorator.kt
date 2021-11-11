package com.varunbarad.highlightable_calendar_view

import androidx.annotation.ColorInt
import com.varunbarad.highlightable_calendar_view.util.isSameDay
import com.varunbarad.highlightable_calendar_view.util.removeTime
import java.util.*

class DayDecorator(
    date: Calendar,
    @ColorInt val textColor: Int,
    @ColorInt val backgroundColor: Int
) {
    val date: Calendar = (date.clone() as Calendar).removeTime()

    fun clone(): DayDecorator {
        return DayDecorator(
            date = (this.date.clone() as Calendar),
            textColor = this.textColor,
            backgroundColor = this.backgroundColor
        )
    }

    override fun equals(other: Any?): Boolean {
        return if ((other != null) && (other is DayDecorator)) {
            this.date.isSameDay(other.date) && (this.textColor == other.textColor) && (this.backgroundColor == other.backgroundColor)
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return (this.date.timeInMillis + this.textColor + this.backgroundColor).toInt()
    }
}
