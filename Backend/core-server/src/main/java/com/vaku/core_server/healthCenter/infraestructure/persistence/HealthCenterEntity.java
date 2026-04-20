package com.vaku.core_server.healthCenter.infraestructure.persistence;

import com.vaku.core_server.city.infraestructure.persistence.CityEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "health_center")
public class HealthCenterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private Boolean status;
    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    private OffsetDateTime updateAt;
    private OffsetDateTime deleteAt;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;
}

//https://medium.com/@ksaquib/exception-handling-in-spring-boot-a-comprehensive-guide-2491b43a841b