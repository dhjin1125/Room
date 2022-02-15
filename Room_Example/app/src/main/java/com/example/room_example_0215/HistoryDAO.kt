package com.example.room_example_0215

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDAO {
    @Query("SELECT * FROM history")
    fun getAll() : List<History>

    @Insert
    fun insertHistory(history: History)

    @Query("DELETE FROM history")
    fun deleteAll()
}