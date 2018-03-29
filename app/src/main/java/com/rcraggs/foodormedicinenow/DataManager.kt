package com.rcraggs.foodormedicinenow

import android.content.Context
import com.rcraggs.foodormedicinenow.domain.Medicine

object DataManager {

    private var db : AppDatabase? = null
    private var medicine: Medicine = Medicine()

    var hoursBefore: Int

        get(){
            return medicine.hoursBefore
        }

        set(value) {
            medicine.hoursBefore = value
        }

    fun update(context: Context){

        if (db == null)
            db = AppDatabase.getInstance(context)

        db?.medicineDao()?.insert(medicine)
    }

    fun restore(context: Context){

        if (db == null)
            db = AppDatabase.getInstance(context)

        medicine = db?.medicineDao()?.getMedicine() ?: Medicine()
    }

}