package dev.adouni

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NavigateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigate)

        val actionBar = supportActionBar
        actionBar!!.title = "Ergebnis"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        val result = intent.getIntExtra("output", 0)
        val field = findViewById<TextView>(R.id.navigateOutput)

        field.setText("" + result)
    }
}