package com.example.imc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imc.R

class PesagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem)
        supportActionBar!!.hide()
    }
}