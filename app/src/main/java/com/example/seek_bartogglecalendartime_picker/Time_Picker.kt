package com.example.seek_bartogglecalendartime_picker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.TimePicker
import androidx.core.view.isInvisible
import java.sql.Time

class Time_Picker : AppCompatActivity() {

    private  lateinit var clocktimePicker: TimePicker
    private  lateinit var spinnertimePicker: TimePicker
    private lateinit var  clocktxt : TextView
    private lateinit var  spinnertxt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)

        clocktimePicker = findViewById(R.id.timepicker)
        spinnertimePicker = findViewById(R.id.timepicker2)
        clocktxt = findViewById(R.id.txttime)
        spinnertxt = findViewById(R.id.txttime2)


        OnClickClock()
        OnClickSpinner()
    }

    fun OnClickClock(){

        // for only AM or PM
        clocktimePicker.setOnTimeChangedListener { _, hour, minute ->
            var hour = hour
            var am_pm = ""

            when {
                hour == 0 -> {
                    hour += 12
                    am_pm = "AM"
                }
                hour == 12 -> am_pm = "PM"
                hour > 12 -> {
                    hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm  = "AM"
            }

            if (clocktxt != null){
                val hr = if (hour<10){
                                  "0" + hour
                                }else hour
                val min = if (minute<10){
                    "0" + minute
                }else minute

                // display

                val msg = "$hr : $min : $am_pm"
                clocktxt.text = msg
                spinnertxt.isInvisible
            }
        }
    }

    fun OnClickSpinner(){

        spinnertimePicker.setOnTimeChangedListener { _, hour, minute ->
            var hour = hour
            var am_pm = ""

            when {
                hour == 0 -> {
                    hour += 12
                    am_pm = "AM"
                }
                hour == 12 -> am_pm = "PM"
                hour > 12 -> {
                    hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm  = "AM"
            }

            if (spinnertxt != null){
                val hr = if (hour<10){
                    "0" + hour
                }else hour
                val min = if (minute<10){
                    "0" + minute
                }else minute

                // display

                val msg = "$hr : $min : $am_pm"
                spinnertxt.text = msg

            }
        }
    }
}