package com.example.projetoflashcards.interfaces

import com.example.projetoflashcards.model.tipos.Flashcard
import com.example.projetoflashcards.model.tipos.Flashcards

interface InterfaceJogadores {
    var cards: Flashcards?
    fun virarFlashcard()
    fun passarFlashcard(acertou: Boolean): Flashcard?
    fun sortearFlashcard(acertou: Boolean): Flashcard?
    fun responder(resposta: String?): Boolean
}