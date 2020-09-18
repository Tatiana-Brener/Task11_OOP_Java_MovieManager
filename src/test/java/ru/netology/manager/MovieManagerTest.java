package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;


class MovieManagerTest {

    private MovieManager manager = new MovieManager();
    private Movie first = new Movie("firstId", "firstUrl",
            "first", "action");
    private Movie second = new Movie("secondId", "secondUrl", "second",
            "cartoon");
    private Movie third = new Movie("thirdId", "thirdUrl", "third",
            "comedy");
    private Movie fourth = new Movie("fourthId", "fourthUrl", "fourth",
            "fantasy");
    private Movie fifth = new Movie("fifthId", "fifthUrl", "fifth",
            "horrors");
    private Movie sixth = new Movie("sixthId", "sixthUrl", "sixth",
            "fantastic");
    private Movie seventh = new Movie("seventhId", "seventhUrl", "seventh",
            "historical");
    private Movie eighth = new Movie("eighthId", "eighthUrl", "eighth",
            "thriller");
    private Movie ninth = new Movie("ninthId", "ninthUrl", "ninth",
            "adventures");
    private Movie tenth = new Movie("ninthId", "ninthUrl", "ninth",
            "biography");
    private Movie eleventh = new Movie("eleventhId", "eleventhUrl", "eleventh",
            "biography");
    private Movie twelve = new Movie("twelveId", "twelveUrl", "twelve",
            "comedy");


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
        manager.addMovie(tenth);
        manager.addMovie(eleventh);
        manager.addMovie(twelve);
    }

    @Test
    public void shouldAddNewMovie() {
        Movie addedMovie = new Movie("addedMovieId","addedMovieUrl","addedMovie",
                "military");

        manager.addMovie(addedMovie);

        Movie[] actual = manager.getAllMovies();
        Movie[] expected = new Movie[] {addedMovie, twelve, eleventh, tenth, ninth, eighth, seventh, sixth,
                fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetAllMovies() {

        manager.getAllMovies();

        Movie[] actual = manager.getAllMovies();
        Movie[] expected = new Movie[] {twelve, eleventh, tenth, ninth, eighth, seventh, sixth,
                fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastTenAddedMovies() {

        manager.getLastAddedMovies(10);

        Movie[] actual = manager.getLastAddedMovies(10);
        Movie[] expected = new Movie[] {twelve, eleventh, tenth, ninth, eighth, seventh, sixth,
                fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetFiveLastAddedMovies() {

        manager.getLastAddedMovies(5);

        Movie[] actual = manager.getLastAddedMovies(5);
        Movie[] expected = new Movie[] {twelve, eleventh, tenth, ninth, eighth};

        assertArrayEquals(expected, actual);
    }
}