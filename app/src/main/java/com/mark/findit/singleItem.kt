package com.mark.findit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class singleItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_item)
        val db = Firebase.firestore
        val categoryText: TextView = findViewById(R.id.category)
        val itemName: TextView = findViewById(R.id.itemName)
        val locationText: TextView = findViewById(R.id.location)

        if (intent.extras!!.getString("from") == "main") {

            val value = intent.extras!!.getString("id")
            val category = intent.extras!!.getString("category")
            val location = intent.extras!!.getString("location")
            val item_name = intent.extras!!.getString("name")




            categoryText.text = category
            locationText.text = location
            itemName.text = item_name
        } else {
            val itemNameIntent = intent.extras!!.getString("item_name")
            val currentUid = FirebaseAuth.getInstance().currentUser!!.uid
            db.collection("items")
            .whereEqualTo("item_name", itemNameIntent)
                .whereEqualTo("uid", currentUid)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    categoryText.text = "${document.data["category"]}"
                    itemName.text = itemNameIntent
                    locationText.text = "${document.data["location"]}"
                }
            }
        }
        val button = findViewById<Button>(R.id.home_button)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
//        db.collection("items")
//            .whereEqualTo("id", value)
//            .get()
//            .addOnSuccessListener { documents ->
//                for (document in documents) {
//                    val category: TextView = findViewById(R.id.category)
//                    val itemName: TextView = findViewById(R.id.itemName)
//                    val location: TextView = findViewById(R.id.location)
//                    category.text = value
//                }
//            }
    }
}