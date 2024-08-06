package com.academywebsite.service;

import com.academywebsite.documents.Admin;
import com.academywebsite.repository.AdminRepository;
import com.academywebsite.models.LoginRequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AdminRepository adminRepository;

    public Admin createAdmin(LoginRequestModel adminDetails) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Admin admin = modelMapper.map(adminDetails, Admin.class);
        admin.setEncryptedPassword(bCryptPasswordEncoder.encode(adminDetails.getPassword()));
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminDetailsByUsername(String username) {
        Admin admin = adminRepository.findByUsername(username);
        if(admin == null) throw new UsernameNotFoundException(username);

        //use modelmapper to hide some fields
        return admin;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username);
        if(admin == null) throw new UsernameNotFoundException(username);

        return new User(admin.getUsername(),admin.getEncryptedPassword(), true,true,true,true, new ArrayList<>());
    }
}
