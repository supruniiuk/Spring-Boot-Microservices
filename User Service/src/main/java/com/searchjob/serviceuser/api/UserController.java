package com.searchjob.serviceuser.api;

import com.searchjob.serviceuser.repository.model.User;
import com.searchjob.serviceuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public final class UserController {

    private  final UserService userService;

    @GetMapping
    public ResponseEntity<List<com.searchjob.serviceuser.repository.model.User>> index (){
        final List<com.searchjob.serviceuser.repository.model.User> users =  userService.fetchAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.searchjob.serviceuser.repository.model.User> show(@PathVariable long id){
        try{
            final User user = userService.fetchById(id);
            return ResponseEntity.ok(user);
        } catch(IllegalArgumentException error) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.searchjob.serviceuser.api.dto.User user){
        final String firstname = user.getFirstname();
        final String lastname = user.getLastname();
        final String email = user.getEmail();
        final long id = userService.create(firstname, lastname, email);

        final String location = String.format("/users/%d", id);

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody com.searchjob.serviceuser.api.dto.User user){
        final String firstname = user.getFirstname();
        final String lastname = user.getLastname();
        final String email = user.getEmail();
        try{
            userService.update(id, firstname, lastname, email);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException error){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
