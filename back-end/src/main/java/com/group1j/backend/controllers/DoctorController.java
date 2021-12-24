package com.group1j.backend.controllers;

import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.services.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/doctor")
public class DoctorController {
    //Fields
    private DoctorService doctorService;

    //Constructor
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    /**
     *
     * @return
     */
    @GetMapping("/getAll")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @PutMapping("/update/Schedule{doctorID}/{scheduleID}")
    public Doctor updateSchedule(@PathVariable int doctorID, @PathVariable int scheduleID){
        return doctorService.updateSchedule(doctorID, scheduleID);
    }

    @PostMapping("/create")
    public Doctor createDoctor(@RequestBody CreateUserDTO createUserDTO){
        return doctorService.createDoctor(createUserDTO);
    }

    @GetMapping("/login")
    public boolean loginDoctor(@RequestBody UserLoginDTO userLoginDTO){
        return doctorService.loginDoctor(userLoginDTO);
    }

    public DoctorService getDoctorService() {
        return doctorService;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
