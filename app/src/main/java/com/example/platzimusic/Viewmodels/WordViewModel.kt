package com.example.platzimusic.Viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.platzimusic.DB.WordRoomDataBase
import com.example.platzimusic.Repositories.WordRepository
import com.example.platzimusic.models.Word
import kotlinx.coroutines.launch

class WordViewModel(application: Application): AndroidViewModel(application) {
private val repository: WordRepository
    val allWords: LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDataBase.getDataBase(application, viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}