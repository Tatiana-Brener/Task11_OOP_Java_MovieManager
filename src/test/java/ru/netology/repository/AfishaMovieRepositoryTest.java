package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaMovieRepositoryTest {

    private AfishaMovieRepository movieRepository = new AfishaMovieRepository();

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
        movieRepository.saveMovie(first);
        movieRepository.saveMovie(second);
        movieRepository.saveMovie(third);
        movieRepository.saveMovie(fourth);
        movieRepository.saveMovie(fifth);
        movieRepository.saveMovie(sixth);
        movieRepository.saveMovie(seventh);
        movieRepository.saveMovie(eighth);
        movieRepository.saveMovie(ninth);
    }

    @Test
    public void shouldSaveAllMovies() {

        Movie[] actual = movieRepository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh,
                eighth,ninth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveAllMoviesWithAdded() {
        movieRepository.saveMovie(tenth);

        Movie[] actual = movieRepository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth, sixth, seventh,
                eighth,ninth, tenth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMovieByIdIfExists() {

        Movie[] actual = movieRepository.findById(8);
        Movie[] expected = new Movie[] {eighth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMovieByIdIfNotExists() {

        Movie[] actual = movieRepository.findById(12);
        Movie[] expected = new Movie[] {null};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveMovieByIdIfExists() {

        movieRepository.removeById(2);

        Movie[] actual = movieRepository.findAll();
        Movie[] expected = new Movie[] {first, third, fourth, fifth, sixth, seventh,
                eighth,ninth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveMovieByIdIfNotExists() {

        movieRepository.removeById(10);

        Movie[] actual = movieRepository.findAll();
        Movie[] expected = new Movie[] {first,second, third, fourth, fifth, sixth, seventh,
                eighth,ninth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllMovies() {

        Movie[] actual = movieRepository.removeAll();
        Movie[] expected = new Movie[] {};

        assertArrayEquals(expected, actual);
    }
}