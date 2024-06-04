package br.com.ulbra.ap2

import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.configureToolbar(title: String, enableBackButton: Boolean){
    supportActionBar?.apply{
        this.title = title
        setDisplayHomeAsUpEnabled(enableBackButton)

    }
}

