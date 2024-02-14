package com.joeproject.departmentService.repository;

import com.joeproject.departmentService.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String code);
}
