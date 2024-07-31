package com.example.assignment02

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Set up quiz fragment
        val quizFragment = QuizFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, quizFragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.take_quiz -> {
                // Show quiz fragment
                val quizFragment = QuizFragment()
                quizFragment.show(supportFragmentManager, "QuizFragment")
                return true
            }
            R.id.view_scores -> {
                // Show scores fragment
                val scoreFragment = ScoresFragment()
                scoreFragment.show(supportFragmentManager, "ScoresFragment")
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}