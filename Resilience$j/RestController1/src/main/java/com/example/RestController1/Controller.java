package com.example.RestController1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Controller {


    @RequestMapping("/greet")
    public String greet(){


        return "hello";
    }
    @RequestMapping("/greetint")
    public int greetInt(){


        return 11;
    }


    @RequestMapping("/greet2")

    public String greet2(){
        return "hello22";
    }

}
