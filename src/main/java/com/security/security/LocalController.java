package com.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class LocalController {

    @Autowired
    LocalRepository localRepository;

    @GetMapping("/local/{id}")
    public ResponseEntity<Local> getLocal(@PathVariable("id") Long id) {

        Optional<Local> optional = localRepository.findById(id);

        if (optional.isPresent()) {
            Local local = optional.get();
            return ResponseEntity.ok(local);
        }

        return new ResponseEntity<Local>(HttpStatus.NOT_FOUND);
    }


}
