package br.com.ulbra.ap2

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ProdutoAdapter (
    private val itens: MutableList<Produto>,
    private val mostrarDetalhes: (item : Produto) -> Unit,
    //val removeItem: (index: Int) -> Unit,
    ) : RecyclerView.Adapter <ProdutoAdapter.ViewHolder>(){

        private lateinit var context: Context

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            context = parent.context

            val view = LayoutInflater.from(context).inflate(R.layout.produto_item,parent,false)

            return ViewHolder(view)
    }

    override fun getItemCount() = itens.size


    override fun onBindViewHolder(holder: ProdutoAdapter.ViewHolder, position: Int) {
        holder.itemView.rootView.setOnClickListener {
            mostrarDetalhes(itens[position])
        }


        holder.itemView.rootView.setOnLongClickListener {
            mostrarPopupMenu(holder.itemView,position)
          true
        }

        Glide
            .with(context)
            .load(itens[position].urlImage)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imagemProduto)

        holder.nomeProduto.text = itens[position].name

        holder.precoProduto.text = itens[position].price.converterDinheiro()

        if (context is DetalheProdutoActivity) {
            // Se for, exibe a descrição
            holder.descricaoProduto.visibility = View.VISIBLE
            holder.descricaoProduto.text = itens[position].descricao
        } else {
            // Se não for, oculta a descrição
            holder.descricaoProduto.visibility = View.GONE}

    }

    class ViewHolder (view: View): RecyclerView.ViewHolder (view){
        val imagemProduto: ImageView
        val nomeProduto: TextView
        val precoProduto: TextView
        val descricaoProduto : TextView

        init {
            nomeProduto = view.findViewById(R.id.tvNomeProduto)
            imagemProduto = view.findViewById(R.id.imgProduto)
            precoProduto = view.findViewById(R.id.tvPrecoProduto)
            descricaoProduto= view.findViewById(R.id.tvDescricaoProduto)
        }
    }

    private fun mostrarPopupMenu (view: View, position: Int){
        PopupMenu(context, view).apply{
            setOnMenuItemClickListener { item ->
                when (item.itemId){
                    R.id.deletar -> {
                        removeItem(itens[position])
                        true
                    }

                    else -> false
                }
            }
            inflate(R.menu.menu_popup)
            show()
        }
    }

    private fun removeItem(produto: Produto){
        itens.remove(produto)
        notifyDataSetChanged()
    }
}
