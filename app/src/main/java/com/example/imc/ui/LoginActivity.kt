package com.example.imc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.imc.R
import com.example.imc.utils.autenticar

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        val tvNovaConta = findViewById<TextView>(R.id.tv_nova_conta)
        val buttonEntar = findViewById<Button>(R.id.button_entrar)

        val editEmail = findViewById<EditText>(R.id.edit_login_email)
        val editSenha = findViewById<EditText>(R.id.edit_login_senha)

        buttonEntar.setOnClickListener {
            val autenticou = autenticar(
                    editEmail.text.toString(),
                    editSenha.text.toString(),
                    this)

            if (autenticou) {
                val intent = Intent(
                        this,
                        DashBoardActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos!!", Toast.LENGTH_SHORT).show()
            }

        }

        tvNovaConta.setOnClickListener {
            val novaConta = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(novaConta)

        }
    }
}