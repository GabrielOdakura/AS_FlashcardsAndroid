package com.example.projetoflashcards.view.adapters.textbased

import com.example.projetoflashcards.model.tipos.Flashcard
import com.example.projetoflashcards.model.utils.ConsoleUtils



class TextoDoisJogadores {
    fun imprimirMenu(jogador: String) {
        println(
            """
            
            Vez de jogador $jogador
            Escolha uma opção:
            1 - Responder
            2 - Passar Carta
            3 - Sortear Proxima
            4 - Virar Carta
            5 - Espiar Outro Jogador
            6 - Trocar Carta com Outro Jogador
            7 - Passar a Vez
            0 - Sair Deste Menu
            Opção Escolhida: 
            """.trimIndent()
        )
    }

    fun imprimirAcertos(acertos: IntArray) {
        println("Jogador 1 acertou " + acertos[0] + " carta(s)!")
        println("Jogador 2 acertou " + acertos[1] + " carta(s)!")
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

    fun imprimirCartaOutroJogador(cartaOutroJogador: Flashcard?) {
        println("A carta do outro jogador é:")
        TextoJogoMenu.imprimirPerguntaCartaAtual(cartaOutroJogador)
    }

    fun imprimirMensagemCartasTrocadas() {
        println("As cartas dos jogadores foram trocadas!")
    }
}

internal fun TextoJogoMenu.Companion.imprimirPerguntaCartaAtual(cartaAtual: Flashcard?) {
    TODO("Not yet implemented")
}
