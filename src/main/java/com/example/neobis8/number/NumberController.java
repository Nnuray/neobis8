package com.example.neobis8.number;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate-number")
@RequiredArgsConstructor
public class NumberController {
    private final NumberService numberService;
    @PostMapping
    public ResponseEntity<String>  validateNumber(
            @RequestBody NumberRequest request){
        return numberService.validate(request.number());
    }
}
