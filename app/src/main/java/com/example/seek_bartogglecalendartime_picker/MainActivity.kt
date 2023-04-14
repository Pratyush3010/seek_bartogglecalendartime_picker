package com.example.seek_bartogglecalendartime_picker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton


class MainActivity : AppCompatActivity() {

    private lateinit var seektxt : TextView
    private lateinit var seekbar : SeekBar
    private lateinit var btntoggle : ToggleButton
    private lateinit var calendar: CalendarView
    private lateinit var txtCalendar : TextView
    private lateinit var  time : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         seektxt = findViewById(R.id.seektxt)
         seekbar = findViewById(R.id.seekbar)
        btntoggle = findViewById(R.id.togglebtn)
        calendar = findViewById(R.id.calendar)
        txtCalendar = findViewById(R.id.txtdate)
        time = findViewById(R.id.btntime)
        // Seekbar
        Seekbar()

        // Toggle Button
        Togglebutton()

        // Calendar
        Calendar()

        time.setOnClickListener {
            val intent : Intent = Intent(this@MainActivity,Time_Picker::class.java)
            startActivity(intent)
        }

    }







    fun Seekbar(){

        seekbar.max = 99
        // For Seek Bar

        seekbar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(seekbar: SeekBar?, progress: Int , p2: Boolean) {
                seektxt.text = (progress +1).toString()

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }

    @SuppressLint("ResourceAsColor")
    fun Togglebutton(){

        btntoggle.backgroundTintList
         btntoggle.setOnCheckedChangeListener { _, ischecked ->

             if (ischecked){

                 Toast.makeText(this, "Button ON", Toast.LENGTH_SHORT).show()
             }else{
                // btntoggle.setBackgroundColor(R.color.purple_500)
                 Toast.makeText(this, "Button OFF", Toast.LENGTH_SHORT).show()
             }
         }
    }


    fun Calendar() {
        calendar.setOnDateChangeListener(
            OnDateChangeListener { view, year, month, monthofday ->
                val Date = (monthofday.toString() + "-" + (month+1) + "-" + year)

                txtCalendar.text = Date
            }

        )
    }
}