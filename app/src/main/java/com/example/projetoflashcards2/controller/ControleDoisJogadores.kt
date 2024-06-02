package com.example.projetoflashcards.controller

import com.example.projetoflashcards.interfaces.InterfaceJogadores
import com.example.projetoflashcards.model.sortear.SorteioRandom
import com.example.projetoflashcards.model.tipos.Flashcard
import com.example.projetoflashcards.model.tipos.Flashcards
import com.example.projetoflashcards.view.adapters.textbased.TextoJogoMenu
import com.example.projetoflashcards.view.adapters.textbased.TextoUmJogador


class ControleDoisJogadores : InterfaceJogadores {
    override var cards: Flashcards? = null
    private var cartaAtualP1: Flashcard? = null
    private var cartaAtualP2: Flashcard? = null
    private var cartaViradaP1 = false
    private var cartaViradaP2 = false
    private var vezJogador = true //lida o turno do jogador: true - P1, false - P2

    constructor(cards: Flashcards?) {
        this.cards = cards
    }

    override fun virarFlashcard() {
        val cartaMostrar: Flashcard?
        if (vezJogador) {
            cartaMostrar = cartaAtualP1
            cartaViradaP1 = true
        } else {
            cartaMostrar = cartaAtualP2
            cartaViradaP2 = true
        }
        try {
//            TextoJogoMenu.imprimirPerguntaCartaAtual(cartaMostrar)
            Thread.sleep(500)
//            TextoJogoMenu.imprimirAnimacaoCartaAtual(cartaMostrar)
            Thread.sleep(500)
//            TextoJogoMenu.imprimirRespostaCartaAtual(cartaMostrar)
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
        }
    }

    override fun passarFlashcard(acertou: Boolean): Flashcard? {
        this.vezJogador = !this.vezJogador
        return sortearFlashcard(acertou)
    }

    override fun sortearFlashcard(acertou: Boolean): Flashcard? {
        //descomentar abaixo o algoritmo desejado
        //Leitner sortear = new Leitner();// baseado na proposta de Leitner
        val sortear: SorteioRandom = SorteioRandom() //baseado em um RNG
        if (vezJogador) {
            cartaAtualP1 = sortear.sortear(cards, acertou)
            cartaViradaP1 = false
        } else {
            cartaAtualP2 = sortear.sortear(cards, acertou)
            cartaViradaP2 = false
        }

        return cartaAtualP1
    }

    override fun responder(resposta: String?): Boolean {
        var acertou = false
        var cartaVirada = true
        if (vezJogador) {
            if (!cartaViradaP1) cartaVirada = false
        } else {
            if (!cartaViradaP2) cartaVirada = false
        }
        if (!cartaVirada) {
            if (vezJogador) {
                if (cartaAtualP1!!.getResposta().equals(resposta, ignoreCase = true)) {
                    acertou = true
//                    TextoUmJogador.imprimirRespostaCorreta()
                    sortearFlashcard(true)
                } else {
//                    TextoUmJogador.imprimirRespostaIncorreta()
                }
            } else {
                if (cartaAtualP2!!.getResposta().equals(resposta, ignoreCase = true)) {
                    acertou = true
//                    TextoUmJogador.imprimirRespostaCorreta()
                    sortearFlashcard(true)
                } else {
//                    TextoUmJogador.imprimirRespostaIncorreta()
                }
            }
        }
        return acertou
    }

    fun getVezJogador(): Boolean {
        return vezJogador
    }

    fun isCartaVirada(): Boolean {
        return if (vezJogador) cartaViradaP1
        else cartaViradaP2
    }

    fun getCartaAtual(): Flashcard? {
        var cartaRetorno: Flashcard? = null
        if (vezJogador) {
            if (cartaAtualP1 == null) { // caso o jogador ainda não tenha uma carta ela será sorteada
                cartaAtualP1 = sortearFlashcard(true)
                cartaRetorno = cartaAtualP1
            } else cartaRetorno = cartaAtualP1
        } else {
            if (cartaAtualP2 == null) { // caso o jogador ainda não tenha uma carta ela será sorteada
                cartaAtualP2 = sortearFlashcard(true)
                cartaRetorno = cartaAtualP2
            } else cartaRetorno = cartaAtualP2
        }
        return cartaRetorno
    }

    fun passarVez() { //literal um flip flop, troca a vez do jogador
        this.vezJogador = !this.vezJogador
    }

    //se for a vez do jogador 1 ele vê a carta do jogador 2 e vice versa
    fun espiarFlashcard(): Flashcard? { // metodo para pegar a carta do jogador adversário
        return if (vezJogador) {
            cartaAtualP2
        } else cartaAtualP1
    }

    fun trocarCartas() {
        //troca as cartas entre os jogadores
        val aux = cartaAtualP2
        cartaAtualP2 = cartaAtualP1
        cartaAtualP1 = aux
    }
}