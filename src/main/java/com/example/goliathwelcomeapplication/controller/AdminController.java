package com.example.goliathwelcomeapplication.controller;

import com.example.goliathwelcomeapplication.requestmodels.AddCrewRequest;
import com.example.goliathwelcomeapplication.service.AdminService;
import com.example.goliathwelcomeapplication.utils.JWTextractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/secure/add/crew")
    public void postCrew(@RequestHeader(value="Authorization") String token,
                         @RequestBody AddCrewRequest addCrewRequest) throws Exception {
        String admin = JWTextractor.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }
        adminService.postCrew(addCrewRequest);
    }

    @DeleteMapping("/secure/delete/crew")
    public void deleteCrew(@RequestHeader(value="Authorization") String token,
                           @RequestParam Long crewId) throws Exception {
        String admin = JWTextractor.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }
        adminService.deleteCrew(crewId);
    }

}