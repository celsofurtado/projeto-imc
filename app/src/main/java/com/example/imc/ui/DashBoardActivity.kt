package com.example.imc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.imc.R
import com.example.imc.utils.convertBase64ToBitmap

class DashBoardActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvImc: TextView
    lateinit var tvNcd: TextView
    lateinit var tvPeso: TextView
    lateinit var tvIdade: TextView
    lateinit var tvAltura: TextView
    lateinit var ivPerfil: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        tvNome = findViewById(R.id.tv_dash_nome)
        tvNcd = findViewById(R.id.tv_dash_ncd)
        tvPeso = findViewById(R.id.tv_dash_peso)
        tvProfissao = findViewById(R.id.tv_dash_profissao)
        tvAltura = findViewById(R.id.tv_dash_altura)
        tvIdade = findViewById(R.id.tv_dash_idade)
        tvImc = findViewById(R.id.tv_dash_imc)
        ivPerfil = findViewById(R.id.iv_dash_foto_perfil)

        carregarDashboard()
    }

    private fun carregarDashboard() {
        val arquivo =
                getSharedPreferences(
                        "usuario", MODE_PRIVATE)

        tvNome.text = arquivo.getString("nome", "")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()

        val bitmap = convertBase64ToBitmap(arquivo.getString("fotoPerfil", "")!!)
        ivPerfil.setImageBitmap(bitmap)

    }
}