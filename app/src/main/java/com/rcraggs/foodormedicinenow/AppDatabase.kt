package com.rcraggs.foodormedicinenow

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.rcraggs.foodormedicinenow.domain.Medicine

@Database(entities = [(Medicine::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun medicineDao(): MedicineDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, "medicine.db")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}

