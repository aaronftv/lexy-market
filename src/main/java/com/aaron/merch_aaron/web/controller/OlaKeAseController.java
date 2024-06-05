package com.aaron.merch_aaron.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/olaKeAcer")
public class OlaKeAseController {

    @GetMapping("/ola")
    public String olaKeAcer() {
        return "Never stop learning! 🚀🚀💥";
    }

}
