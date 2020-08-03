package com.mark.findit

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Firebase.firestore
        // Create a new user with a first and last name
        val item = hashMapOf(
            "category" to "Important",
            "location" to "In the drawer",
            "uid" to "2jLRuAvudwgE6DXpbAh3xQebnqt1",
            "item_name" to "car keys"
        )

// Add a new document with a generated ID
//        val TAG = "random"
//        db.collection("items")
//            .add(item)
//            .addOnSuccessListener { documentReference ->
//                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
//            }
//            .addOnFailureListener { e ->
//                Log.w(TAG, "Error adding document", e)
//            }


        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences(
            "sharedPrefs", Context.MODE_PRIVATE
        )
        if (sharedPreferences.getBoolean("isDarkModeOn", false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            Toast.makeText(this, "DDark On", Toast.LENGTH_LONG).show()

        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//            Toast.makeText(this, "Light on", Toast.LENGTH_LONG).show()

        }

        val lang = sharedPreferences.getString("language", "en")
        val myLocale = Locale(lang)
        Locale.setDefault(myLocale)
        val config = Configuration()
        config.locale = myLocale
        this.getResources()
            .updateConfiguration(config, this.getResources().getDisplayMetrics())

//        val locale = Locale("es")
//        Locale.setDefault(locale)
//        val config =
//            baseContext.resources.configuration
//        config.setLocale(locale)
//        baseContext.resources.updateConfiguration(
//            config,
//            baseContext.resources.displayMetrics
//        )
//        val myLocale = Locale("es")
//        val res: Resources = resources
//        val dm: DisplayMetrics = res.getDisplayMetrics()
//        val conf: Configuration = res.getConfiguration()
//        conf.locale = myLocale
//        res.updateConfiguration(conf, dm)
//        val refresh = Intent()
//        finish()
//        startActivity(refresh)
//        val myLocale = Locale("es")
//        Locale.setDefault(myLocale)
//        val config = Configuration()
//        config.locale = myLocale
//        this.getResources()
//            .updateConfiguration(config, this.getResources().getDisplayMetrics())
        val TAG = "random"
        val searchImage = findViewById<ImageView>(R.id.searchIcon)
        val search = findViewById<EditText>(R.id.searchView)
        val currentUid = FirebaseAuth.getInstance().currentUser!!.uid


        searchImage.setOnClickListener {
            val text = search.text.toString()
            Log.d(TAG, text)
            db.collection("items")
                .whereEqualTo("uid", currentUid)
                .whereEqualTo("item_name", text)
                .get()
                .addOnSuccessListener { documents ->
                    var i = 0
                    for (document in documents) {
                        i += 1
                        Log.d(TAG, "i added")

                    }
                    if (i == 1) {
                        for (document in documents) {
                            val intent = Intent(this, singleItem::class.java)
//                            intent.putExtra("id", "${document.data["id"]}") // getText() SHOULD NOT be static!!!
                            Log.d(TAG, "${document.data["item_name"]}")
                            intent.putExtra("from", "main")
                            intent.putExtra("category", "${document.data["category"]}")
                            intent.putExtra("name", "${document.data["item_name"]}")
                            intent.putExtra("location", "${document.data["location"]}")
                            intent.putExtra("id", "${document.data["id"]}")
                            startActivity(intent)
                        }
                    }
                }
        }
            val button = findViewById<Button>(R.id.button)
            button.setOnClickListener {
                val intent = Intent(this, addpage::class.java)
                startActivity(intent)
            }

            val buttonn = findViewById<Button>(R.id.item_btn)
            buttonn.setOnClickListener {
                val intent = Intent(this, youritem::class.java)
                startActivity(intent)
            }

            val buttone = findViewById<Button>(R.id.about_button)
            buttone.setOnClickListener {
                val intent = Intent(this, aboutteam::class.java)
                startActivity(intent)
            }

            val buttonnn = findViewById<Button>(R.id.settings_button)
            buttonnn.setOnClickListener {
                val intent = Intent(this, settingspage::class.java)
                startActivity(intent)
            }

    //        val home = findViewById<Button>(R.id.home_button)
    //        home.setOnClickListener {
    //            val TAG = "random"
    //            db.collection("items")
    //                .add(item)
    //                .addOnSuccessListener { documentReference ->
    //                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
    //                }
    //                .addOnFailureListener { e ->
    //                    Log.w(TAG, "Error adding document", e)
    //                }
    //
    //        }

            fun changeLang(context: Context, lang: String?) {
                val myLocale = Locale(lang)
                Locale.setDefault(myLocale)
                val config = Configuration()
                config.locale = myLocale
                context.getResources()
                    .updateConfiguration(config, context.getResources().getDisplayMetrics())
            }
        }
    }