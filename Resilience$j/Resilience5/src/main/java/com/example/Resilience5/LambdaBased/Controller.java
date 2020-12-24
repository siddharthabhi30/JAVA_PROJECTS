package com.example.Resilience5.LambdaBased;

import com.example.Resilience5.CircuitBreaker.Breaker1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("check")
public class Controller {

    @Autowired
    public Breaker1 breaker1;

    @RequestMapping(value = "getGreeted")
    public String checkCircuitBReaker(){
        return Resilience.test1();
    }

    @GetMapping("/single2")
    public void failure6(){
        breaker1.test=23;

    }



}
