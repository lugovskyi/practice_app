package com.lvcom.practice_app.domain;

import com.sun.source.doctree.SeeTree;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdAt;
    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String createdBy;

    @UpdateTimestamp
    private LocalDate updatedAt;
    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String updatedBy;

    @Column(nullable = false)
    private int length;
    @Column(nullable = false)
    private int heigth;
    @Column(nullable = false)
    private int width;
    @Column(nullable = false)
    private int ramSize;
    @Column(nullable = false)
    private int cpuCount;

    @OneToOne(mappedBy = "pc")
    private WorkingPlace workingPlace;



    public Pc(Long id, LocalDate createdAt, String createdBy, LocalDate updatedAt, String updatedBy, int length, int heigth, int width, int ramSize, int cpuCount, WorkingPlace workingPlace) {
        this.id = id;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.length = length;
        this.heigth = heigth;
        this.width = width;
        this.ramSize = ramSize;
        this.cpuCount = cpuCount;
        this.workingPlace = workingPlace;
    }

    public Pc() {

    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getCpuCount() {
        return cpuCount;
    }

    public void setCpuCount(int cpuCount) {
        this.cpuCount = cpuCount;
    }

    public WorkingPlace getW_place_id() {
        return workingPlace;
    }

    public void setW_place_id(WorkingPlace w_place_id) {
        this.workingPlace = workingPlace;
    }
}
