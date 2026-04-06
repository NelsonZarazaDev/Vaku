package com.vaku.core_server.department.domain.model;

import com.vaku.core_server.department.infraestructure.outbound.entity.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Department {
    private Long id;
    private String name;

    public Department(DepartmentEntity departmentEntity) {
        this.id = departmentEntity.getId();
        this.name = departmentEntity.getName();
    }
}
