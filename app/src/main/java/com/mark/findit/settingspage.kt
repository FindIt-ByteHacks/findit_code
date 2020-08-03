package com.mark.findit
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import java.util.*
class settingspage : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settingspage)
        val darkbutton = findViewById<Switch>(R.id.uitheme)
//        darkbutton.setOnClickListener{
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//
//        }
        val sharedPreferences = getSharedPreferences(
            "sharedPrefs", Context.MODE_PRIVATE
        )

        if (sharedPreferences.getBoolean("isDarkModeOn", false)) {
            darkbutton.toggle()
//            Toast.makeText(this, "DDark On", Toast.LENGTH_LONG).show()

        }


        val editor = sharedPreferences.edit()
        darkbutton.setOnCheckedChangeListener { _, isChecked->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean("isDarkModeOn", true)
                editor.commit()
            } else {
                editor.putBoolean("isDarkModeOn", false)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.commit()
            }
        }
        val spinner: Spinner = findViewById(R.id.spinner6)
        ArrayAdapter.createFromResource(
            this,
            R.array.languages ,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            val text: String = spinner.getSelectedItem().toString();
            if (text == "Spanish") {
                val myLocale = Locale("es")
                Locale.setDefault(myLocale)
                val config = Configuration()
                config.locale = myLocale
                this.getResources()
                    .updateConfiguration(config, this.getResources().getDisplayMetrics())
                editor.putString("language", "es")
                editor.commit()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else if(text == "English"){
                val myLocale = Locale("en")
                Locale.setDefault(myLocale)
                val config = Configuration()
                config.locale = myLocale
                this.getResources()
                    .updateConfiguration(config, this.getResources().getDisplayMetrics())
                editor.putString("language", "en")
                editor.commit()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else if(text == "French"){
                val myLocale = Locale("fr")
                Locale.setDefault(myLocale)
                val config = Configuration()
                config.locale = myLocale
                this.getResources()
                    .updateConfiguration(config, this.getResources().getDisplayMetrics())
                editor.putString("language", "fr")
                editor.commit()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else if(text == "Indonesian"){
                val myLocale = Locale("in")
                Locale.setDefault(myLocale)
                val config = Configuration()
                config.locale = myLocale
                this.getResources()
                    .updateConfiguration(config, this.getResources().getDisplayMetrics())
                editor.putString("language", "in")
                editor.commit()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else if(text == "German"){
                val myLocale = Locale("de")
                Locale.setDefault(myLocale)
                val config = Configuration()
                config.locale = myLocale
                this.getResources()
                    .updateConfiguration(config, this.getResources().getDisplayMetrics())
                editor.putString("language", "de")
                editor.commit()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else if(text == "Hindi") {
                val myLocale = Locale("hi")
                Locale.setDefault(myLocale)
                val config = Configuration()
                config.locale = myLocale
                this.getResources()
                    .updateConfiguration(config, this.getResources().getDisplayMetrics())
                editor.putString("language", "hi")
                editor.commit()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
//            val myLocale = Locale("es")
//            Locale.setDefault(myLocale)
//            val config = Configuration()
//            config.locale = myLocale
//            this.getResources()
//                .updateConfiguration(config, this.getResources().getDisplayMetrics())
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
            Toast.makeText(this, "Restart app to see changes", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//        val spinner: Spinner = findViewById(R.id.spinner6)
//        val text = spinner.getSelectedItem().toString();
        Toast.makeText(this, "Thank you for submitting.", Toast.LENGTH_LONG).show()
//        if (text=="Spanish") {
//            val myLocale = Locale("es")
//            Locale.setDefault(myLocale)
//            val config = Configuration()
//            config.locale = myLocale
//            this.getResources()
//                .updateConfiguration(config, this.getResources().getDisplayMetrics())
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        } else {
//            val myLocale = Locale("en")
//            Locale.setDefault(myLocale)
//            val config = Configuration()
//            config.locale = myLocale
//            this.getResources()
//                .updateConfiguration(config, this.getResources().getDisplayMetrics())
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
    }
}
