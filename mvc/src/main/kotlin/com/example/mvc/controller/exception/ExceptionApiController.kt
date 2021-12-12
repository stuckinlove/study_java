package com.example.mvc.controller.exception

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException

@RestController
@RequestMapping("/api/exception")
class ExceptionApiController {

    @GetMapping("/hello")
    fun hello(){
        if(true){
            throw RuntimeException("exception !!")
        }
    }
}