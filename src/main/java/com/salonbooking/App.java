package com.salonbooking;

import com.salonbooking.domain.Customer;
import com.salonbooking.domain.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
@RestController
@EnableAutoConfiguration
public class App
{
    @RequestMapping("/")
    String home()
    {
        return "Hello Ernst!";
    }

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}

