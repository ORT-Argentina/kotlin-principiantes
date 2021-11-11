package com.varunbarad.highlightable_calendar_view

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.annotation.ColorInt
import java.text.SimpleDateFormat
import java.util.*

class DayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {
    var date: Calendar? = null
        private set

    private val dateFormat = SimpleDateFormat("dd", Locale.getDefault())

    internal fun bind(date: Calendar) {
        this.date = date

        this.text = this.dateFormat.format(date.time)
    }

    internal fun decorate(@ColorInt textColor: Int, @ColorInt backgroundColor: Int) {
        this.setTextColor(textColor)
        this.setBackgroundColor(backgroundColor)
    }
}
