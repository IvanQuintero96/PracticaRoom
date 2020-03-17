package com.example.platzimusic.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.platzimusic.R
import com.example.platzimusic.models.Word
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class WordListAdapter internal constructor(context: Context): RecyclerView.Adapter<WordListAdapter.WordViewHolder>(){
private val inflater = LayoutInflater.from(context)
    private var words = emptyList<Word>()

    inner class WordViewHolder(itewView: View): RecyclerView.ViewHolder(itewView){
        val wordItemView: TextView = itewView.findViewById(R.id.tvText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itewView = inflater.inflate(R.layout.recyclerview_item,parent, false)
        return WordViewHolder(itewView)
    }


    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
       val current = words[position]
        holder.wordItemView.text = current.word
    }
    internal fun setWords(words: List<Word>){
        this.words = words
        notifyDataSetChanged()
    }

    override fun getItemCount()= words.size
}