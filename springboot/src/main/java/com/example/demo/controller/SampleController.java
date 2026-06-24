package com.example.demo.controller;

import com.example.demo.dto.SampleDto;
import com.example.demo.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    private final SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    // New endpoint for menu data
    @GetMapping("/menu")
    public List<SampleDto> getMenu() {
        List<SampleDto> menu = sampleService.getMenu();
        if (menu != null && !menu.isEmpty()) {
            logger.info("Fetched {} menu items, first item: {}", menu);
        } else {
            logger.warn("Menu fetch returned empty or null list");
        }
        return menu;
    }
}
