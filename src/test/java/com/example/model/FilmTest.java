package com.example.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilmTest {
    private Film film;

    @Before
    public void setUp() throws Exception {
        film = new Film();
    }

    @Test
    public void getId() {
        long id = 4;
        film.setId(id);
        assertEquals(id, film.getId());
    }

    @Test
    public void getTitle() {
        String title = "example";
        film.setTitle(title);
        assertEquals(title, film.getTitle());
    }
}

