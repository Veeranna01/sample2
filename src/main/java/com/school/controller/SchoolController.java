package com.school.controller;

import com.school.dto.SchoolDto;
import com.school.entity.SchoolEntity;
import com.school.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class SchoolController {

    private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public ResponseEntity<SchoolDto> addStudent(@RequestBody SchoolDto dto) {
        SchoolDto akhil = schoolService.addStudent(dto);
        return new ResponseEntity<>(akhil, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SchoolEntity>> getStudents() {

        List<SchoolEntity> e = schoolService.getStudents();
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<SchoolEntity> getStudentById(@RequestParam Long id) {
        SchoolEntity e = schoolService.getStudentById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolDto> updateStudent(@RequestBody SchoolDto dto,@PathVariable long id) {
        SchoolDto dto1 = schoolService.updataStudent(dto,id);
        return new ResponseEntity<>(dto1, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
      schoolService.deleteStudent(id);
        return new ResponseEntity<>("Record is deleted",HttpStatus.OK);
    }
}
