package com.lvcom.practice_app.domain;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Monitor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
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
    private WorkingPlace wPlaceId;




    public Monitor(Long id, LocalDate date, String createdBy, String updatedBy, LocalDate updatedAt, int length, int height, int width, int displaySize, WorkingPlace wPlaceId) {
        this.id = id;
        this.date = date;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
        this.length = length;
        this.height = height;
        this.width = width;
        this.displaySize = displaySize;
        this.wPlaceId = wPlaceId;
    }

    public Monitor() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String created_by) {
        this.createdBy = created_by;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updated_by) {
        this.updatedBy = updated_by;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updated_at) {
        this.updatedAt = updated_at;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(int display_size) {
        this.displaySize = display_size;
    }

    public WorkingPlace getWPlaceId() {
        return wPlaceId;
    }

    public void setWPlaceId(WorkingPlace w_place_id) {
        this.wPlaceId = w_place_id;
    }
}
