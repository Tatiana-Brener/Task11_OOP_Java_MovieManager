package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaMovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AfishaMovieManagerWithRepositoryTest {

    @Mock
    private AfishaMovieRepository movieRepository;

    @InjectMocks
    private AfishaMovieManagerWithRepository movieManagerWithRepository;

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

    @Test
    public void shouldRemoveMovieById() {
        int idToRemove = 5;
        Movie[] returned = new Movie[]{first, second, third, fourth, sixth, seventh, eighth, ninth};

        doReturn(returned).when(movieRepository).findAll();
        doNothing().when(movieRepository).removeById(idToRemove);

        movieManagerWithRepository.removeById(idToRemove);
        Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fourth, third, second, first};
        Movie[] actual = movieManagerWithRepository.getLastMovies();

        assertArrayEquals(expected, actual);

        verify(movieRepository).removeById(idToRemove);
    }

    @Test
    public void shouldGetLessThenTenMovies() {
        Movie[] returned = new Movie[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};

        doReturn(returned).when(movieRepository).findAll();

        Movie[] expected = new Movie[] {ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = movieManagerWithRepository.getLastMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetTenMovies() {
        Movie[] returned = new  Movie[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};

        doReturn(returned).when(movieRepository).findAll();

        Movie[] expected = new Movie[] {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = movieManagerWithRepository.getLastMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMoreThenTenMovies() {

        Movie[] returned = new  Movie[] {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth,
                eleventh, twelve};

        doReturn(returned).when(movieRepository).findAll();

        Movie[] expected = new Movie[]{twelve, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        Movie[] actual = movieManagerWithRepository.getLastMovies();

        assertArrayEquals(expected, actual);
    }

}
