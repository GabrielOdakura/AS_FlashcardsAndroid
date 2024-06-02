package com.example.projetoflashcards2

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import com.example.projetoflashcards.controller.ControleFlashMenu

class MenuFlashcardsActivity : Activity(), View.OnClickListener {
    lateinit var btn_Salvar : Button
    lateinit var btn_Carregar : Button
    lateinit var btn_GerarPB : Button
    lateinit var btn_Remov : Button
    lateinit var btn_Voltar : Button
    lateinit var et_nome : EditText
    lateinit var et_perg : EditText
    lateinit var et_resp : EditText
    lateinit var et_enbd : EditText
    lateinit var et_id : EditText

    lateinit var controle : ControleFlashMenu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loadcards)
        controle = intent.getParcelableExtra<ControleFlashMenu>("CONTROLE")!!
        btn_Salvar = findViewById(R.id.btn_Salvar)
        btn_Carregar = findViewById(R.id.btn_Carregar)
        btn_GerarPB = findViewById(R.id.btn_GerarPacoteBase)
        btn_Voltar = findViewById(R.id.btn_Voltar)
        btn_Remov = findViewById(R.id.btn_Remover)
        et_nome = findViewById(R.id.et_NomArq)
        et_perg = findViewById(R.id.et_Perg)
        et_resp = findViewById(R.id.et_Resp)
        et_enbd = findViewById(R.id.et_Hab)
        et_id = findViewById(R.id.et_Rem)

        btn_Salvar.setOnClickListener(this)
        btn_Carregar.setOnClickListener(this)
        btn_GerarPB.setOnClickListener(this)
        btn_Voltar.setOnClickListener(this)
        btn_Remov.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        var nomeArquivo = et_nome.text.toString()
        var pergunta = et_perg.text.toString()
        var resposta = et_resp.text.toString()
        var enbd = et_enbd.text.toString()
        var remId : Int
        when(v?.id){
            R.id.btn_Salvar -> {
                var hab : Boolean = false
                if(enbd.equals("enabled")) hab = true
                controle.salvarCarta(nomeArquivo,pergunta,resposta,hab,"")
            }
            R.id.btn_Carregar -> {
                controle.carregarCartas(nomeArquivo)
            }
            R.id.btn_Remover -> {
                remId = et_id.text.toString().toInt()
                controle.removerCarta(nomeArquivo,remId)
            }
            R.id.btn_GerarPacoteBase -> {
                controle.gerarPacoteBase()
            }
            R.id.btn_Voltar -> {finish()}
        }
    }
}