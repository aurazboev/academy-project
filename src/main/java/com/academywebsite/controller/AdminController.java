package com.academywebsite.controller;

import com.academywebsite.documents.Admin;
import com.academywebsite.models.LoginRequestModel;
import com.academywebsite.service.AdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Documentation of the Courses of the IT academy", tags = {"Admin"})
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping
    public Admin createAdmin(@RequestBody LoginRequestModel adminDetails){
        return adminService.createAdmin(adminDetails);
    }
}
