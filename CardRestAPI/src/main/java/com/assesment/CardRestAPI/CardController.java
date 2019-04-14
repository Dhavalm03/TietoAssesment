package com.assesment.CardRestAPI;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.assesment.CardRestAPI.dao.CardDAO;
import com.assesment.CardRestAPI.model.Card;

@Path("cards")
public class CardController {

	private static final Logger LOGGER = Logger.getLogger(CardController.class
			.getName());

	CardDAO cardDAO = new CardDAO();

	@GET
	@Produces({ MediaType.APPLICATION_XML })
	public List<Card> getAllCards() {
		LOGGER.info("Get all cards called");
		List<Card> cards = cardDAO.getAllCard();
		LOGGER.info(cards.toString());
		return cards;
	}

	@GET
	@Path("/{cardNo}")
	@Produces({ MediaType.APPLICATION_XML })
	public Card getCard(@PathParam("cardNo") String cardNo) {
		Card card = cardDAO.getCard(cardNo);
		if (card == null) {
			LOGGER.warning("Could not find card : " + cardNo);
			return null;
		}
		return card;
	}

	@POST
	@Path("/create")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_FORM_URLENCODED })
	public void createCard(@FormParam("cardNo") String cardNo,
			@FormParam("name") String name, @FormParam("type") String type,
			@Context HttpServletResponse servletResponse) throws IOException {
		LOGGER.info("Inside create card");
		Card card = new Card(cardNo, name, type);
		cardDAO.createCard(card);
		servletResponse.sendRedirect("./");
	}

	@PUT
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_FORM_URLENCODED })
	public void updateCard(@FormParam("cardNo") String cardNo,
			@FormParam("name") String name, @FormParam("type") String type,
			@Context HttpServletResponse servletResponse) throws IOException {
		Card c = cardDAO.getCard(cardNo);
		if (c == null) {
			LOGGER.info("Could not find card " + cardNo);
		}
		LOGGER.info("Initiated Card update");
		Card card = new Card(cardNo, name, type);
		cardDAO.updateCard(card);
	}

	@DELETE
	@Path("/delete")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_FORM_URLENCODED })
	public void deleteCard(@FormParam("cardNo") String cardNo) {
		Card c = cardDAO.getCard(cardNo);
		if (c == null) {
			LOGGER.info("Could not find card " + cardNo);
		} else {
			cardDAO.deleteCard(cardNo);
			LOGGER.info("Card " + cardNo + " is deleted successfully");
		}
	}
}
