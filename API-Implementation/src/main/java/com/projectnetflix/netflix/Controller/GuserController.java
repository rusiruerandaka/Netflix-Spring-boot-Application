package com.projectnetflix.netflix.Controller;

import com.projectnetflix.netflix.Dto.Guserdto;
import com.projectnetflix.netflix.Model.Guser;
import com.projectnetflix.netflix.Service.GuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuserController {

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
