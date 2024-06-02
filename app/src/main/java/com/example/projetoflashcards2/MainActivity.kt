package com.example.projetoflashcards2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetoflashcards.controller.ControleFlashMenu
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var btnMS : Button
    lateinit var btnMJ : Button
    lateinit var btnS : Button
    lateinit var controle : ControleFlashMenu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnMS = findViewById(R.id.btn_MF)
        btnMJ = findViewById(R.id.btn_MJ)
        btnS = findViewById(R.id.btn_S)
//        btnMJ.isEnabled = false
        controle = ControleFlashMenu()
        btnMS.setOnClickListener(this)
        btnMJ.setOnClickListener(this)
        btnS.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_MF -> {
                val intent = Intent(this, MenuFlashcardsActivity::class.java)
                intent.putExtra("CONTROLE", controle)
                startActivity(intent)
            }
            R.id.btn_MJ -> {}
            R.id.btn_S -> {
                exitProcess(0)
            }
        }
    }
}