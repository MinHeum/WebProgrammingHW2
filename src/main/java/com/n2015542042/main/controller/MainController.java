package com.n2015542042.main.controller;

import com.n2015542042.main.service.BasicService;
import com.n2015542042.main.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    BasicService basicService;

    @Autowired
    ProfileService profileService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("basicList", basicService.findAllBasic());
        model.addAttribute("profileList", profileService.findAllProfile());
        return "index";
    }

    @GetMapping(value = "/basic/{idx}")
    public String viewBasic(@PathVariable("idx") Long idx, Model model) {
        model.addAttribute("basic", basicService.findByIdxBasic(idx));
        return "board/basic/form";
    }

    @GetMapping(value = "/profile/{idx}")
    public String viewProfile(@PathVariable("idx") Long idx, Model model) {
        model.addAttribute("profile", profileService.findByIdxProfile(idx));
        return "board/profile/form";
    }

    @GetMapping(value = "/basic/new")
    public String newBasic(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) {
        model.addAttribute("basic", basicService.findByIdxBasic(idx));
        return "board/basic/form";
    }

    @GetMapping(value = "/profile/new")
    public String newProfile(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) {
        model.addAttribute("profile", profileService.findByIdxProfile(idx));
        return "board/profile/form";
    }
}
