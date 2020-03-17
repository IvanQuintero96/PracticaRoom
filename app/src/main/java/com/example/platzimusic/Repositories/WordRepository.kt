package com.example.platzimusic.Repositories

import androidx.lifecycle.LiveData
import com.example.platzimusic.DB.WordDao
import com.example.platzimusic.models.Word

class WordRepository(private val wordDao: WordDao) {

    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizeWords()

    suspend fun insert(word: Word){
        wordDao.insert(word)
    }
}