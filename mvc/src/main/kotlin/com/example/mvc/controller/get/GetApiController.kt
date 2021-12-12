package com.example.mvc.controller.get

import com.example.mvc.controller.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController {

    @GetMapping(path = ["/hello", "/abcd"])
    fun hello(): String {
        return "hello kotlin"
    }

    @RequestMapping(path = ["/request-mapping"], method = [RequestMethod.GET])
    fun requestMappin(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") age: Int): String {
        val name = "kotlin"

        println("${_name}, ${age}")
        return _name + "_" + age
    }

    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam name: String,
        @RequestParam(value = "age") age: Int
    ): String {
        println("${name} ${age}")
        return name + "_" + age
    }

    // name, age, address, email
    @GetMapping("/get-mapping/queryt-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map:Map<String, Any>): Map<String, Any> {
        println(map)
        return map
    }
}