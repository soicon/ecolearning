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

import com.topica.learning.domain.UserInfo;
import com.topica.learning.domain.*; // for static metamodels
import com.topica.learning.repository.UserInfoRepository;
import com.topica.learning.service.dto.UserInfoCriteria;
import com.topica.learning.service.dto.UserInfoDTO;
import com.topica.learning.service.mapper.UserInfoMapper;

/**
 * Service for executing complex queries for UserInfo entities in the database.
 * The main input is a {@link UserInfoCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link UserInfoDTO} or a {@link Page} of {@link UserInfoDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class UserInfoQueryService extends QueryService<UserInfo> {

    private final Logger log = LoggerFactory.getLogger(UserInfoQueryService.class);

    private final UserInfoRepository userInfoRepository;

    private final UserInfoMapper userInfoMapper;

    public UserInfoQueryService(UserInfoRepository userInfoRepository, UserInfoMapper userInfoMapper) {
        this.userInfoRepository = userInfoRepository;
        this.userInfoMapper = userInfoMapper;
    }

    /**
     * Return a {@link List} of {@link UserInfoDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<UserInfoDTO> findByCriteria(UserInfoCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<UserInfo> specification = createSpecification(criteria);
        return userInfoMapper.toDto(userInfoRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link UserInfoDTO} which matches the criteria from the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<UserInfoDTO> findByCriteria(UserInfoCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<UserInfo> specification = createSpecification(criteria);
        return userInfoRepository.findAll(specification, page)
            .map(userInfoMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(UserInfoCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<UserInfo> specification = createSpecification(criteria);
        return userInfoRepository.count(specification);
    }

    /**
     * Function to convert UserInfoCriteria to a {@link Specification}
     */
    private Specification<UserInfo> createSpecification(UserInfoCriteria criteria) {
        Specification<UserInfo> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildSpecification(criteria.getId(), UserInfo_.id));
            }
            if (criteria.getPhone() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPhone(), UserInfo_.phone));
            }
            if (criteria.getClassLevel() != null) {
                specification = specification.and(buildStringSpecification(criteria.getClassLevel(), UserInfo_.classLevel));
            }
            if (criteria.getSchool() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSchool(), UserInfo_.school));
            }
            if (criteria.getLocation() != null) {
                specification = specification.and(buildStringSpecification(criteria.getLocation(), UserInfo_.location));
            }
            if (criteria.getGender() != null) {
                specification = specification.and(buildStringSpecification(criteria.getGender(), UserInfo_.gender));
            }
            if (criteria.getDateofbirth() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDateofbirth(), UserInfo_.dateofbirth));
            }
            if (criteria.getDevice() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDevice(), UserInfo_.device));
            }
            if (criteria.getDeviceToken() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDeviceToken(), UserInfo_.deviceToken));
            }
            if (criteria.getUserinforlsId() != null) {
                specification = specification.and(buildSpecification(criteria.getUserinforlsId(),
                    root -> root.join(UserInfo_.userinforls, JoinType.LEFT).get(User_.id)));
            }
        }
        return specification;
    }
}
