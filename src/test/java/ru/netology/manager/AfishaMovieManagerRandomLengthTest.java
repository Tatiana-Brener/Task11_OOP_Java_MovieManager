package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaMovieManagerRandomLengthTest {

    private AfishaMovieManager manager = new AfishaMovieManager(5);

    private Movie first = new Movie(1, "firstUrl", "first", "action");
    private Movie second = new Movie(2, "secondUrl", "second", "cartoon");
    private Movie third = new Movie(3, "thirdUrl", "third", "comedy");
    private Movie fourth = new Movie(4, "fourthUrl", "fourth", "fantasy");
    private Movie fifth = new Movie(5, "fifthUrl", "fifth", "horrors");
    private Movie sixth = new Movie(6, "sixthUrl", "sixth", "fantastic");

    @BeforeEach
    public void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
    }

    @Test
    public void shouldAddLessThenLengthAfisha() {

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddEqualLengthAfisha() {
        manager.addMovie(fifth);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMoreThenLengthAfisha() {
        manager.addMovie(fifth);
        manager.addMovie(sixth);

        Movie[] expected = manager.getLastMovies();
        Movie[] actual = new Movie[] {sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }



}