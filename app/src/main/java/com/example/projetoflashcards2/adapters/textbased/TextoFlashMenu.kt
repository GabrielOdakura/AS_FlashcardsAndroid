package com.example.projetoflashcards.view.adapters.textbased

class TextoFlashMenu {
    fun imprimirMenu() {
        println(
            """
            
            Escolha uma opção:
            1 - Salvar Flashcard
            2 - Carregar Flashcard
            3 - Remover Flashcard
            4 - Gerar Pacote Basico
            0 - Sair Deste Menu
            Opção Escolhida: 
            """.trimIndent()
        )
    }

    fun imprimirErroDeEntrada() {
        println("\nEntrada Inválida! Digite um número!\n")
    }

    fun imprimirSalvarNovoFlashcard(indice: Int) {
        if (indice == 0) {
            println("Digite a pergunta: ")
        } else if (indice == 1) {
            println("Digite a resposta: ")
        } else if (indice == 2) {
            println("Digite se ela estará habilitada de padrão: ")
        } else if (indice == 3) {
            println("Digite um link para uma imagem(deixe em branco caso não queira adicionar): ")
        }
    }

    fun imprimirSolicitarNomeArquivo() {
        println("Digite o nome do arquivo: ")
    }

    fun imprimirOpcaoInvalida() {
        println("Opção Inválida, tente novamente!\n")
    }

    fun imprimirVoltandoMenu() {
        println("Voltando ao Menu Principal!\n")
    }

    fun imprimirEscolhaDeId() {
        println("Digite o id da carta a ser excluída:")
    }

    fun imprimirErroDeId() {
        println("Houve um erro com o ID/Não foi possível remover!")
    }
}