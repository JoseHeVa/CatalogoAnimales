package com.example.`10 Catalogo`

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(private val listaAnimales: List<Animal>) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvIcono: TextView = itemView.findViewById(R.id.tvIcono)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(vista)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = listaAnimales[position]
        holder.tvIcono.text = animal.emoji
        holder.tvNombre.text = animal.nombre
        holder.tvDescripcion.text = animal.descripcion

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Seleccionaste: ${animal.nombre}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int = listaAnimales.size
}
