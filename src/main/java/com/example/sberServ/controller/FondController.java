package com.example.sberServ.controller;

import com.example.sberServ.interfaces.FondService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/fond")
public class FondController {
    private final FondService fondService;

    public FondController(FondService fondService) {
        this.fondService = fondService;
    }
    @GetMapping("/money")
    public ResponseEntity<?> getMoney(){
        return new ResponseEntity<>(fondService.viewFond(), HttpStatus.OK);
    }
}
