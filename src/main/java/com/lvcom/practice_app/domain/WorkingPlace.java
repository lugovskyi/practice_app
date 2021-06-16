package com.lvcom.practice_app.domain;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class WorkingPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(columnDefinition = "varchar(255)")
    private String createdBy;

    @UpdateTimestamp
    private Date updatedAt;

    @Column(columnDefinition = "varchar(60)")
    private String updatedBy;

    @Column(columnDefinition = "varchar(60)")
    private String name;

    @Column(columnDefinition = "varchar(60)")
    private String city;

    @OneToMany(mappedBy = "workingPlace")
    private List<Monitor> monitor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_id", referencedColumnName = "id")
    private Pc pc;


    public WorkingPlace(Long id, LocalDate createdAt, String createdBy, Date updatedAt, String updatedBy, String name, String city, Pc pc) {
        this.id = id;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.name = name;
        this.city = city;
        this.pc = pc;
    }
    public WorkingPlace() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Pc getPc() {
        return pc;
    }

    public void setPc(Pc pc) {
        this.pc = pc;
    }
}
