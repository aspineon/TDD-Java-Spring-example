package com.application;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chlitsas, 30.04.17.
 */

@RestController
public class RestApi {
    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }
    
}
