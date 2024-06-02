package com.example.projetoflashcards.model.sortear

import com.example.projetoflashcards.interfaces.InterfaceSortear
import com.example.projetoflashcards.model.tipos.Flashcard
import com.example.projetoflashcards.model.tipos.Flashcards
import kotlin.random.Random


class SorteioRandom : InterfaceSortear {
    private var ultimoNumero = 0

    override fun sortear(cards: Flashcards?, acertou: Boolean): Flashcard? {
        var numSorteado = 0
        val random: Random = Random
        do {
            numSorteado = random.nextInt(0, (cards!!.getNumeroDeCartas() - 1))
        } while (ultimoNumero == numSorteado)
        ultimoNumero = numSorteado
        return cards.getCard(numSorteado)
    }
}