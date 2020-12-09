package com.ggu.avd.data

import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ggu.avd.utilities.AVD_COMMON_TYPE
import java.text.SimpleDateFormat
import java.util.*


@Entity(tableName = "types")
class AvdType(
        @PrimaryKey var type: String,
        var avdType :Int
) {
    var insertDate: String = getCurrentTime()

    private fun getCurrentTime(): String {
        val dateFormat = SimpleDateFormat("yyyyMMddHHmmssSSSS", Locale.getDefault())
        val cal: Calendar = Calendar.getInstance(Locale.getDefault())
        return dateFormat.format(cal.time)
    }


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<AvdType>() {
            override fun areItemsTheSame(
                    oldItem: AvdType,
                    newItem: AvdType
            ): Boolean =
                    oldItem.type == newItem.type

            override fun areContentsTheSame(oldItem: AvdType, newItem: AvdType) =
                    oldItem.type == newItem.type && oldItem.avdType == newItem.avdType
        }
    }
}
