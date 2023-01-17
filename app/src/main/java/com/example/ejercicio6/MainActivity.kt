package com.example.ejercicio6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.ejercicio6.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.boton1.isEnabled = false
        binding.boton1.isVisible = false

        binding.boton1.setOnClickListener {
            binding.edit1.isEnabled=true
            binding.boton1.isVisible = true
            binding.boton1.text= "Finalizar"
        }

        if(binding.boton1.text=="Finalizar"){
            binding.boton1.setOnClickListener {
                binding.edit1.isEnabled=false
                binding.edit1.isVisible=false
                binding.boton1.text= "Comenzar"
            }
        }

        if(binding.edit1.text.equals("Wayne")){

        }



    }
}