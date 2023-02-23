package com.driver;

import com.sun.source.tree.BreakTree;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MovieRepository {
    private HashMap<String,Movie> movieMap;
    private HashMap<String,Director> directorMap;
    private HashMap<String, List<String>> directorMovieMap;
   // Map<> directorMoviePai=new HashMap();
    public MovieRepository(){
        movieMap=new HashMap<>();
        directorMap=new HashMap<>();
        directorMovieMap=new HashMap<>();
    }

    // method to add movie to db

    public void addMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
    }  // 1


    // method to add director db

    public void saveDirector(Director director){ // 2
        directorMap.put(director.getName(),director);
    }


    // method to add movie director pair db

    public  void saveMovieDirectorPair(String movie,String director){ // 3
        if(movieMap.containsKey(movie)&&directorMap.containsKey(director)) {
            movieMap.put(movie,movieMap.get(movie));
            directorMap.put(director,directorMap.get(director));
            List<String> currMovie = new ArrayList<>();
            if (directorMovieMap.containsKey(director)) currMovie = directorMovieMap.get(director);
            currMovie.add(movie);
            directorMovieMap.put(director, currMovie);
        }

    }


    // method find movie

    public Movie findMovie(String movie){ // 4
        return movieMap.get(movie);
    }


    // method to find director

    public  Director findDirector(String director){
        return directorMap.get(director);
    } // 5



    // method to find movie list according to director

    public List<String> findMovieFromDirector(String director){ // 6
        List<String> movieList=new ArrayList<>();
        if(directorMovieMap.containsKey(director)) movieList=directorMovieMap.get(director);
        return movieList;
    }

    // method to find all the movie name

    public List<String> findAllMovie(){return new ArrayList<>(movieMap.keySet());} //7


    // method to remove movie and director

    public  void deleteDirectorByName(String director){ //8
        if(directorMovieMap.containsKey(director)){
            directorMovieMap.remove(director);
        }
    }

    // method to delete all the director and their movies..
    public  void deleteAllDirectors(){ //9;
        for(String x: directorMap.keySet()){
            if(directorMovieMap.containsKey(x)){
                directorMovieMap.remove(x);
            }
        }
    }
    
}
