package com.example.imc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.imc.R
import com.example.imc.utils.getDataAtualBrasil
import java.time.LocalDate

class PesagemActivity : AppCompatActivity() {

    lateinit var tvDataPesagem: TextView
    lateinit var etNovoPeso: EditText
    lateinit var spinnerNivel: Spinner
    lateinit var btnRegistrarPeso: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem)
        supportActionBar!!.hide()

        tvDataPesagem = findViewById(R.id.tv_data_pesagem)
        etNovoPeso = findViewById(R.id.et_novo_peso)
        spinnerNivel = findViewById(R.id.spinner_niveis)
        btnRegistrarPeso = findViewById(R.id.btn_registrar_novo_peso)

        tvDataPesagem.text = getDataAtualBrasil()

        btnRegistrarPeso.setOnClickListener {
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            val pesagem = arquivo.getString("pesagem", "")
            val dataPesagem = arquivo.getString("data_pesagem", "")
            val nivel = arquivo.getString("nivel", "")

            val editor = arquivo.edit()
            editor.putString("pesagem", "$pesagem;${etNovoPeso.text.toString()}")
            editor.putString("data_pesagem", "$dataPesagem;${LocalDate.now().toString()}")
            editor.putString("nivel", "$nivel;${spinnerNivel.selectedItemPosition.toString()}")
            editor.apply()

            Toast.makeText(this, "Peso registrado com sucesso!!", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}