package com.example.segundaprovaii.banco

import com.example.segundaprovaii.Praias

@Database(entities = arrayOf(Praias :: class), version = 1)
abstract class Database() : RoomDatabase() {
    abstract fun Dao() : Dao
}
