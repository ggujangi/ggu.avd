package com.ggu.avd.data

import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*


@Entity(tableName = "keywords")
class SearchKeyword(
        @PrimaryKey @ColumnInfo(name = "keyword") var keyword: String,
) {
    var insertDate: String = getCurrentTime()

    private fun getCurrentTime(): String {
        val dateFormat = SimpleDateFormat("yyyyMMddHHmmssSSSS", Locale.getDefault())
        val cal: Calendar = Calendar.getInstance(Locale.getDefault())
        return dateFormat.format(cal.time)
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<SearchKeyword>() {
            override fun areItemsTheSame(
                    oldItem: SearchKeyword,
                    newItem: SearchKeyword
            ): Boolean =
                    oldItem.keyword == newItem.keyword

            override fun areContentsTheSame(oldItem: SearchKeyword, newItem: SearchKeyword) =
                    oldItem.keyword == newItem.keyword
        }
    }
}
