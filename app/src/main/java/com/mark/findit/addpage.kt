package com.mark.findit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class addpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addpage)
        val db = Firebase.firestore
        // Create a new user with a first and last name
//        val item = hashMapOf(
//            "category" to "Important",
//            "location" to "In the drawer",
//            "uid" to "2jLRuAvudwgE6DXpbAh3xQebnqt1",
//            "item_name" to "car keys"
//        )
        val spinner: Spinner = findViewById(R.id.spinner1)
        ArrayAdapter.createFromResource(
            this,
            R.array.categories_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        val button = findViewById<Button>(R.id.home_button)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



        val submit = findViewById<Button>(R.id.submit_button)
        submit.setOnClickListener {
            val category = spinner.selectedItem
            val locationView = findViewById<EditText>(R.id.location)
            val location = locationView.getText().toString()
            val nameView = findViewById<EditText>(R.id.name)
            val name = nameView.getText().toString()
//
            val currentuser = FirebaseAuth.getInstance().currentUser!!.uid
            // Create a new user with a first and last name
            val item = hashMapOf(
                "category" to category,
                "location" to location,
                "uid" to currentuser,
                "item_name" to  name
            )
            val TAG = "random"
            db.collection("items")
                .add(item)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
            val toast = Toast.makeText(this, "Thank you for submitting.", Toast.LENGTH_LONG).show()
        }
    }
}