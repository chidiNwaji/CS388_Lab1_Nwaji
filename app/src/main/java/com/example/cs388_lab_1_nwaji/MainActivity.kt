package com.example.cs388_lab_1_nwaji

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.Toast
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.view.isInvisible


class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars( ))
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)

        button.setOnClickListener {
            /* Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show() */
            counter++
            textView.text = counter.toString()

            if (counter >= 50) {
                upgradeButton.isVisible = true
                upgradeButton.setOnClickListener {
                    button.text = "Add 5"
                    button.setOnClickListener {
                        counter += 5
                        textView.text = counter.toString()
                    }
                    upgradeButton.isInvisible = true
                }
            }
        }
    }
}