package com.rcraggs.foodormedicinenow.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.rcraggs.foodormedicinenow.DataManager
import com.rcraggs.foodormedicinenow.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        fab_add_consume.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
            true
        }
    }

    override fun onStart() {
        super.onStart()
        DataManager.restore(this)
        setLabel()
    }

    fun setLabel() {
        home_label.text = DataManager.hoursBefore.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            R.id.action_settings -> {
                val intent = Intent(this, ConfigActivity::class.java)
                startActivity(intent)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
