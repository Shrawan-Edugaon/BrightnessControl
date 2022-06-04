package com.example.brightnesscontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var mBrightnessLevel = 0.5f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekBar = findViewById<SeekBar>(R.id.brightnessControl)

        val brightness = findViewById<TextView>(R.id.brightnessControlText)
        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(seekBar: SeekBar?, process: Int, fromUser: Boolean) {
                mBrightnessLevel = process / 100f
                brightness.text = mBrightnessLevel.toString()
                val layoutParams = window.attributes
                layoutParams.screenBrightness = mBrightnessLevel
                window.attributes = layoutParams
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

    }
}