package com.topica.learning.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.topica.learning.domain.Exercise;
import com.topica.learning.domain.*; // for static metamodels
import com.topica.learning.repository.ExerciseRepository;
import com.topica.learning.service.dto.ExerciseCriteria;
import com.topica.learning.service.dto.ExerciseDTO;
import com.topica.learning.service.mapper.ExerciseMapper;

/**
 * Service for executing complex queries for Exercise entities in the database.
 * The main input is a {@link ExerciseCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ExerciseDTO} or a {@link Page} of {@link ExerciseDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ExerciseQueryService extends QueryService<Exercise> {

    private final Logger log = LoggerFactory.getLogger(ExerciseQueryService.class);

    private final ExerciseRepository exerciseRepository;

    private final ExerciseMapper exerciseMapper;

    public ExerciseQueryService(ExerciseRepository exerciseRepository, ExerciseMapper exerciseMapper) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseMapper = exerciseMapper;
    }

    /**
     * Return a {@link List} of {@link ExerciseDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ExerciseDTO> findByCriteria(ExerciseCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Exercise> specification = createSpecification(criteria);
        return exerciseMapper.toDto(exerciseRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link ExerciseDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<ExerciseDTO> findByCriteria(ExerciseCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Exercise> specification = createSpecification(criteria);
        return exerciseRepository.findAll(specification, page)
            .map(exerciseMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ExerciseCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Exercise> specification = createSpecification(criteria);
        return exerciseRepository.count(specification);
    }

    /**
     * Function to convert ExerciseCriteria to a {@link Specification}
     */
    private Specification<Exercise> createSpecification(ExerciseCriteria criteria) {
        Specification<Exercise> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), Exercise_.id));
            }
            if (criteria.getFileName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getFileName(), Exercise_.fileName));
            }
            if (criteria.getImageUrl() != null) {
                specification = specification.and(buildStringSpecification(criteria.getImageUrl(), Exercise_.imageUrl));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), Exercise_.createdTime));
            }
            if (criteria.getExerciseType() != null) {
                specification = specification.and(buildStringSpecification(criteria.getExerciseType(), Exercise_.exerciseType));
            }
            if (criteria.getExerciseuserId() != null) {
                specification = specification.and(buildSpecification(criteria.getExerciseuserId(),
                    root -> root.join(Exercise_.exerciseuser, JoinType.LEFT).get(User_.id)));
            }
        }
        return specification;
    }
}
