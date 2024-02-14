package com.joeproject.departmentService.service;

import com.joeproject.departmentService.dto.DepartmentDto;
import com.joeproject.departmentService.entity.Department;
import com.joeproject.departmentService.mapper.AutoMapper;
import com.joeproject.departmentService.repository.DepartmentRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepo departmentRepo;

    private ModelMapper modelMapper;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        // convert departmentdto to departmentEntity
//        Department department = new Department();
//        department.setId(departmentDto.getId());
//        department.setDepartmentName(departmentDto.getDepartmentName());
//        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
//        department.setDepartmentCode(departmentDto.getDepartmentCode());

//        USING MODELMAPPER
//        Department department = modelMapper.map(departmentDto, Department.class);

//        USING MAPSTRUCT
        Department department = AutoMapper.MAPPER.mapToDepartment(departmentDto);

        Department createDepartment = departmentRepo.save(department);
//        DepartmentDto createDepartmentDto1 = new DepartmentDto();
//        createDepartmentDto1.setId(createDepartment.getId());
//        createDepartmentDto1.setDepartmentName(createDepartment.getDepartmentName());
//        createDepartmentDto1.setDepartmentDescription(createDepartment.getDepartmentDescription());
//        createDepartmentDto1.setDepartmentCode(createDepartment.getDepartmentCode());

//        USING MODELMAPPER
//        DepartmentDto createDepartmentDto1 = modelMapper.map(createDepartment, DepartmentDto.class);

//        USING MAPSTRUCT
        DepartmentDto createDepartmentDto1 = AutoMapper.MAPPER.mapToDepartmentDto(createDepartment);

        return createDepartmentDto1;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepo.findByDepartmentCode(code);

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setDepartmentName(department.getDepartmentName());
        departmentDto.setDepartmentDescription(department.getDepartmentDescription());
        departmentDto.setDepartmentCode(department.getDepartmentCode());

        return departmentDto;
    }
}
