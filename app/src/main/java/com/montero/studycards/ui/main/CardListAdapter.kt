package com.montero.studycards.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.montero.studycards.databinding.CardLayoutBinding
import com.montero.studycards.db.models.Card



class CardListAdapter(private val parentFragment: CardListFragment
) : ListAdapter<Card, CardListAdapter.CardViewHolder>(CardDiffCallback()) {
    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            val item = v.tag as Card
            //TODO when user clicks on card, navigate to card detail
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class CardViewHolder private constructor (val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Card) {
            binding.card = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CardViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding  = CardLayoutBinding.inflate(layoutInflater, parent, false)
                return CardViewHolder(binding)
            }
        }


    }
}




class CardDiffCallback : DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(
        oldItem: Card,
        newItem: Card
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Card,
        newItem: Card
    ): Boolean {
        return oldItem == newItem
    }
}