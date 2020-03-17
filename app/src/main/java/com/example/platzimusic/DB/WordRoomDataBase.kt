package com.example.platzimusic.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.platzimusic.models.Word
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Word::class], version = 1, exportSchema = false)
public abstract class WordRoomDataBase: RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object{
        @Volatile
        private var INSTANCE: WordRoomDataBase? = null

        fun getDataBase(context: Context, scope: CoroutineScope): WordRoomDataBase {
            val tempInstance =
                INSTANCE
            if (tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    WordRoomDataBase::class.java,
                    "word_database"
                ).build()

                INSTANCE = instance
                return instance
            }

        }
    }
}