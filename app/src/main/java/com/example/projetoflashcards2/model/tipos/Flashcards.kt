package com.example.projetoflashcards.model.tipos

import com.example.projetoflashcards.model.persistencia.PersistenciaLink
import java.util.LinkedList



class Flashcards {
    private var cards: LinkedList<Flashcard?>? = null
    private var numeroDeCartas = 0
    private val persistencia: PersistenciaLink = PersistenciaLink()

    constructor(carta: Flashcard) {
        cards = LinkedList()
        cards!!.add(carta)
        numeroDeCartas = cards!!.size
    }

    constructor(cartoes: LinkedList<Flashcard?>?) {
        if (cartoes != null) {
            cards = cartoes
            numeroDeCartas = cards!!.size
        }
    }

    constructor(nomeDoArquivo: String) {
        carregarFlashcards(nomeDoArquivo)
        numeroDeCartas = cards!!.size
    }

    fun carregarFlashcards(nomeDoArquivo: String) {
        cards = persistencia.carregarFlashcards(nomeDoArquivo.toString())
    }

    fun criarFlashcards(
        nomeDoArquivo: String?,
        pergunta: String?,
        resposta: String?,
        enabled: Boolean,
        link: String?
    ) { //adicionar nomeDoArquivo dps
        persistencia.salvarFlashcards(nomeDoArquivo, pergunta, resposta, enabled, link)
    }

    fun removerFlashcards(nomeDoArquivo: String?, id: Int) {
        persistencia.removerFlashCards(nomeDoArquivo, id)
    }

    fun getNumeroDeCartas(): Int {
        return numeroDeCartas
    }

    private fun setNumeroDeCartas(numeroDeCartas: Int) {
        this.numeroDeCartas = numeroDeCartas
    }

    fun getCards(): LinkedList<Flashcard?>? {
        return cards
    }

    fun setCards(cards: LinkedList<Flashcard?>?) {
        this.cards = cards
    }

    fun getCard(index: Int): Flashcard? {
        return cards!![index]
    }
}