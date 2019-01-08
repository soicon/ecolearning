package com.topica.learning.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.InstantFilter;

/**
 * Criteria class for the Exercise entity. This class is used in ExerciseResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /exercises?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ExerciseCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter fileName;

    private StringFilter imageUrl;

    private InstantFilter createdTime;

    private StringFilter exerciseType;

    private LongFilter exerciseuserId;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getFileName() {
        return fileName;
    }

    public void setFileName(StringFilter fileName) {
        this.fileName = fileName;
    }

    public StringFilter getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(StringFilter imageUrl) {
        this.imageUrl = imageUrl;
    }

    public InstantFilter getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(InstantFilter createdTime) {
        this.createdTime = createdTime;
    }

    public StringFilter getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(StringFilter exerciseType) {
        this.exerciseType = exerciseType;
    }

    public LongFilter getExerciseuserId() {
        return exerciseuserId;
    }

    public void setExerciseuserId(LongFilter exerciseuserId) {
        this.exerciseuserId = exerciseuserId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ExerciseCriteria that = (ExerciseCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(fileName, that.fileName) &&
            Objects.equals(imageUrl, that.imageUrl) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(exerciseType, that.exerciseType) &&
            Objects.equals(exerciseuserId, that.exerciseuserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        fileName,
        imageUrl,
        createdTime,
        exerciseType,
        exerciseuserId
        );
    }

    @Override
    public String toString() {
        return "ExerciseCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (fileName != null ? "fileName=" + fileName + ", " : "") +
                (imageUrl != null ? "imageUrl=" + imageUrl + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
                (exerciseType != null ? "exerciseType=" + exerciseType + ", " : "") +
                (exerciseuserId != null ? "exerciseuserId=" + exerciseuserId + ", " : "") +
            "}";
    }

}
