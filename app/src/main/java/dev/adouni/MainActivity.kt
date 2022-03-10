package dev.adouni

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.title = "Assignment 1 - AAD SS2022"

        val input1 = findViewById<EditText>(R.id.input1)
        val input2 = findViewById<EditText>(R.id.input2)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val navigateButton = findViewById<Button>(R.id.navigateButton)
        val resultsTextView = findViewById<TextView>(R.id.result)
        val seekBar = findViewById<SeekBar>(R.id.seekbar)
        val seekbarValue = findViewById<TextView>(R.id.seekbarValue)

        calculateButton.setOnClickListener {
            val int1 = checkNumber(input1.text.toString())
            val int2 = checkNumber(input2.text.toString())

            val result = int1 + int2
            resultsTextView.setText("" + result)
        }

        navigateButton.setOnClickListener {
            val intent = Intent(this, NavigateActivity::class.java)
            val int1 = checkNumber(input1.text.toString())
            val int2 = checkNumber(input2.text.toString())

            val result = int1 + int2
            intent.putExtra("output", result)
            startActivity(intent)
        }

        //to update value from seekbar into the textfield
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                seekbarValue.text = seekBar.progress.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }

    fun checkNumber(input: String): Int {
        return try {
            input.toInt()
        } catch (ex: NumberFormatException) {
            0
        }
    }
}
