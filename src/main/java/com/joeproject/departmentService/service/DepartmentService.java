package com.joeproject.departmentService.service;

import com.joeproject.departmentService.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
