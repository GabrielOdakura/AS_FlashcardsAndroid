package com.example.projetoflashcards.model.sortear

import com.example.projetoflashcards.interfaces.InterfaceSortear
import com.example.projetoflashcards.model.tipos.Flashcard
import com.example.projetoflashcards.model.tipos.Flashcards


class Leitner : InterfaceSortear {
    override fun sortear(cards: Flashcards?, acertou: Boolean): Flashcard? {
        return null
    }
}