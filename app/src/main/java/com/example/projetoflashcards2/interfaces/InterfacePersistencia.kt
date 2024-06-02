package com.example.projetoflashcards.interfaces

import com.example.projetoflashcards.model.tipos.Flashcard
import com.example.projetoflashcards.model.tipos.Flashcards
import java.util.LinkedList


interface InterfacePersistencia {
    fun salvarFlashcards(
        nomeDoArquivo: String?,
        pergunta: String?,
        resposta: String?,
        enabled: Boolean,
        link: String?
    ): Boolean

    fun carregarFlashcards(nomeDoArquivo: String?): LinkedList<Flashcard?>?
    fun removerFlashCards(nomeDoArquivo: String?, id: Int)
    fun salvarPacoteBase(cartas: Flashcards?): Boolean
}