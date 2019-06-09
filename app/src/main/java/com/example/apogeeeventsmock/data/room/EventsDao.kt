package com.example.apogeeeventsmock.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface EventsDao {

    @Query("SELECT * FROM EVENTS_TABLE")
    fun getEvents() : Flowable<List<EventsDataClassRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvents(event : List<EventsDataClassRoom>)

    @Query("DELETE FROM events_table")
    fun clearDatabase()

}