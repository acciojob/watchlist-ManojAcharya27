package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;


    // meth 1, to add movie
    public  void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    // meth 2 , to add director;
    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }



    // meth 3 add director movie Pair

    public  void addMovieAndDirectorPair(String movie,String director){

        movieRepository.saveMovieDirectorPair(movie,director);
    }


    // meth 4 find movie Name
    public Movie  getMovieByName(String movie){
        return  movieRepository.findMovie(movie);
    }


   // meth 5 find  director name

    public Director getDirectorByName(String director){
        return  movieRepository.findDirector(director);
    }

    // meth 6 find list of movies directed buy director

    public List<String> getListOfMovie(String director){
        return movieRepository.findMovieFromDirector(director);
    }

    //  meth 7 find all movies
    public List<String> getAllMovie(){
        return movieRepository.findAllMovie();
    }


    // meth 8 delete a certain movie
    public void deleteMovie(String director){
        movieRepository.deleteDirectorByName(director);
    }


    // meth 9 delete all movie

    public void  deleteAllDirector(){
        movieRepository.deleteAllDirectors();
    }



}
