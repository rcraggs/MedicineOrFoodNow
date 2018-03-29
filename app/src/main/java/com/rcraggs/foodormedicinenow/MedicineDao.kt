package com.rcraggs.foodormedicinenow

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.rcraggs.foodormedicinenow.domain.Medicine

@Dao interface MedicineDao {

    @Query("SELECT * from medicine LIMIT 1")
    fun getMedicine(): Medicine

    @Insert(onConflict = REPLACE)
    fun insert(medicine: Medicine)
}