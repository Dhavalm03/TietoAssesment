package com.assesment.CardRestAPI.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Card")
public class Card {

	private String cardNo;
	private String name;
	private String type;

	public Card(){
	}
	public Card(String cardNo, String name, String type) {
		super();
		this.cardNo = cardNo;
		this.name = name;
		this.type = type;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Card [cardNo=" + cardNo + ", name=" + name + ", type=" + type
				+ "]";
	}
	
}
