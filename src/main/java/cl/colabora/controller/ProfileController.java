package cl.colabora.controller;


import cl.colabora.model.Profile;
import cl.colabora.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("profiles")
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfile();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @GetMapping("/profiles/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Profile profile = profileService.getProfileById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping("/profiles")
    public ResponseEntity<String> createProfile(@RequestBody Profile profile) {
        try {
            profileService.createProfile(profile);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Profile created", HttpStatus.CREATED);
    }

    @PatchMapping("profiles/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        Profile profileUpdate = profileService.updateProfile(profile);
        return new ResponseEntity<>(profileUpdate, HttpStatus.OK);

    }


    @DeleteMapping("profiles/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        try {
            profileService.deleteProfile(id);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Profile deleted", HttpStatus.OK);
    }

}
