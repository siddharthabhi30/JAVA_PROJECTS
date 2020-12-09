package com.example.loggin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Logger logger= LoggerFactory.getLogger(Controller.class);

    @RequestMapping("/")
    public String greet(){
        //it will not get printed , as log level is on info
        //we say in app.properties file to log trace as well

        int n=23;
        logger.info("error happened");
        logger.debug("debug msgs is there {}fffff{}",n,n+1);


        return  "heeeelo";
    }
}
