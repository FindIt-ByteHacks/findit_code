package com.mark.findit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class categorypage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorypage)

        val button = findViewById<Button>(R.id.books_btn)
        button.setOnClickListener {
            val toast = Toast.makeText(this, "You clicked on Books", Toast.LENGTH_LONG).show()
        }

        val buttton = findViewById<Button>(R.id.toys_btn)
        buttton.setOnClickListener {
            val toast = Toast.makeText(this, "You clicked on Toys", Toast.LENGTH_LONG).show()
        }

        val buttone = findViewById<Button>(R.id.important_btn)
        buttone.setOnClickListener {
            val toast = Toast.makeText(this, "You clicked on Important", Toast.LENGTH_LONG).show()
        }

        val buttonn = findViewById<Button>(R.id.other_btn)
        buttonn.setOnClickListener {
            val toast = Toast.makeText(this, "You clicked on Other", Toast.LENGTH_LONG).show()
        }

        val butttton = findViewById<Button>(R.id.goback_button)
        butttton.setOnClickListener {
            val intent = Intent(this, addpage::class.java)
            startActivity(intent)
        }
    }
}