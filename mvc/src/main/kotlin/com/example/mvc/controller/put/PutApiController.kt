package com.example.mvc.controller.put

import com.example.mvc.controller.model.http.UserRequest
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest, bindingResult: BindingResult): ResponseEntity<String> {

        if (bindingResult.hasErrors()) {
            // 500 error
            val msg = StringBuilder()
            bindingResult.allErrors.forEach {
                val field = it as FieldError
                val message = it.defaultMessage
                msg.append(field.field + " : " + message + "\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }


//        // 0. list user
//        return UserResponse().apply {
//            // 1. result
//            this.result = Result().apply {
//                this.resultCode = "OK"
//                this.resultMessage = "success"
//            }
//        }.apply {
//            // 2. description
//            this.description = "this is description."
//
//        }.apply {
//            // 3. user mutable list
//            var userList = mutableListOf<UserRequest>()
//
//            userList.add(userRequest)
//
//            userList.add(UserRequest().apply {
//                this.name = "louis"
//                this.age = 10
//                this.address = "oosaka"
//                this.email = "kkk@kkk.com"
//                this.phoneNumber = "00099998888"
//            })
//
//            this.userRequest = userList
//        }
        return ResponseEntity.ok("")
    }
}