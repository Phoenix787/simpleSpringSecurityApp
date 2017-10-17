package com.sergeeva.simpleSpringSecurityApp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;




@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;
    private int active;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name = "user_id" ), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Users(Users user) {
        this.active=user.getActive();
        this.name = user.getName();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.id = user.id;
    }
}
