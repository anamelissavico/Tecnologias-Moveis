package br.com.ulbra.ap2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar= findViewById<Toolbar>(R.id.toolbar)
        val menuBottom = findViewById<BottomNavigationView>(R.id.bottomMenu)
        val navController = Navigation.findNavController(this, R.id.my_nav_host_fragment)

        setSupportActionBar(toolbar)
        NavigationUI.setupWithNavController(menuBottom, navController)
        configureToolbar("Home", false)
    }

    private fun mostrarDetalhes(item: Produto){
        Intent(this,DetalheProdutoActivity::class.java).apply{
            putExtra("data",item)
            startActivity(this)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}