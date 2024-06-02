package com.example.projetoflashcards.view.adapters.textbased

import com.example.projetoflashcards.model.utils.ConsoleUtils



class HubTexto {
    fun imprimirIntro() {
        println(" ______   __         ______     ______     __  __     ______     ______     ______     _____     ______    ")
        println("/\\  ___\\ /\\ \\       /\\  __ \\   /\\  ___\\   /\\ \\_\\ \\   /\\  ___\\   /\\  __ \\   /\\  == \\   /\\  __-.  /\\  ___\\   ")
        println("\\ \\  __\\ \\ \\ \\____  \\ \\  __ \\  \\ \\___  \\  \\ \\  __ \\  \\ \\ \\____  \\ \\  __ \\  \\ \\  __<   \\ \\ \\/\\ \\ \\ \\___  \\  ")
        println(" \\ \\_\\    \\ \\_____\\  \\ \\_\\ \\_\\  \\/\\_____\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\ \\_\\ \\_\\  \\ \\_\\ \\_\\  \\ \\____-  \\/\\_____\\ ")
        println("  \\/_/     \\/_____/   \\/_/\\/_/   \\/_____/   \\/_/\\/_/   \\/_____/   \\/_/\\/_/   \\/_/ /_/   \\/____/   \\/_____/ ")
        println("_________________________________________________________________________________________________________________________________________________")
        imprimirOpcoesMenuPrincipal()
    }

    fun imprimirOpcoesMenuPrincipal() {
        println("Escolha uma das opções a seguir: \n1 - Menu de Flashcards\n2 - Modo de Jogo\n0 - Fechar Jogo\nOpção Escolhida: ")
    }

    fun imprimirOpcaoInvalida() {
        println("Opcao Invalida, tente novamente!\n")
    }

    fun imprimirMensagemErroFlashcardsCarregar() {
        println("Carregue algum pacote de Flashcards antes de jogar!\n")
    }

    fun imprimirSaidaDeJogo() {
        println("Obrigado por jogar!")
    }
}