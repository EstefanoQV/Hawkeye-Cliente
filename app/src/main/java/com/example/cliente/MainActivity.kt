package com.example.cliente

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editPlaca: EditText
    private lateinit var editNombreConductor: EditText
    private lateinit var editOrigen: EditText
    private lateinit var editDestino: EditText
    private lateinit var btnIniciarViaje: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editPlaca = findViewById(R.id.editPlaca)
        editNombreConductor = findViewById(R.id.editNombreConductor)
        editOrigen = findViewById(R.id.editOrigen)
        editDestino = findViewById(R.id.editDestino)
        btnIniciarViaje = findViewById(R.id.btnIniciarViaje)

        btnIniciarViaje.setOnClickListener {
            if (validateFields()) {
                val intent = Intent(this, MapActivity::class.java).apply {
                    putExtra("placa", editPlaca.text.toString().trim())
                    putExtra("nombreConductor", editNombreConductor.text.toString().trim())
                    putExtra("origen", editOrigen.text.toString().trim())
                    putExtra("destino", editDestino.text.toString().trim())
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Complete todos los campos requeridos", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun validateFields(): Boolean {
        val placa = editPlaca.text.toString().trim()
        val nombreConductor = editNombreConductor.text.toString().trim()
        val origen = editOrigen.text.toString().trim()
        val destino = editDestino.text.toString().trim()

        return placa.isNotEmpty() && nombreConductor.isNotEmpty() && origen.isNotEmpty() && destino.isNotEmpty()
    }
}
