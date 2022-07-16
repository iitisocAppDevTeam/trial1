package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }
   private fun calculateTip()
    {
        val stringValue=binding.costOfService.text.toString()
        val cost=stringValue.toDouble()
        if(cost==null)
        {
            binding.tipResult.text=" "
            return
        }
        val selectedId= binding.tipOptions.checkedRadioButtonId

        val tipPercentage=when(selectedId)
        {
            R.id.option_twenty->0.2
            R.id.option_fifteen->0.15
            else ->0.10
        }
        var tipAmount=cost*tipPercentage
        val roundUp=binding.switch1.isChecked
        if (roundUp)
        {
            tipAmount=kotlin.math.ceil(tipAmount)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tipAmount)
        binding.tipResult.text= getString(R.string.tip_amount, formattedTip)
    }
}