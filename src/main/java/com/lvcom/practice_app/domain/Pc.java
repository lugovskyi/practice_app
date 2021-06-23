package com.lvcom.practice_app.domain;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="pc")
public class Pc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false, columnDefinition = "varchar(60)")
    private String createdBy;

    @UpdateTimestamp
    private LocalDate updatedAt;

    @Column(columnDefinition = "varchar(60)")
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workingplace_id", referencedColumnName = "id")
    private Workingplace workingplace;
}
