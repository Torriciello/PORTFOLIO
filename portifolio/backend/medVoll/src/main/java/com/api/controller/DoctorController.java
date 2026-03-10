package com.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RequestMapping("/doctor")
@RestController
@SecurityRequirement(name = "bearer-key")
public class DoctorController {
}