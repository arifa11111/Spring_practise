package com.Thymeleaf.thymeleaf.Entity;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.List;
@Entity
@Data
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    //@NotBlank
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private  String lastName;
   // @NotBlank(message = "must contain values")
    @Column(name = "username",nullable = false, unique = true)
   // @Email
    private String email;

    @Column(name = "mobile_no",nullable = false, unique = true)
   // @Range(max = 10, min = 10, message = "Mobile number should be of 10 digits")
   // @Pattern(regexp = "[7-9][0-9]{9}", message = "Mobile number is invalid!!")
    private long phnNo;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

}


