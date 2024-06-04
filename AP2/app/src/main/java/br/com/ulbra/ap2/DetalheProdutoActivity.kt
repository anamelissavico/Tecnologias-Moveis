package br.com.ulbra.ap2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.bumptech.glide.Glide

class DetalheProdutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhe_produto)

        val produtoBundle = intent?.getSerializableExtra("data") as? Produto
        val toolbar= findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar).apply{"Detalhes"}
        configureToolbar("Home", false)


        val imagemProduto = findViewById<ImageView>(R.id.detalheImgProduto)
        val precoProduto = findViewById<TextView>(R.id.detalhePrecoProduto)
        val nomeProduto = findViewById<TextView>(R.id.detalheNomeProduto)
        val descricaoProduto = findViewById<TextView>(R.id.detalheDescProduto)

        nomeProduto.text = produtoBundle?.name
        precoProduto.text = produtoBundle?.price
        descricaoProduto.text=produtoBundle?.descricao

        Glide.with(this).load(produtoBundle?.urlImage).into(imagemProduto)

        configureToolbar("Detalhes", false)
    }
}