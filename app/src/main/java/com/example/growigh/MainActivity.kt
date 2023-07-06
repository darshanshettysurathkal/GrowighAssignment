package com.example.growigh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager

        showAboutUsFragment()

        val SkipButton = findViewById<Button>(R.id.skipButton)
        SkipButton.setOnClickListener {
            openHomeActivity()
        }
    }

    private fun showAboutUsFragment() {
        val aboutUsFragment = AboutUsFragment()
        replaceFragment(aboutUsFragment)
    }

    fun showVisionFragment() {
        val visionFragment = VisionFragment()
        replaceFragment(visionFragment)
    }

    fun showMissionFragment() {
        val missionFragment = MissionFragment()
        replaceFragment(missionFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(android.R.id.content, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun openHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
