package com.example.`10 Catalogo`

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PaginasAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val categorias = listOf("Mamíferos", "Aves", "Reptiles")

    override fun getCount(): Int = categorias.size

    override fun getItem(position: Int): Fragment {
        return ListaFragment.newInstance(categorias[position])
    }

    override fun getPageTitle(position: Int): CharSequence {
        return categorias[position]
    }
}
