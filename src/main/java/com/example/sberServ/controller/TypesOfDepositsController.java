package com.example.sberServ.controller;

import com.example.sberServ.interfaces.TypesOfDepositsService;
import com.example.sberServ.model.TypesOfDeposits;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/types")
public class TypesOfDepositsController {
    private final TypesOfDepositsService typesOfDepositsService;

    public TypesOfDepositsController(TypesOfDepositsService typesOfDepositsService) {
        this.typesOfDepositsService = typesOfDepositsService;
    }
   @GetMapping("/all")
   public ResponseEntity<?> allTypes(){
        return new ResponseEntity<>(typesOfDepositsService.getAllTypes(), HttpStatus.OK);
   }
   @PostMapping("/add")
    public ResponseEntity<?> addType(@RequestBody TypesOfDeposits types){
        typesOfDepositsService.addNewType(types);
        return new ResponseEntity<>(HttpStatus.CREATED);
   }
}
