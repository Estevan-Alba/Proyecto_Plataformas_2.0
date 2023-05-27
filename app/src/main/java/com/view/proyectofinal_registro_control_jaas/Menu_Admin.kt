package com.view.proyectofinal_registro_control_jaas

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.navigation.NavigationView

class Menu_Admin : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_admin)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(this,drawer,toolbar,R.string.navegacion_drawer_open,R.string.navegacion_drawer_close)
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val NavigationView: NavigationView = findViewById(R.id.nav_view)
        NavigationView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item1 -> {
                supportFragmentManager.commit {
                    replace<Fragment_Admin_M_E>(R.id.contenedorfracmento)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
            }
            R.id.nav_item2 -> {
                Toast.makeText(this,"item 2", Toast.LENGTH_SHORT).show()

            }

            R.id.nav_item3 -> {
                Toast.makeText(this,"item 3", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_item4 -> {
                val intent = Intent(this, Menu_Login::class.java)
                startActivity(intent)
                Toast.makeText(this,"Se cerro la sesion", Toast.LENGTH_SHORT).show()

            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return  true
    }

}