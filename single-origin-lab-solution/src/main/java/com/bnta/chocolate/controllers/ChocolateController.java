package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chocolates") // localhost:8080/chocolates
public class ChocolateController {

    @Autowired
    ChocolateRepository chocolateRepository;

    // GET
    @GetMapping //localhost:8080/chocolates
    public ResponseEntity<List<Chocolate>> getAllChocolates(){
        return new ResponseEntity<>(chocolateRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping(value = "/{id}") // localhost:8080/chocolates/1
    public ResponseEntity<Optional<Chocolate>> getChocolate(@PathVariable Long id){
        return new ResponseEntity<>(chocolateRepository.findById(id), HttpStatus.OK);
    }

    // POST
    @PostMapping // POST localhost:8080/chocolates
    public ResponseEntity<Chocolate> createChocolate (@RequestBody Chocolate newChocolate){
        chocolateRepository.save(newChocolate);
        return new ResponseEntity<>(newChocolate, HttpStatus.CREATED);
    }

//    @GetMapping //localhost:8080/pets?type=dog
//    public ResponseEntity<List<Chocolate>> getAllChocolatesOfPercentage(
//            @RequestParam(name= "type") String type){
//        return new ResponseEntity<>(chocolateRepository.findPetByType(type), HttpStatus.OK);
//    }
}
