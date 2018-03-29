package com.rcraggs.foodormedicinenow.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "medicine")
data class Medicine (
        @ColumnInfo(name="before") var hoursBefore: Int = 0,
        @ColumnInfo(name="after") var hoursAfter: Int = 0){

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}