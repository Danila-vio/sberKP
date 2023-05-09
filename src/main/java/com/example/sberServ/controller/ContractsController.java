package com.example.sberServ.controller;

import com.example.sberServ.interfaces.ContractsService;
import com.example.sberServ.model.Contracts;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/contracts")
public class ContractsController {
    private final ContractsService contractsService;

    public ContractsController(ContractsService contractsService) {
        this.contractsService = contractsService;
    }
    @GetMapping("/allcontr")
    public ResponseEntity<List<Contracts>> allAccounts() {
        return new ResponseEntity<>(contractsService.getAllContracts(), HttpStatus.OK);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> getAllById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(contractsService.allContractsByPersonId(id), HttpStatus.OK);
    }
}
