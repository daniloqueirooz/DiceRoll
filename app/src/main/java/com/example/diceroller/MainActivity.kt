package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonRoll.setOnClickListener {
            val rollButton: Button = binding.ButtonRoll
            rollButton.setOnClickListener { roolDice() }

        }


    }

    /**
     * Esta atividade permite ao usuário rolar um dado e visualizar o resultado
     * na tela.
     */

    private fun roolDice() {
        val dice = Dice(6)
        val diceRool = dice.roll()
        // Update the screen with the dice roll

        val diceImage: ImageView = binding.ImageView
        val drawableResource = when (diceRool) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6


        }
        diceImage.setImageResource(drawableResource)

        diceImage.contentDescription = diceRool.toString()

    }


    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}