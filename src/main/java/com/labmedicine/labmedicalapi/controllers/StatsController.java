package com.labmedicine.labmedicalapi.controllers;

import com.labmedicine.labmedicalapi.dtos.StatsResponseDto;
import com.labmedicine.labmedicalapi.services.StatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {
    private final StatsService statsService;

    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public StatsResponseDto getStats() {
        return statsService.getStats();
    }
}
