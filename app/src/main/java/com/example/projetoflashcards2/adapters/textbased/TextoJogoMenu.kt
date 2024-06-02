package com.example.projetoflashcards.view.adapters.textbased

import com.example.projetoflashcards.model.tipos.Flashcard



class TextoJogoMenu {
    private val bordaCimaBaixo = "--------------------"
    private val bordaLateralEsq = "|         "
    private val bordaLateralDir = "         |"
    fun imprimirMenu() {
        println(
            """
            
            Escolha uma opção:
            1 - Um Jogador
            2 - Dois Jogadores
            0 - Sair Deste Menu
            Opção Escolhida: 
            """.trimIndent()
        )
    }

    fun imprimirOpcaoInvalida() {
        println("Opção Inválida, tente novamente!")
    }

    fun imprimirPerguntaCartaAtual(carta: Flashcard) {
        var bordaCimaBaixoLocal = bordaCimaBaixo
        val tamanhoPergunta = carta.getPergunta().length
        for (i in 0 until tamanhoPergunta) {
            bordaCimaBaixoLocal += "-"
        }
        println(bordaCimaBaixoLocal)
        imprimirLinhaVazia(tamanhoPergunta)
        imprimirLinhaVazia(tamanhoPergunta)
        println(bordaLateralEsq + carta.getPergunta() + bordaLateralDir)
        imprimirLinhaVazia(tamanhoPergunta)
        imprimirLinhaVazia(tamanhoPergunta)
        println(bordaCimaBaixoLocal)
    }

    fun imprimirRespostaCartaAtual(carta: Flashcard) {
        var bordaCimaBaixoLocal = bordaCimaBaixo
        val tamanhoPergunta = carta.getResposta().length
        for (i in 0 until tamanhoPergunta) {
            bordaCimaBaixoLocal += "-"
        }
        println(bordaCimaBaixoLocal)
        imprimirLinhaVazia(tamanhoPergunta)
        imprimirLinhaVazia(tamanhoPergunta)
        println(bordaLateralEsq + carta.getResposta() + bordaLateralDir)
        imprimirLinhaVazia(tamanhoPergunta)
        imprimirLinhaVazia(tamanhoPergunta)
        println(bordaCimaBaixoLocal)
    }

    fun imprimirAnimacaoCartaAtual(carta: Flashcard) {
        var bordaCimaBaixoLocal = bordaCimaBaixo
        val tamanhoPergunta = carta.getPergunta().length
        for (i in 0 until tamanhoPergunta) {
            bordaCimaBaixoLocal += "-"
        }
        println(bordaCimaBaixoLocal)
        imprimirLinhaVazia(tamanhoPergunta)
        imprimirLinhaVazia(tamanhoPergunta)
        println(
            bordaLateralEsq + carta.getPergunta()
                .replace(".".toRegex(), "*") + bordaLateralDir
        )
        imprimirLinhaVazia(tamanhoPergunta)
        imprimirLinhaVazia(tamanhoPergunta)
        println(bordaCimaBaixoLocal)
    }


    private fun imprimirLinhaVazia(tamanhoPergunta: Int) {
        print(bordaLateralEsq)
        for (i in 0 until tamanhoPergunta) {
            print(" ")
        }
        println(bordaLateralDir)
    }

    companion object
}