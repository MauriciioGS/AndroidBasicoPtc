package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private var x : Int = 0

    /*
        Vinculación de vistra tradicional con findViewById

    private lateinit var myImage: ImageView
    private lateinit var myEditText: TextInputLayout
    private lateinit var myButton: Button

    */

    // Vinculación de vista usando viewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        myImage = findViewById(R.id.imagen)
        myEditText = findViewById(R.id.textField)
        myButton = findViewById(R.id.button)
        */

        binding.button.setOnClickListener {  view ->
            val textoIngresado = binding.textField.editText?.text.toString()
            if (textoIngresado.isBlank()) {
                Toast.makeText(this, "Por favor ingresa tu nombre", Toast.LENGTH_LONG).show()
            } else {
                val snackbar =
                    Snackbar.make(binding.root, getString(R.string.messageName, textoIngresado), Snackbar.LENGTH_LONG)
                        .setBackgroundTint(getColor(R.color.terciario))
                        .setAction("Ok") { }
                        .show()
            }
        }

        val items = listOf("México", "EUA", "España","Colombia","Uruguay","Argentina","Brasil","Venezuela")
        val adapter = ArrayAdapter(this, android.R.layout.simple_selectable_list_item , items)
        (binding.menuPaises.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        loadImage()
    }

    private fun loadImage() {
        Glide.with(this)
            .load("https://imagenpng.com/wp-content/uploads/2015/09/Paper_mario.png")
            .centerCrop()
            .into(binding.imagen)
    }


}