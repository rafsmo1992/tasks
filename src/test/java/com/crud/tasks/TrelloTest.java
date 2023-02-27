package com.crud.tasks;

import com.crud.tasks.domain.TrelloDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrelloTest {

    @Test
    void trelloTest() {
        //Given
        TrelloDto trello = new TrelloDto();

        //When
        trello.setBoard(1);
        trello.setCard(2);
        int board = trello.getBoard();
        int card = trello.getCard();

        //Then
        assertEquals(1, board);
        assertEquals(2, card);
    }
}