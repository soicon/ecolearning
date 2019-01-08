package com.topica.learning.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A Exercise.
 */
@Entity
@Table(name = "exercise")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Exercise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "created_time")
    private Instant createdTime;

    @Column(name = "exercise_type")
    private String exerciseType;

    @ManyToOne
    @JsonIgnoreProperties("")
    private User exerciseuser;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public Exercise fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Exercise imageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public Exercise createdTime(Instant createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public Exercise exerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
        return this;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public User getExerciseuser() {
        return exerciseuser;
    }

    public Exercise exerciseuser(User user) {
        this.exerciseuser = user;
        return this;
    }

    public void setExerciseuser(User user) {
        this.exerciseuser = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Exercise exercise = (Exercise) o;
        if (exercise.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), exercise.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Exercise{" +
            "id=" + getId() +
            ", fileName='" + getFileName() + "'" +
            ", imageUrl='" + getImageUrl() + "'" +
            ", createdTime='" + getCreatedTime() + "'" +
            ", exerciseType='" + getExerciseType() + "'" +
            "}";
    }
}
