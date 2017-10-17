package com.sergeeva.simpleSpringSecurityApp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long roleId;
    @Enumerated(EnumType.STRING)
    private Roles role;
}
