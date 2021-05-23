package com.example.Simple1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SimpleController {
    @GetMapping("/simple_random")
    public String getSimple()   {
        Random random = new Random();
        int number = random.nextInt(999);
        System.out.println(number);
        return String.format("<h2>%d</h2>",number);

    }
    @GetMapping("/simple_multiply/{a}/{b}")

    public String simple_multiply(@PathVariable("a") int a, @PathVariable("b") int b) {
        return String.format("<h2>%d*%d = %d,!</h2>", a,b,a*b);

    }


    

@GetMapping ("/greet/{name}")
public String helloName(@PathVariable("name") String name)
        {

        return String.format("<h2>Hello %s!</h2>", name);
        }













        }
