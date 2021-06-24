package com.lvcom.practice_app.domain;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "workingplace")
public class Workingplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false, columnDefinition = "varchar(60)")
    private String createdBy;

    @UpdateTimestamp
    private Date updatedAt;

    @Column(columnDefinition = "varchar(60)")
    private String updatedBy;

    @Column(nullable = false, columnDefinition = "varchar(60)")
    private String name;

    @Column(nullable = false, columnDefinition = "varchar(60)")
    private String city;

    @OneToMany(mappedBy = "workingplace")
    private List<Monitor> monitor;

    @OneToOne(mappedBy = "workingplace")
    private Pc pc;
}
