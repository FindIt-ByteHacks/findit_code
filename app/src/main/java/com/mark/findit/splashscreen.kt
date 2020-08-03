package com.mark.findit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.mark.findit.ui.login.loginpage

class splashscreen : AppCompatActivity() {
    lateinit var handler: Handler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        handler = Handler()
        handler.postDelayed({

            val intent =
        Intent(this, loginpage::class.java)
            startActivity(intent)
            finish()


        }, 3000)
    }
}