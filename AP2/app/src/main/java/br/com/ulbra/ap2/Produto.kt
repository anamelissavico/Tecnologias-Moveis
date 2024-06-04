package br.com.ulbra.ap2

import java.io.Serializable

data class Produto(
    val urlImage: String,
    val name: String,
    val price: String,
    val descricao: String
) : Serializable
