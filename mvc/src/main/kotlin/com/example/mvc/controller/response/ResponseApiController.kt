package com.example.mvc.controller.response

import com.example.mvc.controller.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    @GetMapping("")
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {
        // age == null -> 400 error
        // age < 20 -> 400 error
        println(age)

//        if (age==null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age is null")
//        }
//
//        if(age < 20){
//            return ResponseEntity.status(H ttpStatus.BAD_REQUEST).body("over 20")
//        }

        return age?.let {
            if (it < 20) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("under 20")
            }
            ResponseEntity.ok("ok");

        } ?: kotlin.run {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("null")
        }

    }

    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        return ResponseEntity.status(200).body(userRequest)
    }

}