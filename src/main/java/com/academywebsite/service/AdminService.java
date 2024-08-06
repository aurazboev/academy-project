package com.academywebsite.service;

import com.academywebsite.documents.Admin;
import com.academywebsite.models.LoginRequestModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AdminService extends UserDetailsService {
    Admin createAdmin(LoginRequestModel adminDetails);
    Admin getAdminDetailsByUsername(String username);
}
