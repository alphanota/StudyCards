package com.montero.studycards.db.repos

import com.montero.studycards.db.dao.CardDao
import com.montero.studycards.db.models.Card
import javax.inject.Inject

class CardRepo @Inject constructor(private val cardDao: CardDao) {
    fun getCards() = cardDao.list();

    fun getCard(id: String) = cardDao.retrieve(id)

    fun insertCard(card: Card) = cardDao.create(card)

}