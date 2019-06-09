package com.example.apogeeeventsmock.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(EventsDataClassRoom::class) , version = 1)
abstract class EventsDatabase : RoomDatabase() {

    abstract fun eventsDao(): EventsDao

}