package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerZeroMoviesTest {

    private MovieManager manager = new MovieManager();

    @Test
    public void shouldHaveZeroMovies() {

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {};

        assertArrayEquals(expected, actual);
    }
}