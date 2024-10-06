package com.turing.alan.cpifp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.turing.alan.cpifp.R
import com.turing.alan.cpifp.data.Champion

class ChampionAdapter(private val champions: List<Champion>) : RecyclerView.Adapter<ChampionAdapter.ChampionViewHolder>()
{

    // Representa cada ítem en el RecyclerView
    class ChampionViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val championImage: ImageView = view.findViewById(R.id.champion_image)
        val championName: TextView = view.findViewById(R.id.champion_name)
        val championTitle: TextView = view.findViewById(R.id.champion_title)
        val championLore: TextView = view.findViewById(R.id.champion_lore)
    }

    // Crea nuevos ítems (ViewHolder)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_champion, parent, false)
        return ChampionViewHolder(view)
    }

    // Asigna los datos a cada ítem
    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int)
    {
        val champion = champions[position]
        holder.championName.text = champion.name
        holder.championTitle.text = champion.title
        holder.championLore.text = champion.lore

        // Cargar la imagen usando Coil
        holder.championImage.load(champion.imageUrl)
        {
            placeholder(R.drawable.ic_launcher_background)  // Imagen de placeholder mientras se carga
            error(R.drawable.ic_launcher_foreground)         // Imagen en caso de error
        }
    }

    // Número de elementos en la lista
    override fun getItemCount() = champions.size
}
