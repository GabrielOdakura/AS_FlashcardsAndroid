package com.example.projetoflashcards.model.tipos

class Flashcard {

    private var pergunta: String = ""
    private var resposta: String = ""
    private var enabled = false
    private var link: String = ""

    constructor(pergunta: String, resposta: String, enabled: Boolean, link: String)
    {
        setPergunta(pergunta)
        setResposta(resposta)
        setEnabled(enabled)
        setLink(link)
    }

    fun getPergunta(): String {
        return pergunta
    }

    fun setPergunta(perguntaEntrada: String) {
        pergunta = perguntaEntrada
    }

    fun getResposta(): String {
        return resposta
    }

    fun setResposta(respostaEntrada: String) {
        resposta = respostaEntrada
    }

    fun isEnabled(): Boolean {
        return enabled
    }

    fun setEnabled(enabledEntrada: Boolean) {
        enabled = enabledEntrada
    }

    fun getLink(): String {
        return link
    }

    fun setLink(linkEntrada: String) {
        link = linkEntrada
    }
}