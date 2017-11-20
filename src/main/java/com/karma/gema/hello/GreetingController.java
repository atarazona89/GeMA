package com.karma.gema.hello;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karma.gema.service.CompanyService;
import com.karma.gema.service.UserService;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    UserService userservice;
    @Autowired
    CompanyService companyservice;
    
    

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/init")
    public List<Object> init(){
    	List<Object> ltObjects = new LinkedList<Object>();
    	System.out.println("------------------------ init ------------------------------");
    	ltObjects.addAll(companyservice.createCompany());
    	ltObjects.addAll(userservice.createUsers());    	
    	
    	return ltObjects;
    }
}