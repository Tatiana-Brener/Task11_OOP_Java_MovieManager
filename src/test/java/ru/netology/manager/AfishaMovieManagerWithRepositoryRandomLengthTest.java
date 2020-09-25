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
class AfishaMovieManagerWithRepositoryRandomLengthTest {

    @Mock
   private AfishaMovieRepository movieRepository;

    @InjectMocks
    private AfishaMovieManagerWithRepository managerWithRepository = new AfishaMovieManagerWithRepository(movieRepository, 5);

    private Movie first = new Movie(1, "firstUrl", "first", "action");
    private Movie second = new Movie(2, "secondUrl", "second", "cartoon");
    private Movie third = new Movie(3, "thirdUrl", "third", "comedy");
    private Movie fourth = new Movie(4, "fourthUrl", "fourth", "fantasy");
    private Movie fifth = new Movie(5, "fifthUrl", "fifth", "horrors");
    private Movie sixth = new Movie(6, "sixthUrl", "sixth", "fantastic");

    @Test
    public void shouldRemoveMovieById() {
        int idToRemove = 2;
        Movie[] returned = new Movie[] {first, third, fourth, fifth, sixth};

        doReturn(returned).when(movieRepository).findAll();
        doNothing().when(movieRepository).removeById(idToRemove);

        managerWithRepository.removeById(idToRemove);

        Movie[] expected = new Movie[] {sixth, fifth, fourth, third, first};
        Movie[] actual = managerWithRepository.getLastMovies();

        assertArrayEquals(expected, actual);

        verify(movieRepository).removeById(idToRemove);
    }

    @Test
    public void shouldAddLessThenLengthAfisha() {
        Movie[] returned = new Movie[] {first, second, third, fourth};

        doReturn(returned).when(movieRepository).findAll();

        Movie[] expected = new Movie[] {fourth, third, second, first};
        Movie[] actual = managerWithRepository.getLastMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddEqualLengthAfisha() {
        Movie[] returned = new Movie[] {first, second, third, fourth, fifth};

        doReturn(returned).when(movieRepository).findAll();

        Movie[] expected = new Movie[] {fifth, fourth, third, second, first};
        Movie[] actual = managerWithRepository.getLastMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    public  void shouldAddMoreThenLengthAfisha() {
        Movie[] returned = new Movie[] {first, second, third, fourth, fifth, sixth};

        doReturn(returned).when(movieRepository).findAll();

        Movie[] expected = new Movie[] {sixth, fifth, fourth, third, second};
        Movie[] actual = managerWithRepository.getLastMovies();

        assertArrayEquals(expected, actual);
    }
}