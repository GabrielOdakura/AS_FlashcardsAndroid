package com.example.projetoflashcards.model.persistencia

import com.example.projetoflashcards.model.persistencia.adapters.JSONAdapter
import com.example.projetoflashcards.model.tipos.Flashcard
import com.example.projetoflashcards.model.tipos.Flashcards
import java.util.LinkedList


class PersistenciaLink {
    var adaptador: JSONAdapter = JSONAdapter()


    fun carregarFlashcards(nomeDoArquivo: String): LinkedList<Flashcard?>? {
        return adaptador.carregarFlashcards(nomeDoArquivo)
    }

    fun salvarFlashcards(
        nomeDoArquivo: String?,
        pergunta: String?,
        resposta: String?,
        enabled: Boolean,
        link: String?
    ): Boolean {
        return adaptador.salvarFlashcards(nomeDoArquivo, pergunta, resposta, enabled, link)
    }

    fun removerFlashCards(nomeDoArquivo: String?, id: Int) {
        adaptador.removerFlashCards(nomeDoArquivo, id)
    }

    fun salvarPacoteBase(cartas: Flashcards?): Boolean {
        return adaptador.salvarPacoteBase(cartas)
    }
}