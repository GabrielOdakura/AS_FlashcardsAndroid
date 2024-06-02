package com.example.projetoflashcards.view.adapters.textbased

import com.example.projetoflashcards.model.tipos.Flashcard
import com.example.projetoflashcards.model.utils.ConsoleUtils



class TextoUmJogador {
    fun imprimirMenu() {
        println(
            """
            
            Escolha uma opção:
            1 - Responder
            2 - Passar Carta
            3 - Sortear Proxima
            4 - Virar Carta
            0 - Sair Deste Menu
            Opção Escolhida: 
            """.trimIndent()
        )
    }

    fun imprimirAcertos(acertos: Int) {
        println("Voce acertou $acertos carta(s)!")
    }

    fun imprimirOpcaoInvalida() {
        println("Opção Inválida, tente novamente!")
    }

    fun imprimirRespostaCorreta() {
        println("Parabens! Resposta Correta!\n")
    }

    fun imprimirRespostaIncorreta() {
        println("Resposta Incorreta!\n")
    }

    fun imprimirCartaJaVirada() {
        println("A carta foi virada, revelando sua resposta, poranto não se pode mais tentar!")
    }

    fun imprimirCarta(cartaAtual: Flashcard?) {
        TextoJogoMenu.imprimirPerguntaCartaAtual(cartaAtual)
    }

    fun imprimirEntradaResposta() {
        println("Digite a sua resposta: ")
    }
}