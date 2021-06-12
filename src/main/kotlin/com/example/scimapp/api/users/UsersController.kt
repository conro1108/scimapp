package com.example.scimapp.api.users

import com.example.scimapp.api.ResourceNotFoundException
import com.example.scimapp.persistence.ScimUser
import com.example.scimapp.services.UsersManager
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class UsersController(private val manager: UsersManager) {

    @GetMapping("/Users")
    fun getUsers(): List<ScimUser> {
        return manager.getUsers()
    }

    @GetMapping("/Users/{id}")
    fun getUser(@PathVariable id: UUID): ScimUser {
        return manager.getUser(id) ?: throw ResourceNotFoundException()
    }

    @PostMapping("/Users")
    fun createUser(@RequestBody dto: ScimUserDTO): ScimUser {
        return manager.addUser(dto)
    }
}