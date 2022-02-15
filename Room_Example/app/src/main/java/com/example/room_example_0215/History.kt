package com.example.room_example_0215

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class History (
    @PrimaryKey val uid : Int?,
    @ColumnInfo (name = "name") val name : String?
        )
