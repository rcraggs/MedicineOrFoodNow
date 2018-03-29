package com.rcraggs.foodormedicinenow

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_config.*

class ConfigActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        setSupportActionBar(toolbar)


        val button = findViewById<Button>(R.id.btn_config_update)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                saveSettings()
                finish()
            }
        })
    }

    fun saveSettings() {
        val beforeText = findViewById<TextView>(R.id.text_hours_before_food)
        val prefs = this.getSharedPreferences(Constants.PREFS, 0)

        with(prefs.edit()) {
            putInt(Constants.HOURS_BEFORE, Integer.parseInt(beforeText.text.toString()))
            prefs.edit().apply()
        }
    }
}
