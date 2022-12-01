package net.javaguides.springbootrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
@RestController
public class HelloWorldController {
    // HTTP method request
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
