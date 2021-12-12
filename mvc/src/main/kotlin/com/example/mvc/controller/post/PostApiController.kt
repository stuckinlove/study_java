package com.example.mvc.controller.post

import com.example.mvc.controller.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostApiController {

    @PostMapping(path = ["/post-mapping"])
    fun postMappin(): String {
        return "post-mapping"
    }

    @RequestMapping(path = ["/post-request-mapping"], method = [RequestMethod.POST])
    fun requestMapping(): String {
        return "post-request-mapping";
    }

    @PostMapping("/post-mapping/object") // json -> obj
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest; // obj -> json
    }

}