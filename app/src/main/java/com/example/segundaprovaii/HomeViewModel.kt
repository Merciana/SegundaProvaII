package com.example.segundaprovaii

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.segundaprovaii.banco.Database

class HomeViewModel (application: Application) : AndroidViewModel(application) {

    var list : LiveData<List<Praias>>

    init {
        val db: Database by lazy{
            Room.databaseBuilder(application.applicationContext,
                    Database::class.java, "praias.sqlite")
                    .allowMainThreadQueries()
                    .build()
        }
        list = db.Dao().listAll()
    }
}