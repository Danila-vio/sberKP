package com.example.sberServ.controller;

import com.example.sberServ.interfaces.PersonService;
import com.example.sberServ.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/manager")
public class PersonController {
    public final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllClients(){
        return new ResponseEntity<>(personService.allClients(),HttpStatus.OK);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<?> getOneClients(@PathVariable("id") Integer id){
        return new ResponseEntity<>(personService.oneClientById(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewClient(@RequestBody Person person){
        personService.createClient(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateClient(@RequestBody Person person){
        personService.updateClient(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Integer id){
        personService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
