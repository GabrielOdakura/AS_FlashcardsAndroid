package com.example.projetoflashcards.controller

import com.example.projetoflashcards.interfaces.InterfaceJogadores
import com.example.projetoflashcards.model.sortear.SorteioRandom
import com.example.projetoflashcards.model.tipos.Flashcard
import com.example.projetoflashcards.model.tipos.Flashcards
import com.example.projetoflashcards.view.adapters.textbased.TextoJogoMenu
import com.example.projetoflashcards.view.adapters.textbased.TextoUmJogador


class ControleUmJogador : InterfaceJogadores {
    override var cards: Flashcards? = null
    private var cartaAtual: Flashcard? = null
    private var cartaVirada = false

    //descomentar abaixo o algoritmo desejado
    //Leitner sortear = new Leitner();// baseado na proposta de Leitner
    var sortear: SorteioRandom = SorteioRandom() //baseado em um RNG

    constructor(cards: Flashcards?) {
        this.cards = cards
        this.cartaVirada = false
    }

    override fun responder(resposta: String?): Boolean {
        var acertou = false
        if (!cartaVirada) {
            if (cartaAtual!!.getResposta().equals(resposta, ignoreCase = true)) {
                acertou = true
//                TextoUmJogador.imprimirRespostaCorreta()
                sortearFlashcard(true)
            } else {
//                TextoUmJogador.imprimirRespostaIncorreta()
            }
        }
        return acertou
    }

    override fun virarFlashcard() {
        this.cartaVirada = true
        try {
//            TextoJogoMenu.imprimirPerguntaCartaAtual(cartaAtual)
            Thread.sleep(500)
//            TextoJogoMenu.imprimirAnimacaoCartaAtual(cartaAtual)
            Thread.sleep(500)
//            TextoJogoMenu.imprimirRespostaCartaAtual(cartaAtual)
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
        }
    }

    override fun passarFlashcard(acertou: Boolean): Flashcard? {
        return sortearFlashcard(acertou)
    }

    override fun sortearFlashcard(acertou: Boolean): Flashcard? {
        cartaAtual = sortear.sortear(cards, acertou)
        cartaVirada = false
        return cartaAtual
    }

    fun getCartaAtual(): Flashcard? {
        if (cartaAtual == null) { // se o jogador ainda não tem uma carta, sorteia uma carta para ele
            cartaAtual = sortearFlashcard(true)
        }
        return cartaAtual
    }

    fun isCartaVirada(): Boolean {
        return cartaVirada
    }
}