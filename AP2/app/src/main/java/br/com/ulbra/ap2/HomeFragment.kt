package br.com.ulbra.ap2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {
    private lateinit var produtoAdapter : ProdutoAdapter
    private lateinit var mainViewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)

        val listOfProdutos= mainViewModel.getProdutos()
        produtoAdapter= ProdutoAdapter(listOfProdutos){
            val bundle = bundleOf("data" to it)
            findNavController().navigate(R.id.action_homeFragment_to_detalheProdutoActivity2, bundle)

        }

        recycler.adapter=produtoAdapter
    }


    }
