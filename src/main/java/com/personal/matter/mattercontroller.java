package com.personal.matter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
public class mattercontroller {
    private static final Matter[] matters = {
            new Matter(1L, "Legal Matter"),
            new Matter(2L, "IP Matter")
    };
    @GetMapping("/matters")
    public Matter[] matters() {
        return matters;
    }
    @GetMapping("/matters/{id}")
    public Matter book(@PathVariable int id) {
        for (Matter matter : matters) {
            if (matter.getId() == id) {
                return matter;
            }

        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Matter not found"
        );
    }
}
