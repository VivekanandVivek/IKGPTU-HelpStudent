package com.vivek.ikgptu
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.vivek.ikgptu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

     lateinit var sharedPreferences: SharedPreferences
   // private lateinit var binding : ActivityMainBinding
    lateinit var etstuid:EditText
    lateinit var etstupass:EditText
    lateinit var btngoon:Button
    lateinit var btnsignup: Button

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context. MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)

        setContentView(R.layout.activity_main)
        if(isLoggedIn){
            val intent = Intent(this@MainActivity,HomeScActivity::class.java)
            startActivity(intent)
        }



        //  binding = ActivityMainBinding.inflate(layoutInflater)

        title = "Log In"
        etstuid = findViewById(R.id.etstuid)
        etstupass = findViewById(R.id.etstupass)
        btnsignup = findViewById(R.id.btnsignup)
        btngoon = findViewById(R.id.btngoon)


        // binding.
        btngoon.setOnClickListener(View.OnClickListener {

            val Intent = Intent(this@MainActivity, HomeScActivity::class.java)
            if (etstuid.text.toString() == "2125687" && etstupass.text.toString() == "vivek@2004") {

             //   savePreferences()

                //  startActivity(intent)
                Toast.makeText(this@MainActivity, "LogIn Sucess", Toast.LENGTH_SHORT).show()
                startActivity(Intent)

            } else {
                Toast.makeText(this@MainActivity, "Invalid Credentials!?", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


    override fun onPause(){
        super.onPause()
        finish()
    }

    fun savePreferences(){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
    }

}