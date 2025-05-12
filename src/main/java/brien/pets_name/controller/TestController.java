package brien.pets_name.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAcces(){
        return "Public Content";
    }

    @GetMapping("/user")
    public String userAccess(){
        return "User Content";
    }
}