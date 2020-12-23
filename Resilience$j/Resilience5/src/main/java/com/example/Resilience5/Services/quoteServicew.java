package com.example.Resilience5.Services;

import org.springframework.web.client.RestTemplate;

public class quoteServicew {

    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuote(){
        System.out.println("inside  calling method");
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("http://localhost:8081/test/greetint",Integer.class);
    }
    //should be same like lambda functtion that works...minor diff is it can have a throwable in parameters
    public int getQuoteFallback(Throwable t){
        System.out.println("inside fallback calling method");
        return 99;
    }
}
