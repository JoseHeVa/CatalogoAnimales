package com.example.`10 Catalogo`

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Catálogo de Animales"
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        // El icono de navegación del Toolbar abre el menú lateral
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navigationView.setNavigationItemSelectedListener { item ->
            Toast.makeText(this, "Seleccionaste: ${item.title}", Toast.LENGTH_SHORT).show()
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // ViewPager + TabLayout: cada pestaña carga un fragmento con su propio RecyclerView
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        viewPager.adapter = PaginasAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}
