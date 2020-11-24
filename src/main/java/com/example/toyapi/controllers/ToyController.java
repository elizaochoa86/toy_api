package com.example.toyapi.controllers;

import com.example.toyapi.entities.Toy;
import com.example.toyapi.services.ToyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/toy/")
@RestController
public class ToyController {

    private ToyService toyService;

    public ToyController(ToyService toyService) {
        this.toyService = toyService;
    }

    @GetMapping
    public List<Toy> getAll(){
        return toyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Toy> getById(@PathVariable Integer id){
        Optional<Toy> toy = toyService.findById(id);
        if(toy.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(toy.get());
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Toy toy){
        toyService.save(toy);
        return ResponseEntity.status(HttpStatus.CREATED).body( "Toy succesfully created with id = " + toy.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Toy> update(@PathVariable Integer id, @RequestBody Toy toy){
        toyService.update(toy);

        Optional<Toy> newToy = toyService.findById(id);
        if(newToy.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(newToy.get());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Toy> parcialUpdate(@PathVariable Integer id, @RequestBody Toy toy){
        toyService.update(toy);

        Optional<Toy> newToy = toyService.findById(id);
        if(newToy.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(newToy.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        toyService.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).body( "Toy succesfully deleted with id = " + id);
    }
}
