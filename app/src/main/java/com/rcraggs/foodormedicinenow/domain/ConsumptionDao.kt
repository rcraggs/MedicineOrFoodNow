package com.rcraggs.foodormedicinenow.domain

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface ConsumptionDao {

    @Query("SELECT * FROM consumption ORDER BY taken desc LIMIT 1")
    fun getLatest(): Consumption

    @Query("SELECT * FROM consumption WHERE type = :cType ORDER BY taken desc LIMIT 1")
    fun getLatest(cType: Consumption.ConsumptionType): Consumption

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(consumption: Consumption)
}

//
//
//@Dao
//interface MedicineDao {
//
//    @Query("SELECT * from medicine LIMIT 1")
//    fun getMedicine(): Medicine
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(medicine: Medicine)
//}