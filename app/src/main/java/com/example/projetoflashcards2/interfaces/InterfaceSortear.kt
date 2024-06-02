package com.example.projetoflashcards.interfaces

import com.example.projetoflashcards.model.tipos.Flashcard
import com.example.projetoflashcards.model.tipos.Flashcards


interface InterfaceSortear {
    fun sortear(cards: Flashcards?, acertou: Boolean): Flashcard?
}