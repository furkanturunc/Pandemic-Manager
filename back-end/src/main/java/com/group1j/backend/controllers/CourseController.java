package com.group1j.backend.controllers;

import com.group1j.backend.dto.CreateCourseDTO;
import com.group1j.backend.dto.CreateUserDTO;
import com.group1j.backend.dto.UserLoginDTO;
import com.group1j.backend.entities.*;
import com.group1j.backend.services.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/course")
public class CourseController {
    //Fields
    private CourseService courseService;

    //Constructor
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     *
     * @return
     */
    @GetMapping("/getAll")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @PostMapping("/add/student/{courseID}/{studentID}")
    public Course addStudent(@PathVariable int courseID, @PathVariable int studentID){
        return courseService.addStudent(courseID,studentID);
    }
    @PutMapping("/update/SeatingPlan/{seatingPlanID}/{courseID}")
    public Course updateSeatingPlan(@PathVariable int seatingPlanID, @PathVariable int courseID){
        return courseService.updateSeatingPlan(seatingPlanID, courseID);
    }

    @PostMapping("/create")
    public Course createCourse(@RequestBody CreateCourseDTO createCourseDTO){
        return courseService.createCourse(createCourseDTO);
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
