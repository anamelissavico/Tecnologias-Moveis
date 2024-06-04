package br.com.ulbra.ap2

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    fun getProdutos() = mutableListOf(
        Produto(
            urlImage = "https://as1.ftcdn.net/v2/jpg/00/69/85/64/1000_F_69856461_O8p56mlDwWo0mXFswcYbGbP7Ihlbimiw.jpg",
            name = "Hambúrguer\n Clássico",
            price = "35.00",
            descricao = "Carne bovina grelhada, queijo cheddar derretido, alface, tomate, cebola roxa, pão de hambúrguer."
        ),
        Produto(
            urlImage = "https://as2.ftcdn.net/v2/jpg/03/92/70/29/1000_F_392702963_FjJHWIk9JXiYhSujJfRvxs6gd0YwqSow.jpg",
            name = "Hambúrguer\n Vegetariano",
            price = "37.50",
            descricao = "Hambúrguer de grão-de-bico e vegetais, queijo de cabra, abacate, rúcula, molho pesto, pão integral."
        ),
        Produto(
            urlImage = "https://as1.ftcdn.net/v2/jpg/00/94/92/10/1000_F_94921053_Lc06uabhNtMNSKq6H5gBhZVDoI6nKjXW.jpg",
            name = "Hambúrguer\n Frango",
            price = "36.00",
            descricao = " Peito de frango grelhado, queijo suíço derretido, cogumelos salteados, cebola caramelizada, maionese de alho, pão de brioche."
           ),
        Produto(
            urlImage = "https://as2.ftcdn.net/v2/jpg/04/03/52/87/1000_F_403528712_74jz3pEwONfMx3hfsrRjX8fDRVLswnmt.jpg",
            name = "Hambúrguer\n BBQ",
            price = "40.50",
            descricao = "Carne bovina grelhada, queijo pepper jack derretido, bacon, cebola frita, alface, tomate, molho barbecue, pão de hambúrguer."
        ),
        Produto(
            urlImage = "https://as2.ftcdn.net/v2/jpg/03/32/50/57/1000_F_332505751_NUyBdTVeUQmsdMohc5LMPPOZ7EmqoX21.jpg",
            name = "Hambúrguer\n Picante",
            price = "35.50",
            descricao = "Carne bovina temperada com pimenta jalapeño, queijo pepper jack derretido, pimentão grelhado, jalapeños em conserva, alface, tomate, molho chipotle, pão de hambúrguer de pimenta."
        )


    )

}