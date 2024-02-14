package com.joeproject.departmentService.controller;

import com.joeproject.departmentService.dto.DepartmentDto;
import com.joeproject.departmentService.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // Build save department REST API
    @PostMapping("create")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto createDepartmentDto = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(createDepartmentDto, HttpStatus.CREATED);
    }

    // Build Get Department REST API
    @GetMapping("getDepartmentByCode/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("code") String code) {
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
