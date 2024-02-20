package cl.colabora.controller;


import cl.colabora.model.Profile;
import cl.colabora.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity <List<Profile>> getAllProfiles(){
        List<Profile> profiles = profileService.getAllProfile();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
}
