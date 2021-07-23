package com.example.indonesiancity.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.indonesiancity.adapter.CardViewAdapter
import com.example.indonesiancity.data.CitiesData
import com.example.indonesiancity.data.City
import com.example.indonesiancity.R

class MainActivity : AppCompatActivity() {
    private lateinit var rvCity: RecyclerView
    private var list: ArrayList<City> = arrayListOf()
    private var title: String = "Indonesian City"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvCity = findViewById(R.id.rv_city)
        rvCity.setHasFixedSize(true)
        setTitle(title)
        list.addAll(CitiesData.listData)
        showRecyclerCardView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerCardView() {
        rvCity.layoutManager = LinearLayoutManager(this)
        val cardViewAdapter = CardViewAdapter(list)
        rvCity.adapter = cardViewAdapter
    }

    private fun setMode(select: Int){
        when(select) {
            R.id.ic_profile -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }
    }


}