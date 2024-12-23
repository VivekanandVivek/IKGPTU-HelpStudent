package com.vivek.ikgptu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vivek.ikgptu.databinding.ActivityMainBinding

class HomeScActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var bottomNavigationView: BottomNavigationView
    private var doubleBackToExitPressedOnce = false
     var name:String  = "Home"


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_home_sc)

        constraintLayout = findViewById(R.id.constraintlayout)



        replaceFragment(home())
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {


            when(it.itemId){

                R.id.home_nav -> {
                    name = "Home"
                    replaceFragment(home())
                }
                R.id.exam_nav -> {
                    name = "ExamNav"
                    replaceFragment(ptu_exam())
                }
                R.id.student_nav -> {
                    name = "StudentCorner"
                    replaceFragment(student_corner())
                }

                else ->{



                }

            }

            true

        }


    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.addToBackStack(name)
        fragmentTransaction.commit()



    }



}