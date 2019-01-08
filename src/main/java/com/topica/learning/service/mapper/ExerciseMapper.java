package com.topica.learning.service.mapper;

import com.topica.learning.domain.*;
import com.topica.learning.service.dto.ExerciseDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Exercise and its DTO ExerciseDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ExerciseMapper extends EntityMapper<ExerciseDTO, Exercise> {

    @Mapping(source = "exerciseuser.id", target = "exerciseuserId")
    @Mapping(source = "exerciseuser.login", target = "exerciseuserLogin")
    ExerciseDTO toDto(Exercise exercise);

    @Mapping(source = "exerciseuserId", target = "exerciseuser")
    Exercise toEntity(ExerciseDTO exerciseDTO);

    default Exercise fromId(Long id) {
        if (id == null) {
            return null;
        }
        Exercise exercise = new Exercise();
        exercise.setId(id);
        return exercise;
    }
}
