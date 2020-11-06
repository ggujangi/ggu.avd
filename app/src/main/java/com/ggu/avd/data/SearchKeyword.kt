package com.ggu.avd.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*


@Entity(tableName = "keywords")
class SearchKeyword(
        @PrimaryKey @ColumnInfo(name = "keyword") var keyword: String) {

    var insertDate: String = getCurrentTime()

    private fun getCurrentTime(): String {
        val dateFormat = SimpleDateFormat("yyyyMMddHHmmssSSSS", Locale.KOREAN)
                .apply { timeZone = TimeZone.getTimeZone("Asia/Seoul") }
        val cal: Calendar = Calendar.getInstance(Locale.KOREAN)
        return dateFormat.format(cal.time)
    }
}
