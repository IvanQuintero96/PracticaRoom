package com.example.platzimusic.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.platzimusic.models.Word

@Dao
interface WordDao {

    @Query(" SELECT * from word_table ORDER BY word ASC")
    fun getAlphabetizeWords(): LiveData<List<Word>>

    // las corrutinas son un lugar seguro donde las funciones de suspension no bloquean el hilo principal
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word) // la funcion de suspension bloquea la ejecucion de la corrutina mientras hacen su trabajo

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}