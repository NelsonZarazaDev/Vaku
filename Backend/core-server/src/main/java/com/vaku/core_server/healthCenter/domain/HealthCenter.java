package com.vaku.core_server.healthCenter.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class HealthCenter {
    private UUID id;
    private String name;
    private boolean status;


    public void activate() {
        if (this.status) {
            throw new IllegalStateException("El health center ya esta activo");
        }
        this.status = true;
    }

    public void deactivate(){
        if (!this.status){
            throw new IllegalStateException("El health center ya esta inactivo");
        }
        this.status = false;
    }

    public void updateName(String name){
        if (name==null || name.isBlank()){
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.name = name.trim();
    }

}

