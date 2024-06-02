package com.example.projetoflashcards.controller

import android.os.Parcel
import android.os.Parcelable
import com.example.projetoflashcards.model.persistencia.PersistenciaLink
import com.example.projetoflashcards.model.persistencia.adapters.PacoteCartasBasico
import com.example.projetoflashcards.model.tipos.Flashcard
import com.example.projetoflashcards.model.tipos.Flashcards
import com.example.projetoflashcards.view.adapters.textbased.TextoDoisJogadores
import com.example.projetoflashcards.view.adapters.textbased.TextoJogoMenu
import kotlinx.parcelize.Parcelize
import java.io.Serializable
import java.util.InputMismatchException
import java.util.Scanner

@Parcelize
class ControleFlashMenu : Parcelable {
    private var cards: Flashcards? = null
    var cartasCarregadas : Boolean = false
    private val persistencia : PersistenciaLink = PersistenciaLink()

    fun menuFlashcards(entrada : Int): Boolean{
        var opcao : Int = 0
        return false
    }
    fun salvarCarta(nomeDoArquivo : String, pergunta : String, resposta : String, enabled : Boolean, link: String){
        if (persistencia.salvarFlashcards(nomeDoArquivo, pergunta, resposta, enabled, link)) { //carrega os flashcards no arquivo + o novo
            cards = nomeDoArquivo?.let { Flashcards(it) }
            cartasCarregadas = true
        } else { //se nenhum card estiver carregado ele cria um novo
            val auxFlashcard = Flashcard(
                pergunta!!, resposta!!, enabled,
                link!!
            )
            cards = Flashcards(auxFlashcard)
        }
    }
    fun carregarCartas(nomeDoArquivo : String){
        cards = Flashcards(nomeDoArquivo.toString())
        if(cards == null) cartasCarregadas = false
    }
    fun removerCarta(nomeDoArquivo : String, id : Int){
        try {
            persistencia.removerFlashCards(nomeDoArquivo, id)
        } catch (e: Exception) {

        }
    }
    fun gerarPacoteBase(){
        val pacoteBase = PacoteCartasBasico()
        if (persistencia.salvarPacoteBase(pacoteBase.gerarPacoteBase())) {
            cards = Flashcards("PacoteBase")
            cartasCarregadas = true
        }
    }
    fun umJogador(){

    }
    fun doisJogadores(){

    }
    fun isCartasCarregadas(): Boolean{
        return cartasCarregadas
    }
    @Deprecated ("Desktop Mode Only")
    fun menuFlashcards(): Boolean {
        var cartasCarregadas = false
        var opcao = 0
        var flipflop = true

        val input = Scanner(System.`in`)
        do {
//            TextoFlashMenu.imprimirMenu()
            opcao = 0
            var nomeDoArquivo: String? = ""
            try {
                opcao = input.nextInt()
                if (opcao >= 1 && opcao <= 3) {
                    if (flipflop) {
//                        TextoFlashMenu.imprimirSolicitarNomeArquivo()
                        input.nextLine()
                        nomeDoArquivo = input.nextLine()
                        flipflop = false
                    }
                }
            } catch (e: InputMismatchException) { // caso o usuario entre um tipo errado gera uma exceção
//                TextoFlashMenu.imprimirErroDeEntrada()
//                TextoFlashMenu.imprimirMenu()
                opcao = -1
            }
            if (opcao == 1) { // salvar flashcard
                var pergunta: String? = ""
                var resposta: String? = ""
                var link: String? = ""
                var aux = ""
                var enabled = false
                for (i in 0..3) {
//                    TextoFlashMenu.imprimirSalvarNovoFlashcard(i) //chama o menu 1 por 1 para o tipo de info que ele quer
                    if (i == 0) { //pede a pergunta pro usuário
                        pergunta = input.nextLine()
                    } else if (i == 1) { //pede a resposta pro usuário
                        resposta = input.nextLine()
                    } else if (i == 2) { //pergunta se a carta vai estar habilitada pro usuário
                        aux = input.nextLine()
                        if (!aux.isEmpty()) {
                            enabled = aux.equals(
                                "enabled",
                                ignoreCase = true
                            ) //se for igual a enabled coloca como true
                        }
                    } else if (i == 3) { //pede um link caso o usuário queira importar uma imagem
                        link = input.nextLine()
                    }
                }
                if (persistencia.salvarFlashcards(nomeDoArquivo, pergunta, resposta, enabled, link)) { //carrega os flashcards no arquivo + o novo
                    cards = nomeDoArquivo?.let { Flashcards(it) }
                    cartasCarregadas = true
                } else { //se nenhum card estiver carregado ele cria um novo
                    val auxFlashcard = Flashcard(
                        pergunta!!, resposta!!, enabled,
                        link!!
                    )
                    cards = Flashcards(aux)
                }
                flipflop = true
            } else if (opcao == 2) { //carregar flashcards
                cards = Flashcards(nomeDoArquivo.toString())
                flipflop = true
            } else if (opcao == 3) { //deletar flashcard
                var id = -1
                try {
//                    TextoFlashMenu.imprimirEscolhaDeId()
                    val temp = input.nextLine()
                    if (temp.isEmpty()) throw InputMismatchException()
                    id = temp.toInt()
                    persistencia.removerFlashCards(nomeDoArquivo, id)
                    //                     input.nextLine();//por conta do nextInt já que ele não pula uma linha depois de ler o id
                } catch (e: InputMismatchException) { // caso o usuario entre um tipo errado gera uma exceção
//                    TextoFlashMenu.imprimirErroDeEntrada()
                    id = -1
                } catch (e: Exception) {
                    id = -1
                }
                if (id == -1) { //se ele for -1 é que ocorreu um erro
//                    TextoFlashMenu.imprimirErroDeId()
                }
            } else if (opcao == 4) {
                val pacoteBase = PacoteCartasBasico()
                if (persistencia.salvarPacoteBase(pacoteBase.gerarPacoteBase())) {
                    cards = Flashcards("PacoteBase")
                    cartasCarregadas = true
                }
            } else if (opcao == 0) {
//                TextoFlashMenu.imprimirVoltandoMenu()
            } else { // caso a opção não seja valida ele manda uma mensagem de erro e repete o loop
//                TextoFlashMenu.imprimirOpcaoInvalida()
                opcao = -1
            }
        } while (opcao != 0)
        return cartasCarregadas
    }

    @Deprecated ("Desktop Mode Only")
    fun MenuModoDeJogo() {
        var opcao = 0
        val input = Scanner(System.`in`)
        var jogadorAcertou = false
        do {
//            TextoJogoMenu.imprimirMenu() // chama o metodo do view pra imprimir no console
            opcao = try {
                input.nextInt()
            } catch (e: InputMismatchException) {
                -1
            }
            if (opcao == 1) { // seleciona o modo de um jogador
                val modoDeJogo = ControleUmJogador(cards)
                var acertos = 0
                do {
//                    TextoUmJogador.imprimirCarta(modoDeJogo.getCartaAtual())
//                    TextoUmJogador.imprimirMenu()
//                    TextoUmJogador.imprimirAcertos(acertos)
                    try {
                        opcao = input.nextInt()
                    } catch (e: InputMismatchException) {
//                        TextoJogoMenu.imprimirOpcaoInvalida()
                        opcao = -1
                    }
                    if (opcao == 1) {
//                        TextoUmJogador.imprimirCarta(modoDeJogo.getCartaAtual())
                        input.nextLine() // pula a linha para a resposta, devido ao nextInt()
                        if (!modoDeJogo.isCartaVirada()) {
//                            TextoUmJogador.imprimirEntradaResposta()
                            val resposta = input.nextLine()
                            jogadorAcertou =
                                modoDeJogo.responder(resposta) //verifica se a resposta esta correta
                        } else { //caso a carta estiver virada o jogador não pode tentar responder
//                            TextoUmJogador.imprimirCartaJaVirada()
                        }
                        if (jogadorAcertou) acertos++
                    } else if (opcao == 2) { // passa o flashcard
                        modoDeJogo.passarFlashcard(false)
                    } else if (opcao == 3) { // sorteia um novo flashcard
                        modoDeJogo.sortearFlashcard(jogadorAcertou)
                    } else if (opcao == 4) { //vira o flashcard para o jogador ver a resposta
                        modoDeJogo.virarFlashcard()
                    } else {
//                        TextoJogoMenu.imprimirOpcaoInvalida()
                    }
                } while (opcao != 0)
                opcao = -1
            } else if (opcao == 2) { // seleciona o modo de dois jogadores
                val modoDeJogo = ControleDoisJogadores(cards)
                val acertos = IntArray(2)
                do {
//                    TextoDoisJogadores.imprimirCarta(modoDeJogo.getCartaAtual())
                    var jogadorAtual = if (modoDeJogo.getVezJogador()) "P1"
                    else "P2"
//                    TextoDoisJogadores.imprimirMenu(jogadorAtual)
//                    TextoDoisJogadores.imprimirAcertos(acertos)
                    try {
                        opcao = input.nextInt()
                    } catch (e: InputMismatchException) {
//                        TextoJogoMenu.imprimirOpcaoInvalida()
                        opcao = -1
                    }
                    if (opcao == 1) {
//                        TextoDoisJogadores.imprimirCarta(modoDeJogo.getCartaAtual())
                        input.nextLine() // pula a linha para a resposta, devido ao nextInt()
                        if (!modoDeJogo.isCartaVirada()) {
//                            TextoDoisJogadores.imprimirEntradaResposta()
                            val resposta = input.nextLine()
                            jogadorAcertou =
                                modoDeJogo.responder(resposta) //verifica se a resposta esta correta
                        } else { //caso a carta estiver virada o jogador não pode tentar responder
//                            TextoDoisJogadores.imprimirCartaJaVirada()
                        }
                        if (jogadorAcertou) {
                            if (modoDeJogo.getVezJogador()) acertos[0]++ //adiciona a pontuação do jogador 1
                            else acertos[1]++ //adiciona a pontuação do jogador 2
                        }
                    } else if (opcao == 2) { // passa o flashcard
                        modoDeJogo.passarFlashcard(false)
                    } else if (opcao == 3) { // sorteia um novo flashcard
                        modoDeJogo.sortearFlashcard(jogadorAcertou)
                    } else if (opcao == 4) { //vira o flashcard para o jogador ver a resposta
                        modoDeJogo.virarFlashcard()
                    } else if (opcao == 5) { // vê o flashcard do outro jogador
//                        TextoDoisJogadores.imprimirCartaOutroJogador(modoDeJogo.espiarFlashcard())
                    } else if (opcao == 6) { // troca os flashcards entre os jogadores
                        modoDeJogo.trocarCartas()
//                        TextoDoisJogadores.imprimirMensagemCartasTrocadas()
                    } else if (opcao == 7) { // troca a vez do jogador
                        modoDeJogo.passarVez()
                    } else {
//                        TextoJogoMenu.imprimirOpcaoInvalida()
                    }
                } while (opcao != 0)
                opcao = -1
            } else{
                //TextoJogoMenu.imprimirOpcaoInvalida()
            }
        } while (opcao != 0)
    }
}