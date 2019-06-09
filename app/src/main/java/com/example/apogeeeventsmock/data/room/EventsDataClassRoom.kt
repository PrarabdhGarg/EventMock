package com.example.apogeeeventsmock.data.room

import android.support.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events_table")
data class EventsDataClassRoom (

    @PrimaryKey val id : Long,
    val name : String,
    val venue : String,
    val about : String,
    val rules : String,
    val date_time : String,
    val duration : Int

)
