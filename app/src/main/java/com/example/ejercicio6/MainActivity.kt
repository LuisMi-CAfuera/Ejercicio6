package com.example.ejercicio6

import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.view.isVisible
import com.example.ejercicio6.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        boton(binding)

        cambiar(binding, resources)

        hint(binding)


    }


}

fun cambiar(binding: ActivityMainBinding,resource : Resources){
    binding.edit1.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if(binding.edit1.text.contains("Wayne")){
                binding.batman.visibility= View.VISIBLE
//a
            }else if(binding.edit1.text.contains("Joker")){
                binding.boton1.setBackgroundColor(Color.parseColor("#0FF324"))
                binding.boton1.setTextColor(Color.parseColor("#770FF3"))
                binding.root.setBackgroundColor(Color.parseColor("#770FF3"))
                binding.batman.visibility= View.INVISIBLE

            }else{
                binding.batman.visibility= View.INVISIBLE
                binding.root.setBackgroundColor(Color.parseColor("#FFFFFF"))
                binding.boton1.setBackgroundColor(Color.parseColor("#FF3700B3"))
                binding.boton1.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
        }
        override fun afterTextChanged(s: Editable?) {

        }


    })
}

fun boton(binding: ActivityMainBinding){
    binding.boton1.setOnClickListener {
        if(binding.boton1.text=="Finalizar"){
            binding.edit1.isEnabled=false
            binding.edit1.isVisible = false
            binding.boton1.text= "Comenzar"
        }else{
            binding.edit1.isEnabled=true
            binding.edit1.isVisible = true
            binding.boton1.text= "Finalizar"
        }

    }
}

fun hint(binding: ActivityMainBinding){
    binding.edit1.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
        if (hasFocus) {
            binding.edit1.hint = ""
        } else {
            binding.edit1.hint = "Introduce tu nombre"
        }
    }
}
