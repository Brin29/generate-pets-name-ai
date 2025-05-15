package brien.pets_name.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthController {

    @PostMapping()
    public String authenticationGetToken(@RequestBody )

}