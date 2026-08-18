package com.example.`10 Catalogo`

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaFragment : Fragment(R.layout.fragment_lista) {

    companion object {
        private const val ARG_CATEGORIA = "categoria"

        fun newInstance(categoria: String): ListaFragment {
            val fragment = ListaFragment()
            val args = Bundle()
            args.putString(ARG_CATEGORIA, categoria)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoria = arguments?.getString(ARG_CATEGORIA) ?: ""
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = AnimalAdapter(obtenerAnimalesPorCategoria(categoria))
    }

    private fun obtenerAnimalesPorCategoria(categoria: String): List<Animal> {
        return when (categoria) {
            "Mamíferos" -> listOf(
                Animal("León", "Gran felino que vive en manadas", "🦁"),
                Animal("Elefante", "El mamífero terrestre más grande", "🐘"),
                Animal("Delfín", "Mamífero marino muy inteligente", "🐬")
            )
            "Aves" -> listOf(
                Animal("Águila", "Ave rapaz de gran envergadura", "🦅"),
                Animal("Pingüino", "Ave no voladora adaptada al frío", "🐧"),
                Animal("Colibrí", "El ave más pequeña del mundo", "🐦")
            )
            else -> listOf(
                Animal("Tortuga", "Reptil de caparazón duro y larga vida", "🐢"),
                Animal("Cocodrilo", "Reptil depredador semiacuático", "🐊"),
                Animal("Iguana", "Reptil arborícola de zonas tropicales", "🦎")
            )
        }
    }
}
