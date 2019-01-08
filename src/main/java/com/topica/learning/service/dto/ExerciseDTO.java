package com.topica.learning.service.dto;

import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Exercise entity.
 */
public class ExerciseDTO implements Serializable {

    private Long id;

    private String fileName;

    private String imageUrl;

    private Instant createdTime;

    private String exerciseType;

    private Long exerciseuserId;

    private String exerciseuserLogin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public Long getExerciseuserId() {
        return exerciseuserId;
    }

    public void setExerciseuserId(Long userId) {
        this.exerciseuserId = userId;
    }

    public String getExerciseuserLogin() {
        return exerciseuserLogin;
    }

    public void setExerciseuserLogin(String userLogin) {
        this.exerciseuserLogin = userLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ExerciseDTO exerciseDTO = (ExerciseDTO) o;
        if (exerciseDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), exerciseDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ExerciseDTO{" +
            "id=" + getId() +
            ", fileName='" + getFileName() + "'" +
            ", imageUrl='" + getImageUrl() + "'" +
            ", createdTime='" + getCreatedTime() + "'" +
            ", exerciseType='" + getExerciseType() + "'" +
            ", exerciseuser=" + getExerciseuserId() +
            ", exerciseuser='" + getExerciseuserLogin() + "'" +
            "}";
    }
}
