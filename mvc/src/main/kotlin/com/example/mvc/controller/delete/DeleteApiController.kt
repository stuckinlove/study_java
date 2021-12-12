package com.example.mvc.controller.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/api")
@Validated
class DeleteApiController {

    // 1. path variable
    // 2. request param

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam(value = "name") _name: String,

        @NotNull(message = " age is null")
        @Min(20, message = "need under 20")
        @RequestParam(value = "age") _age: Int
    ): String {
        println(_name)
        println(_age)
        return _name + "_" +_age
    }

    @DeleteMapping(path = ["delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @PathVariable _name: String,
        @PathVariable _age: Int
    ): String {
        return _name + "_" + _age;
    }

}