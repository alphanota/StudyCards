package com.montero.studycards.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.montero.studycards.db.repos.CardRepo

class CardListViewModel @ViewModelInject constructor(
    private val cardRepo: CardRepo,
    @Assisted private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val cards = cardRepo.getCards()



}