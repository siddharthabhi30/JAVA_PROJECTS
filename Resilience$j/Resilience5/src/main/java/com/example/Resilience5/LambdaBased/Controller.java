package com.example.Resilience5.LambdaBased;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("check")
public class Controller {

    @RequestMapping(value = "getGreeted")
    public String checkCircuitBReaker(){
        return Resilience.test1();
    }

}
