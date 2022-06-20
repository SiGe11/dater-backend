package eu.sige.daterbackend.controller;

import eu.sige.daterbackend.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    final DogService dogService;

    @Autowired
    public WebController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping(value = "dogs", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*") // TODO Fix this
    public ResponseEntity<String> getDogs() {
        String dogApiResponse = dogService.getDogApi();
        return new ResponseEntity<>(dogApiResponse, HttpStatus.OK);
    }
}
