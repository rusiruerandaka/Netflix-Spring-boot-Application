package com.projectnetflix.netflix.Controller;


import com.projectnetflix.netflix.Model.Admin;
import com.projectnetflix.netflix.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
        return new ResponseEntity<Admin>(adminService.addAdmin(admin), HttpStatus.CREATED);

    }

    @GetMapping("/Admin/{id}")
    public Admin findById(@PathVariable long id){
        return adminService.getadminById(id);

    }

    @PutMapping("/updateAdmin/{id}")
    public ResponseEntity<?> updateAdmin(@PathVariable long id, @RequestBody Admin admin){

        Admin updateAdmin = adminService.updateAdmin(id,admin);
        return ResponseEntity.ok(updateAdmin);


    }

    @DeleteMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable long id){
        return adminService.deleteAdmin(id);
    }

}
