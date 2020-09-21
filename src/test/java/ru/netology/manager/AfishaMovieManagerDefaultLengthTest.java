package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;


class AfishaMovieManagerDefaultLengthTest {

    private AfishaMovieManager manager = new AfishaMovieManager();

    private Movie first = new Movie(1, "firstUrl", "first", "action");
    private Movie second = new Movie(2, "secondUrl", "second", "cartoon");
    private Movie third = new Movie(3, "thirdUrl", "third", "comedy");
    private Movie fourth = new Movie(4, "fourthUrl", "fourth", "fantasy");
    private Movie fifth = new Movie(5, "fifthUrl", "fifth", "horrors");
    private Movie sixth = new Movie(6, "sixthUrl", "sixth", "fantastic");
    private Movie seventh = new Movie(7, "seventhUrl", "seventh", "historical");
    private Movie eighth = new Movie(8, "eighthUrl", "eighth", "thriller");
    private Movie ninth = new Movie(9, "ninthUrl", "ninth", "adventures");
    private Movie tenth = new Movie(10, "ninthUrl", "ninth", "biography");
    private Movie eleventh = new Movie(11, "eleventhUrl", "eleventh", "biography");
    private Movie twelve = new Movie(12, "twelveUrl", "twelve", "comedy");


    @BeforeEach
    public void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
    }

    @Test
    public void shouldAddLessThenTenMovies() {

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {ninth, eighth, seventh, sixth,
                fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddTenMovies() {

        manager.addMovie(tenth);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {tenth, ninth, eighth, seventh, sixth,
                fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMoreThenTenMovies() {

        manager.addMovie(tenth);
        manager.addMovie(eleventh);
        manager.addMovie(twelve);

        Movie[] actual = manager.getLastMovies();
        Movie[] expected = new Movie[] {twelve, eleventh, tenth, ninth, eighth, seventh, sixth,
                fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }
}