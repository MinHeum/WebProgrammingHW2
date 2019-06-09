package com.n2015542042.main.controller;

import com.n2015542042.main.domain.Basic;
import com.n2015542042.main.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/basics")
public class BasicController {
    @Autowired
    BasicService basicService;

    @PostMapping
    public ResponseEntity<?> postBasic(@RequestBody Basic basic) {
        basicService.makeNewBasic(basic);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @PutMapping("/{idx}")
    public ResponseEntity<?> putBasic(@PathVariable("idx")Long idx, @RequestBody Basic basic) {
        Basic persistBasic = basicService.findByIdxBasic(idx);
        persistBasic.update(basic);
        basicService.makeNewBasic(persistBasic);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @PostMapping(value = "/basic/create")
    public String createBasic(Basic basic, Model model) {
        Basic newBasic = basicService.makeNewBasic(basic);
        model.addAttribute("basic", basicService.findByIdxBasic(newBasic.getIdx()));
        Long index = newBasic.getIdx();
        return "basic/{index}";
    }

    @DeleteMapping(value = "/{idx}")
    public ResponseEntity<?> deleteBasic(@PathVariable("idx")Long idx) {
        basicService.deleteByIdxBasic(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
