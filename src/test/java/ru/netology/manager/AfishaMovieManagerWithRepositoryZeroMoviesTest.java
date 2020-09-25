package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaMovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class AfishaMovieManagerWithRepositoryZeroMoviesTest {

    @Mock
    private AfishaMovieRepository movieRepository;

    @InjectMocks
    private AfishaMovieManagerWithRepository managerWithRepository = new AfishaMovieManagerWithRepository(movieRepository, 0);

    @Test
    public void shouldHaveZeroMovies() {
        Movie[] returned = new Movie[] {};

        doReturn(returned).when(movieRepository).findAll();

        Movie[] expected = new Movie[] {};
        Movie[] actual = managerWithRepository.getLastMovies();

        assertArrayEquals(expected, actual);
    }

}