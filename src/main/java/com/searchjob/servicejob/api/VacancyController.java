package com.searchjob.servicejob.api;
//already can get requests and send responses
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/vacancies")
public class VacancyController {
    @GetMapping
    public ResponseEntity<Void> index() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> show(@PathVariable long id){
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Void> create(){
        return ResponseEntity.created(URI.create("")).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        return ResponseEntity.ok().build();
    }
}
