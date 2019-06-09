package com.n2015542042.main.controller;

import com.n2015542042.main.domain.Profile;
import com.n2015542042.main.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/api/profiles")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @PostMapping
    public ResponseEntity<?> postBoard(@RequestBody Profile profile) {
        profile.setCreatedat(LocalDateTime.now());
        profileService.makeNewProfile(profile);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @PutMapping("/{idx}")
    public ResponseEntity<?> putBoard(@PathVariable("idx")Long idx, @RequestBody Profile profile) {
        Profile persistProfile = profileService.findByIdxProfile(idx);
        persistProfile.update(profile);
        profileService.makeNewProfile(persistProfile);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @PostMapping(value = "/profile/create")
    public String createBasic(Profile profile, Model model) {
        Profile newProfile = profileService.makeNewProfile(profile);
        newProfile.setCreatedat(LocalDateTime.now());
        model.addAttribute("basic", profileService.findByIdxProfile(newProfile.getIdx()));
        Long index = newProfile.getIdx();
        return "profile/{index}";
    }

    @DeleteMapping(value = "/{idx}")
    public ResponseEntity<?> deleteProfile(@PathVariable("idx")Long idx) {
        profileService.deleteByIdxProfile(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
