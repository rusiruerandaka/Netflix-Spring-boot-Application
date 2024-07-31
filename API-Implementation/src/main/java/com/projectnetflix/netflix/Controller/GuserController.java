package com.projectnetflix.netflix.Controller;

import com.projectnetflix.netflix.Model.AuthUser;
import com.projectnetflix.netflix.Model.Guser;
import com.projectnetflix.netflix.Repository.AuthGuserRepo;
import com.projectnetflix.netflix.Service.GuserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class GuserController {

    private final AuthGuserRepo authGuserRepo;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody AuthUser user){
        try {
            if (authGuserRepo.findByGusername(user.getUsername()).isPresent())
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already taken. Please try again");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            AuthUser save = authGuserRepo.save(user);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }




    @Autowired
    private GuserService guserService;

    @PostMapping("/addguser")
    public ResponseEntity<Guser> addGuser(@RequestBody Guser guser){
        return new ResponseEntity<Guser>(guserService.addGuser(guser), HttpStatus.CREATED);

    }

    @GetMapping("/getguser")
    public List<Guser> getGuser(){

        return guserService.getGuser();
    }

    @GetMapping("/user/{id}")
    public Guser findById(@PathVariable long id){

        return guserService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGuser(@PathVariable long id, @RequestBody Guser nguser){

            Guser updateGuser = guserService.updateGuser(id,nguser);
            return ResponseEntity.ok(updateGuser);


    }

    @DeleteMapping("/delete/{id}")
    public String deleteGuser(@PathVariable long id){
        return guserService.deleteGuser(id);
    }


}
