package com.example.spido_matrix2.formatter

import com.stfalcon.chatkit.utils.DateFormatter
import java.util.Date


class RoomListDateFormatter {
    override fun format(date: Date): String {
        return if (DateFormatter.isToday(date)) {
            DateFormatter.format(date, DateFormatter.Template.TIME)
        } else if (DateFormatter.isYesterday(date)) {
            "Yesterday"
        } else if (DateFormatter.isCurrentYear(date)) {
            DateFormatter.format(date, DateFormatter.Template.STRING_DAY_MONTH)
        } else {
            DateFormatter.format(date, DateFormatter.Template.STRING_DAY_MONTH_YEAR)
        }
    }
}