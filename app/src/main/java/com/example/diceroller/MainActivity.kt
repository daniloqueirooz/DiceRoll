package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        val rollButton: Button = findViewById(R.id.ButtonRoll)
        rollButton.setOnClickListener { roolDice() }
    }

    /**
     * Esta atividade permite ao usuário rolar um dado e visualizar o resultado
     * na tela.
     */

    private fun roolDice() {
        val dice = Dice(6)
        val diceRool = dice.roll()
        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRool.toString()
    }

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}




