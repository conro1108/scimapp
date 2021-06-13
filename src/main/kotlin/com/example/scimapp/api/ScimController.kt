package com.example.scimapp.api

import com.example.scimapp.ResourceNotFoundException
import com.example.scimapp.persistence.ScimGroup
import com.example.scimapp.persistence.ScimUser
import com.example.scimapp.services.ScimResourceManager
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ScimController(private val scimResourceManager: ScimResourceManager) {

    @GetMapping(URIPaths.USERS)
    fun getUsers(): List<ScimUser> {
        return scimResourceManager.getUsers()
    }

    @GetMapping(URIPaths.USERS_ID)
    fun getUser(@PathVariable id: UUID): ScimUser {
        return scimResourceManager.getUser(id) ?: throw ResourceNotFoundException()
    }

    @PostMapping(URIPaths.USERS)
    fun createUser(@RequestBody dto: ScimUserDTO): ScimUser {
        return scimResourceManager.addUser(dto)
    }

    @GetMapping(URIPaths.GROUPS)
    fun getGroups(): List<ScimGroup> {
        return scimResourceManager.getGroups()
    }

    @GetMapping(URIPaths.GROUPS_ID)
    fun getGroup(@PathVariable id: UUID): ScimGroup {
        return scimResourceManager.getGroup(id) ?: throw ResourceNotFoundException()
    }

    @PostMapping(URIPaths.GROUPS)
    fun createGroup(@RequestBody dto: ScimGroupDTO): ScimGroup {
        return scimResourceManager.addGroup(dto)
    }
}
