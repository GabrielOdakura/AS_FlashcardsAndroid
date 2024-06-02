package com.example.projetoflashcards.model.persistencia.adapters

import com.example.projetoflashcards.model.tipos.Flashcard
import com.example.projetoflashcards.model.tipos.Flashcards
import java.util.LinkedList


class PacoteCartasBasico {
    fun gerarPacoteBase(): Flashcards {
        val cartas = LinkedList<Flashcard?>()
        cartas.add(Flashcard("Qual a capital da Rússia?", "Moscou", true, ""))
        cartas.add(Flashcard("Qual a capital do Afeganistão?", "Cabul", true, ""))
        cartas.add(Flashcard("Qual a capital da Alemanha?", "Berlim", true, ""))
        cartas.add(Flashcard("Qual a capital da Bélgica?", "Bruxelas", true, ""))
        cartas.add(Flashcard("Qual a capital da Coria do Sul?", "Seul", true, ""))
        cartas.add(Flashcard("Qual a capital da Egito?", "Cairo", true, ""))
        cartas.add(Flashcard("Qual a capital da Espanha?", "Madri", true, ""))
        cartas.add(Flashcard("Qual a capital da China?", "Pequim", true, ""))
        cartas.add(Flashcard("Qual a capital do Brasil?", "Brasília", true, ""))
        cartas.add(Flashcard("Qual a capital da França?", "Paris", true, ""))
        cartas.add(Flashcard("Qual a capital da Grécia?", "Atenas", true, ""))
        cartas.add(Flashcard("Qual a capital da Suíça?", "Berna", true, ""))
        cartas.add(Flashcard("Qual a capital da Tailândia?", "Bangkok", true, ""))
        return Flashcards(cartas)
    }
}