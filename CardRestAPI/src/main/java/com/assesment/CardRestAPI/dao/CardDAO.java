package com.assesment.CardRestAPI.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.assesment.CardRestAPI.model.Card;

public class CardDAO {

	private static final Map<String, Card> cardMap = new HashMap<String, Card>();

	@Override
	public String toString() {
		return "CardDAO [getAllCard()=" + getAllCard() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	static {
		initCard();
	}

	private static void initCard() {
		Card card1 = new Card();
		card1.setCardNo("C01");
		card1.setName("Smith");
		card1.setType("Visa");

		Card card2 = new Card();
		card2.setCardNo("C02");
		card2.setName("Allen");
		card2.setType("Master");

		Card card3 = new Card();
		card3.setCardNo("C03");
		card3.setName("John");
		card3.setType("Visa");

		cardMap.put(card1.getCardNo(), card1);
		cardMap.put(card2.getCardNo(), card2);
		cardMap.put(card3.getCardNo(), card3);
	}

	public Card getCard(String CardNo) {
		return cardMap.get(CardNo);
	}

	public Card createCard(Card card) {
		cardMap.put(card.getCardNo(), card);
		return card;
	}

	public Card updateCard(Card card) {
		cardMap.put(card.getCardNo(), card);
		return card;
	}

	public void deleteCard(String cardNo) {
		cardMap.remove(cardNo);
	}

	public List<Card> getAllCard() {
		Collection<Card> c = cardMap.values();
		List<Card> list = new ArrayList<Card>();
		list.addAll(c);
		return list;
	}
}
