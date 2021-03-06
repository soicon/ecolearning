package com.topica.learning.service;

import com.topica.learning.service.dto.ExerciseDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Exercise.
 */
public interface ExerciseService {

    /**
     * Save a exercise.
     *
     * @param exerciseDTO the entity to save
     * @return the persisted entity
     */
    ExerciseDTO save(ExerciseDTO exerciseDTO);

    /**
     * Get all the exercises.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ExerciseDTO> findAll(Pageable pageable);


    /**
     * Get the "id" exercise.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ExerciseDTO> findOne(Long id);

    /**
     * Delete the "id" exercise.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
