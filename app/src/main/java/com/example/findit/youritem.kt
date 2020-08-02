package com.example.findit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class youritem : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youritem)
        val db = Firebase.firestore


        val currentUid = FirebaseAuth.getInstance().currentUser!!.uid
        val TAG = "random"
        val importantList = mutableListOf(
            "Select item"
        )
        val toysList = mutableListOf(
            "Select item"
        )
        val otherList = mutableListOf(
            "Select item"
        )
        val bookList = mutableListOf(
            "Select item"
        )


        val list = mutableListOf(
            "Jungle green",
            "Light periwinkle",
            "Lemon glacier",
            "Kelly green",
            "Lemon yellow",
            "Lavender blush"
        )

        db.collection("items")
            .whereEqualTo("uid", currentUid)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    if ("${document.data["category"]}" == "Toys") {
                        val itemName = "${document.data["item_name"]}"

                        toysList.add(itemName)
                    } else if ("${document.data["category"]}" == "Important") {
                        val itemName = "${document.data["item_name"]}"

                        importantList.add(itemName)
                    } else if ("${document.data["category"]}" == "Other") {
                        val itemName = "${document.data["item_name"]}"

                        otherList.add(itemName)
                    } else if ("${document.data["category"]}" == "Books") {
                        val itemName = "${document.data["item_name"]}"

                        bookList.add(itemName)
                    }


                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }

        val spinner3: Spinner = findViewById(R.id.spinner3)

        // initialize an array adapter for spinner
        val adapter1: ArrayAdapter<String> = object : ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            toysList
        ) {
            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView = super.getDropDownView(
                    position,
                    convertView,
                    parent
                ) as TextView

                // set item text style and font


                // set spinner item padding


                // alternate item style


                return view
            }
        }

        spinner3.adapter = adapter1


        val spinner2: Spinner = findViewById(R.id.spinner2)

        // initialize an array adapter for spinner
        val adapter2: ArrayAdapter<String> = object : ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            bookList
        ) {
            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView = super.getDropDownView(
                    position,
                    convertView,
                    parent
                ) as TextView

                // set item text style and font


                // set spinner item padding


                // alternate item style


                return view
            }
        }

        spinner2.adapter = adapter2


        val spinner4: Spinner = findViewById(R.id.spinner4)

        // initialize an array adapter for spinner
        val adapter4: ArrayAdapter<String> = object : ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            otherList
        ) {
            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView = super.getDropDownView(
                    position,
                    convertView,
                    parent
                ) as TextView

                // set item text style and font


                // set spinner item padding


                // alternate item style


                return view
            }
        }

        spinner4.adapter = adapter4


        val spinner5: Spinner = findViewById(R.id.spinner5)

        // initialize an array adapter for spinner
        val adapter5: ArrayAdapter<String> = object : ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            importantList
        ) {
            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView = super.getDropDownView(
                    position,
                    convertView,
                    parent
                ) as TextView

                // set item text style and font


                // set spinner item padding


                // alternate item style


                return view
            }
        }

        spinner5.adapter = adapter5

//         finally, data bind spinner with adapter

//        db.collection("items")
//            .whereEqualTo("uid", currentUid)
//            .get()
//            .addOnSuccessListener { documents ->
//                for (document in documents) {
//                    if (document.data["category"] == "Toys") {
//                        val item_name = document.data["item_name"].toString()
//                        val category = document.data["category"]
//                        val location = document.data["location"].toString()
//                        val uid =  document.data["uid"].toString()
//                        val docId = document.data["id"].toString()
////                        val docData = Document(item_name, category, location, uid, docId )
//                        toysList.add(docData)
////                        toysList.add(document.data["item_name"].toString())
////                        Log.d(TAG,  "Located: => ${document.data["location"]}")
////                        Log.d(TAG, toysList.toString())
//                    }
//
//
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.w(TAG, "Error getting documents: ", exception)
//            }


//        val adapter: ArrayAdapter<Any> = ArrayAdapter<Any>(
//            this,
//            android.R.layout.simple_spinner_item, toysList
//        )
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinner3.setAdapter(adapter)


//        ArrayAdapter<Any>(
//            this,
//            android.R.layout.simple_spinner_item,
//            toysList
//        )
//            .also { adapter ->
//                // Specify the layout to use when the list of choices appears
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//                // Apply the adapter to the spinner
//                spinner3.adapter = adapter
//            }
//        db.collection("items")
//            .whereEqualTo("uid", currentUid)
//            .get()
//            .addOnSuccessListener { documents ->
//                for (document in documents) {
//                    Log.d(TAG, document.toString())
////                    if (document.get("category").toString() == "Books") {
////                        bookList.add(document.data.getValue("item_name"))
////                    } else if (document.get("category").toString() == "Important") {
////                        importantList.add(document.data.getValue("item_name"))
////                    } else if (document.get("category").toString() == "Toys") {
////                        toysList.add(document.data.getValue("item_name"))
////                    } else if (document.get("category").toString() == "Other") {
////                        otherList.add(document.data.getValue("item_name"))
////                    }
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.w(TAG, "Error getting documents: ", exception)
//            }


//
//        val spinner2: Spinner = findViewById(R.id.spinner2)
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.books,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner2.adapter = adapter
//        }


//        val spinner3: Spinner = findViewById(R.id.spinner3)
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.toys,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner3.adapter = adapter
//        }
//        val spinner4: Spinner = findViewById(R.id.spinner4)
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.important,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner4.adapter = adapter
//        }


//        val spinner5: Spinner = findViewById(R.id.spinner5)
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.other,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner5.adapter = adapter
//        }

        val findit = findViewById<Button>(R.id.findit)

        findit.setOnClickListener {
            var i = 0
            var itemName = ""
            if (spinner2.selectedItem.toString() != "Select item") {
                i += 1
                itemName = spinner2.selectedItem.toString()
            } else if (spinner3.selectedItem.toString() != "Select item") {
                i += 1
                itemName = spinner3.selectedItem.toString()
            } else if (spinner4.selectedItem.toString() != "Select item") {
                i += 1
                itemName = spinner4.selectedItem.toString()
            } else if (spinner5.selectedItem.toString() != "Select item") {
                i += 1
                itemName = spinner5.selectedItem.toString()
            }

            if (i > 1) {
                Toast.makeText(this, "Please select only one item", Toast.LENGTH_LONG).show()
            } else {

                val intent = Intent(this, singleItem::class.java)

                intent.putExtra("from", "yourItem")
                intent.putExtra("item_name", itemName)
                startActivity(intent)
            }
        }

        val button = findViewById<Button>(R.id.home_button)
        button.setOnClickListener {
//            db.collection("items")
//                .whereEqualTo("uid", currentUid)
//                .get()
//                .addOnSuccessListener { documents ->
//                    for (document in documents) {
//                        if (document.data["category"] == "Toys") {
//                            toysList.add(document.data["item_name"].toString())
//                            Log.d(TAG,  "Located: => ${document.data["location"]}")
//                            Log.d(TAG, toysList.toString())
//                        }
////                    if (document.get("category").toString() == "Books") {
////                        bookList.add(document.data.getValue("item_name"))
////                    } else if (document.get("category").toString() == "Important") {
////                        importantList.add(document.data.getValue("item_name"))
////                    } else if (document.get("category").toString() == "Toys") {
////                        toysList.add(document.data.getValue("item_name"))
////                    } else if (document.get("category").toString() == "Other") {
////                        otherList.add(document.data.getValue("item_name"))
////                    }
//                    }
//                }
//                .addOnFailureListener { exception ->
//                    Log.w(TAG, "Error getting documents: ", exception)
//                }

//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)


        }

    }


}