package com.example.ejercicio6

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.text.Editable
import android.text.TextWatcher
import androidx.core.view.isVisible
import com.example.ejercicio6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var enableAll = true;
        binding.boton.setOnClickListener {
            if(enableAll){
                binding.boton.text = "Finalizar"
                binding.nombre.isVisible = enableAll
                binding.salirDelPrimerEditText.isVisible = enableAll
                enableAll = false
            } else{
                binding.boton.text = "Comenzar"
                binding.nombre.isVisible = enableAll
                binding.salirDelPrimerEditText.isVisible = enableAll
                enableAll = true
                binding.boton.setBackgroundColor(Color.parseColor("#FF3700B3"))
                binding.boton.setTextColor(Color.WHITE)
                binding.root.setBackgroundColor(Color.WHITE)
                supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF6200EE")))
                binding.batman.isVisible = false
            }
        }

        binding.nombre.setOnFocusChangeListener { _, b ->
            if(b)
                binding.nombre.setText("")
            else
                if(binding.nombre.text.toString().isEmpty())
                    binding.nombre.setText("Introduce tu nombre")
        }

        binding.nombre.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(binding.nombre.text.toString().contains("Wayne")){
                    binding.batman.isVisible = true
                } else
                    if(binding.nombre.text.toString().contains("Joker")){
                        binding.boton.setBackgroundColor(Color.parseColor("#FF0000"))
                        binding.boton.setTextColor(Color.BLUE)
                        binding.root.setBackgroundColor(Color.GREEN)
                        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#ffae00")))
                        binding.batman.isVisible = false
                    } else{
                        binding.boton.setBackgroundColor(Color.parseColor("#FF3700B3"))
                        binding.boton.setTextColor(Color.WHITE)
                        binding.root.setBackgroundColor(Color.WHITE)
                        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FF6200EE")))
                        binding.batman.isVisible = false
                    }
            }
        })
    }
}