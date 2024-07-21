package com.projectnetflix.netflix.Controller;

import com.projectnetflix.netflix.Model.Guser;
import com.projectnetflix.netflix.Service.GuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}
