package com.rcraggs.foodormedicinenow.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rcraggs.foodormedicinenow.DataManager
import com.rcraggs.foodormedicinenow.R
import kotlinx.android.synthetic.main.content_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btn_add.setOnClickListener() {
            if (validateForm()) {
                saveSettings()
                finish()
            }
        }
    }


    fun validateForm() : Boolean {

        var allOk = true

        if (rg_add_type.checkedRadioButtonId == -1){
            radio_medicine.setError("You must tell me what you did")
            allOk = false
        }
        return allOk
    }

    fun saveSettings() {


        DataManager.update(this)
    }
}
