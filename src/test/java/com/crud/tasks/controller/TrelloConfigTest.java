package com.crud.tasks.controller;


import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloConfigTest {

    @Autowired
    private TrelloConfig trelloConfig;
    @Test
    void testTrelloConfig() {
        //Given
        //When
        String trelloApiEndpoint = trelloConfig.getTrelloApiEndpoint();

        //Then
        assertEquals("https://api.trello.com/1", trelloApiEndpoint);
    }
    @Test
    void testTrelloUsername() {
        //Given
        //When
        String trelloUsername = trelloConfig.getTrelloUsername();

        //Then
        assertEquals("rafsmo1992", trelloUsername);
    }
    @Test
    void testTrelloAppKey() {
        //Given
        //When
        String trelloAppKey = trelloConfig.getTrelloAppKey();

        //Then
        assertEquals("dd2c3239720827851d66b4ff766694a8", trelloAppKey);
    }
    @Test
    void testTrelloToken() {
        //Given
        //When
        String trelloToken = trelloConfig.getTrelloToken();

        //Then
        assertEquals("ATTAe91127ba536ad9b92bca14830932d6879047c4546196c576a8f6c65db95c17fb30BCD4C8", trelloToken);
    }
}

