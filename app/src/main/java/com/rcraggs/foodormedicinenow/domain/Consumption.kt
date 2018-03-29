package com.rcraggs.foodormedicinenow.domain

import android.arch.persistence.room.*
import java.util.*

@Entity(tableName = "consumption")
class Consumption (){

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true) var id: Long = 0

    @TypeConverters(DateConverter::class)
    @ColumnInfo(name="taken")
    var taken: Date = Calendar.getInstance().time

    @TypeConverters(ConsumptionTypeConverter::class)
    @ColumnInfo(name="type")
    var type: ConsumptionType = ConsumptionType.FOOD

    enum class ConsumptionType private constructor(val code: Int) {
        FOOD(0),
        MEDICINE(1),
    }

    override fun toString(): String {
        return "$type at $taken"
    }

    override fun equals(other: Any?): Boolean {
        return if (other is Consumption)
            other.taken == this.taken &&
                    other.type == this.type
        else
            false
    }
}

class DateConverter {

    @TypeConverter
    fun fromTimestamp(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date): Long {
        return date.time
    }
}

class ConsumptionTypeConverter {

    @TypeConverter
    fun toConsumptionType(ordinal : Int): Consumption.ConsumptionType{
        return Consumption.ConsumptionType.values()[ordinal]
    }

    @TypeConverter
    fun toInt(type : Consumption.ConsumptionType) : Int {
        return type.ordinal
    }
}