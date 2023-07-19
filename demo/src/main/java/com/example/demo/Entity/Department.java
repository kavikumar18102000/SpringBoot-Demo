package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id //--> annotating the private key for the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId; //always use lowercase to define the variable..
    private String deptName;
    private int deptCode;
}
