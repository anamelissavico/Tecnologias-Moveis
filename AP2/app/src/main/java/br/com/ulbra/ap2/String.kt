package br.com.ulbra.ap2

fun String.converterDinheiro() = "R$" .plus(this.replace(".", ","))