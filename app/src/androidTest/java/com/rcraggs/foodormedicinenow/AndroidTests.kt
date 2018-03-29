package com.rcraggs.foodormedicinenow

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import android.arch.persistence.room.Room
import android.content.Context
import com.rcraggs.foodormedicinenow.domain.Consumption
import com.rcraggs.foodormedicinenow.domain.ConsumptionDao
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Before
import java.time.LocalDateTime
import java.util.*
import kotlin.properties.Delegates


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class AndroidTests {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.rcraggs.foodormedicinenow", appContext.packageName)
    }

    var db: AppDatabase by Delegates.notNull()
    var consDao: ConsumptionDao by Delegates.notNull()

    @Before
    fun createDB() {
        val context = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(context.applicationContext, AppDatabase::class.java).build();
        consDao = db.consumptionDao()
    }

    @After
    fun closeDb(){
        db.close()
    }

    @Test
    fun testCanGetLatest(){

        var c = Consumption()
        c.taken = Calendar.getInstance().time
        c.type = Consumption.ConsumptionType.FOOD

        var c2 = Consumption()
        c2.taken = Calendar.getInstance().time
        c2.type = Consumption.ConsumptionType.MEDICINE

        consDao.insert(c2)
        consDao.insert(c)

        val c3 = consDao.getLatest()

        assertThat(c3, equalTo(c2));
    }

    @Test
    fun testCanGetLatestFoodAndMedicine(){

        var c1 = Consumption()
        c1.taken = Calendar.getInstance().time
        c1.type = Consumption.ConsumptionType.FOOD

        var c2 = Consumption()
        c2.taken = Calendar.getInstance().time
        c2.type = Consumption.ConsumptionType.MEDICINE

        var c3 = Consumption()
        c3.taken = Calendar.getInstance().time
        c3.type = Consumption.ConsumptionType.FOOD

        var c4 = Consumption()
        c4.taken = Calendar.getInstance().time
        c4.type = Consumption.ConsumptionType.MEDICINE

        consDao.insert(c1)
        consDao.insert(c2)
        consDao.insert(c3)
        consDao.insert(c4)

        val c5 = consDao.getLatest(Consumption.ConsumptionType.FOOD)
        assertThat("Check latest Food", c3, equalTo(c5));

        val c6 = consDao.getLatest(Consumption.ConsumptionType.MEDICINE)
        assertThat("Check latest Medicine", c4, equalTo(c6));
    }
}
