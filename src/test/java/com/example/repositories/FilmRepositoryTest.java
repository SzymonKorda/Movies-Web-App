package com.example.repositories;

import com.example.model.Film;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FilmRepositoryTest {

    @Autowired
    FilmRepository filmRepository;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByTitle() throws Exception {

        Optional<Film> filmOptional = filmRepository.findByTitle("Forrest Gump");

        assertEquals("Forrest Gump", filmOptional.get().getTitle());
    }

    @Test
    public void findById() throws Exception {

        Optional<Film> filmOptional = filmRepository.findById(1L);

        assertEquals(1, filmOptional.get().getId());
    }
}

