package com.example.projetoflashcards.model.persistencia.adapters

import com.example.projetoflashcards.interfaces.InterfacePersistencia
import com.example.projetoflashcards.model.tipos.Flashcard
import com.example.projetoflashcards.model.tipos.Flashcards
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONTokener
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.IOException
import java.util.LinkedList


class JSONAdapter : InterfacePersistencia{

    override fun salvarFlashcards(
        nomeDoArquivo: String?,
        pergunta: String?,
        resposta: String?,
        enabled: Boolean,
        link: String?
    ): Boolean {
        val list: LinkedList<Flashcard?>?
        var sucesso = false
        try {
            val jsonObject = JSONObject(JSONTokener("$nomeDoArquivo.json"))

            list = carregarElementos(jsonObject, true)

            // coloca as informações da cartas já carregadas em um array de objects
            val root = JSONObject()
            var cartas: JSONObject
            val cartasArray = JSONArray()
            var FlashcardAtual: Flashcard
            for (i in list!!.indices) {
                FlashcardAtual = list[i]!!
                cartas = JSONObject()
                cartas.put("pergunta", FlashcardAtual.getPergunta())
                cartas.put("resposta", FlashcardAtual.getResposta())
                cartas.put("enabled", FlashcardAtual.isEnabled())
                cartas.put("link", FlashcardAtual.getLink())
                cartasArray.put(cartas)
            }

            //colocando a carta inserida pelo usuário
            cartas = JSONObject()
            cartas.put("pergunta", pergunta)
            cartas.put("resposta", resposta)
            cartas.put("enabled", enabled)
            cartas.put("link", link)
            cartasArray.put(cartas)

            //colocando dentro da root do arquivo
            root.put("cartas", cartasArray)

//            val writer = FileWriter(("$nomeDoArquivo.json"))
//            writer.write(root.toString(4))
//            writer.close()
            val jsonString = cartasArray.toString()
            FileOutputStream("$nomeDoArquivo.json").use { outputStream ->
                outputStream.write(jsonString.toByteArray())
            }
            println("Arquivo Salvo!")
            sucesso = true

            //finalizar
        } catch (e: FileNotFoundException) {
            println("Arquivo Não Encontrado! Criando um arquivo novo!")

            try {
                val root = JSONObject()
                val carta = JSONObject()
                val cartasArray = JSONArray()

                carta.put("pergunta", pergunta)
                carta.put("resposta", resposta)
                carta.put("enabled", enabled)
                carta.put("link", link)

                cartasArray.put(carta)
                root.put("cartas", cartasArray)

//                val writer = FileWriter("$nomeDoArquivo.json")
//                writer.write(root.toString(4))
//                writer.close()
                val jsonString = cartasArray.toString()
                FileOutputStream("$nomeDoArquivo.json").use { outputStream ->
                    outputStream.write(jsonString.toByteArray())
                }
                println("Arquivo criado com sucesso!")
                sucesso = true
            } catch (ex: IOException) {
                println("Arquivo não pode ser criado/lido!")
            }
        } catch (e: IOException) {
            println("Arquivo não pode ser criado/lido!")
        } catch (e: JSONException) {
            println("Arquivo não pode ser lido! (Formatação Errada)")
        }
        return sucesso
    }

    override fun carregarFlashcards(nomeDoArquivo: String?): LinkedList<Flashcard?>? {
        var list: LinkedList<Flashcard?>? = null
        try {
            val reader = "$nomeDoArquivo.json"

            // Criar um objeto JSON a partir do arquivo
            val jsonObject = JSONObject(JSONTokener(reader))

            list = carregarElementos(jsonObject, false)
        } catch (e: FileNotFoundException) {
            println("Arquivo não encontrado! Tente novamente!\n")
        }
        return list
    }

    override fun removerFlashCards(nomeDoArquivo: String?, id: Int) {
        val list: LinkedList<Flashcard>
        try {
            val reader = "$nomeDoArquivo.json"

            val jsonObject = JSONObject(JSONTokener(reader))

            list = carregarParaRemover(jsonObject)

            if (!list.isEmpty()) {
                val card = list[id]
                if (card.isEnabled()) card.setEnabled(false)
                else card.setEnabled(true)

                // coloca as informações da cartas já carregadas em um array de objects
                val root = JSONObject()
                var cartas: JSONObject
                val cartasArray = JSONArray()
                var FlashcardAtual: Flashcard
                for (i in list.indices) {
                    FlashcardAtual = list[i]
                    cartas = JSONObject()
                    cartas.put("pergunta", FlashcardAtual.getPergunta())
                    cartas.put("resposta", FlashcardAtual.getResposta())
                    cartas.put("enabled", FlashcardAtual.isEnabled())
                    cartas.put("link", FlashcardAtual.getLink())
                    cartasArray.put(cartas)
                }

                //colocando dentro da root do arquivo
                root.put("cartas", cartasArray)

//                val writer = FileWriter(("$nomeDoArquivo.json"))
//                writer.write(root.toString(4))
//                writer.close()
                val jsonString = cartasArray.toString()
                FileOutputStream("$nomeDoArquivo.json").use { outputStream ->
                    outputStream.write(jsonString.toByteArray())
                }
            }
        } catch (e: FileNotFoundException) {
            println("Arquivo inexistente/nome errado!")
        } catch (e: IOException) {
            println("Não foi possível criar o arquivo atualizado!")
        }
    }

    override fun salvarPacoteBase(cartas: Flashcards?): Boolean {
        var sucesso = false
        var enabled: Boolean
        var pergunta: String
        var resposta: String
        var link: String
        var contador = 0

        try {
            val root = JSONObject()
            val cartasArray = JSONArray()
            do {
                pergunta = cartas!!.getCard(contador)!!.getPergunta()
                resposta = cartas.getCard(contador)!!.getResposta()
                enabled = cartas.getCard(contador)!!.isEnabled()
                link = cartas.getCard(contador)!!.getLink()
                val carta = JSONObject()

                carta.put("pergunta", pergunta)
                carta.put("resposta", resposta)
                carta.put("enabled", enabled)
                carta.put("link", link)

                cartasArray.put(carta)
                contador++
            } while (contador != cartas!!.getNumeroDeCartas())
            root.put("cartas", cartasArray)
//            val writer = FileWriter("PacoteBase.json")
//            val jsonString = Android.getFilesDir() + cartasArray.toString()
            FileOutputStream("PacoteBase.json").use { outputStream ->
                outputStream.write(jsonString.toByteArray())
            }
//            writer.write(root.toString(4))
//            writer.close()
            println("Arquivo criado com sucesso!")
            sucesso = true
        } catch (ex: IOException) {
            ex.printStackTrace()
            println("Arquivo não pode ser criado/lido!")
        }
        contador++
        return sucesso
    }

    /*=============métodos private para ajudar em códigos que são utilizados em mais de um lugar============*/
    private fun carregarElementos(jsonObject: JSONObject, bypass: Boolean): LinkedList<Flashcard?>? {
        val list = LinkedList<Flashcard?>()

        if (jsonObject.length() > 0) { //verifica se não é um arquivo vazio
            val arrayCartas = jsonObject.getJSONArray("cartas")
            if (arrayCartas.length() > 0) {
                var pergunta = ""
                var resposta = ""
                var link = ""
                for (i in 0 until arrayCartas.length()) { //loop para pegar carta por carta e transf em um Flashcard
                    val carta = arrayCartas.getJSONObject(i)
                    var enabled = carta.getBoolean("enabled")
                    if (bypass) enabled = true
                    if (enabled) {
                        pergunta = carta.getString("pergunta")
                        resposta = carta.getString("resposta")
                        link = carta.getString("link")
                        enabled = carta.getBoolean("enabled")
                        val novoFlashcard = Flashcard(pergunta, resposta, enabled, link)
                        list.add(novoFlashcard)
                    }
                }
                println("Arquivo Carregado com Sucesso!")
            }
        } else {
            println("Arquivo vazio!")
        }
        return list
    }

    private fun carregarParaRemover(jsonObject: JSONObject): LinkedList<Flashcard> {
        val list = LinkedList<Flashcard>()

        if (jsonObject.length() > 0) { //verifica se não é um arquivo vazio
            val arrayCartas = jsonObject.getJSONArray("cartas")
            if (arrayCartas.length() > 0) {
                var pergunta = ""
                var resposta = ""
                var link = ""

                for (i in 0 until arrayCartas.length()) { //loop para pegar carta por carta e transf em um Flashcard
                    val carta = arrayCartas.getJSONObject(i)
                    val enabled = carta.getBoolean("enabled")
                    pergunta = carta.getString("pergunta")
                    resposta = carta.getString("resposta")
                    link = carta.getString("link")
                    val novoFlashcard = Flashcard(pergunta, resposta, enabled, link)
                    list.add(novoFlashcard)
                }
            }
        } else {
            println("Arquivo vazio!")
        }
        return list
    }

}