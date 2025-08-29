package com.sch.springboot.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Employee {

    @Id
    private int sno;

    private String name;
    private String department;
    private String address;

    @Column(name = "edate", nullable = true)
    private LocalDate edate;

    @PrePersist
    public void prePersist() {
        if (this.edate == null) {
            this.edate = LocalDate.now();
        }
    }

    public LocalDate getEdate() {
        return edate;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
