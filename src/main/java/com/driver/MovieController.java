package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.awt.*;
import java.util.ArrayList;


@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("new movie added successfully",HttpStatus.CREATED);
    }

    @PostMapping("/add_director")
    public  ResponseEntity<String> addDirector(@RequestBody()Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("new director added successfully",HttpStatus.CREATED);
    }
    @PutMapping("/add_movie_director_pair")
    public  ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("director") String director){
        movieService.addMovieAndDirectorPair(movie,director);
        return  new ResponseEntity<>("new movie and director added successfully",HttpStatus.CREATED);
    }

   @GetMapping("/get_movie_by_name/{name}")
    public ResponseEntity<Movie>  getMovieByName(@PathParam("name") String movie){
        Movie movie1=movieService.getMovieByName(movie);
        return  new ResponseEntity<>(movie1,HttpStatus.CREATED);
    }


     @GetMapping("/get_director_by_name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathParam("name") String director){
       Director dirName= movieService.getDirectorByName(director);
        return new ResponseEntity<>(dirName,HttpStatus.CREATED);
    }


  @GetMapping("/get_movies_by_director_name/{director}")
    public  ResponseEntity< java.util.List<String>>getMoviesByDirectorName(@PathParam("director")String directorName){
        java.util.List<String> listOfMovie=new ArrayList<>();
        listOfMovie=movieService.getListOfMovie(directorName);
        return  new ResponseEntity<>(listOfMovie,HttpStatus.CREATED);
    }

  @GetMapping("/get_all_movies")
  public ResponseEntity<java.util.List<String>> findAllMovies(){
        java.util.List<String> listAllOfMovie=new ArrayList<>();
        listAllOfMovie=movieService.getAllMovie();
        return new ResponseEntity<>(listAllOfMovie,HttpStatus.CREATED);
  }
@DeleteMapping("/delete_director_by_name")

public ResponseEntity<String>  deleteDirectorByName(@RequestParam("director") String directorName){
        movieService.deleteMovie(directorName);
        return new ResponseEntity<>("movie deleted successfully",HttpStatus.CREATED);

}

@DeleteMapping("/delete_all_directors")
public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirector();
        return new ResponseEntity<>("movie and director removed successfully",HttpStatus.CREATED);
}

}
