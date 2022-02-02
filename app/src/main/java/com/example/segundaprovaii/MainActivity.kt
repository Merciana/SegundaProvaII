package com.example.segundaprovaii

import android.graphics.Insets.add
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.segundaprovaii.banco.Database
import com.example.segundaprovaii.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val banco: Database by lazy {
        Room.databaseBuilder(this, Database::class.java, "praias.sqlite")
                .allowMainThreadQueries()
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = Navigation.findNavController(this, R.id.homeFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.navView,navController)

        var p1 = Praias("ID", R.drawable.ic_launcher_foreground)
        var p2 = Praias("ID", R.drawable.ic_launcher_foreground)
        var p3 = Praias("ID", R.drawable.ic_launcher_foreground)

        with(banco.Dao()) {
            add(p1)
            add(p2)
            add(p3)
        }


        var listaContatos: MutableList<Praias> = banco.Dao().listAll()

        var adapter = PraiasAdapter(this, listaContatos)
        recyclerview.adapter = adapter

        var layout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerview.layoutManager = layout
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.homeFragment)
        return NavigationUI.navigateUp(navController, binding.drawerLayout)
    }
}