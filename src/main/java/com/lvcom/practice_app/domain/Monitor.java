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
@Table(name="monitor")
public class Monitor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false,columnDefinition = "varchar(60)")
    private String createdBy;

    @Column(columnDefinition = "varchar(60)")
    private String updatedBy;

    @UpdateTimestamp
    private LocalDate updatedAt;

    @Column(nullable = false)
    private int length;

    @Column(nullable = false)
    private int height;

    @Column(nullable = false)
    private int width;

    @Column(nullable = false)
    private int displaySize;

    @ManyToOne(optional = false)
    private Workingplace workingplace;


}
