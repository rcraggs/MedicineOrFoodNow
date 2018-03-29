package com.rcraggs.foodormedicinenow

import android.os.Bundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.rcraggs.foodormedicinenow.DataManager.hoursAfter
import com.rcraggs.foodormedicinenow.DataManager.hoursBefore
import kotlinx.android.synthetic.main.activity_config.*
import kotlinx.android.synthetic.main.content_config.*

class ConfigActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        setSupportActionBar(toolbar)

        // Set the current values in the boxes
        text_hours_before_food.setText("" + DataManager.hoursBefore)
        text_hours_after_food.setText("" + DataManager.hoursAfter)

        btn_config_update.setOnClickListener {
            saveSettings()
            finish()
        }
    }

    fun saveSettings() {
        DataManager.hoursBefore = Integer.parseInt(text_hours_before_food.text.toString())
        DataManager.hoursAfter = Integer.parseInt(text_hours_after_food.text.toString())
        DataManager.update(this)
    }
}
