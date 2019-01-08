package com.topica.learning.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.topica.learning.service.UserInfoService;
import com.topica.learning.web.rest.errors.BadRequestAlertException;
import com.topica.learning.web.rest.util.HeaderUtil;
import com.topica.learning.web.rest.util.PaginationUtil;
import com.topica.learning.service.dto.UserInfoDTO;
import com.topica.learning.service.dto.UserInfoCriteria;
import com.topica.learning.service.UserInfoQueryService;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing UserInfo.
 */
@RestController
@RequestMapping("/api")
public class UserInfoResource {

    private final Logger log = LoggerFactory.getLogger(UserInfoResource.class);

    private static final String ENTITY_NAME = "userInfo";

    private final UserInfoService userInfoService;

    private final UserInfoQueryService userInfoQueryService;

    public UserInfoResource(UserInfoService userInfoService, UserInfoQueryService userInfoQueryService) {
        this.userInfoService = userInfoService;
        this.userInfoQueryService = userInfoQueryService;
    }

    /**
     * POST  /user-infos : Create a new userInfo.
     *
     * @param userInfoDTO the userInfoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new userInfoDTO, or with status 400 (Bad Request) if the userInfo has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/user-infos")
    @Timed
    public ResponseEntity<UserInfoDTO> createUserInfo(@RequestBody UserInfoDTO userInfoDTO) throws URISyntaxException {
        log.debug("REST request to save UserInfo : {}", userInfoDTO);
        if (userInfoDTO.getId() != null) {
            throw new BadRequestAlertException("A new userInfo cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserInfoDTO result = userInfoService.save(userInfoDTO);
        return ResponseEntity.created(new URI("/api/user-infos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /user-infos : Updates an existing userInfo.
     *
     * @param userInfoDTO the userInfoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated userInfoDTO,
     * or with status 400 (Bad Request) if the userInfoDTO is not valid,
     * or with status 500 (Internal Server Error) if the userInfoDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/user-infos")
    @Timed
    public ResponseEntity<UserInfoDTO> updateUserInfo(@RequestBody UserInfoDTO userInfoDTO) throws URISyntaxException {
        log.debug("REST request to update UserInfo : {}", userInfoDTO);
        if (userInfoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserInfoDTO result = userInfoService.save(userInfoDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, userInfoDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /user-infos : get all the userInfos.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of userInfos in body
     */
    @GetMapping("/user-infos")
    @Timed
    public ResponseEntity<List<UserInfoDTO>> getAllUserInfos(UserInfoCriteria criteria, Pageable pageable) {
        log.debug("REST request to get UserInfos by criteria: {}", criteria);
        Page<UserInfoDTO> page = userInfoQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/user-infos");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /user-infos/count : count all the userInfos.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/user-infos/count")
    @Timed
    public ResponseEntity<Long> countUserInfos(UserInfoCriteria criteria) {
        log.debug("REST request to count UserInfos by criteria: {}", criteria);
        return ResponseEntity.ok().body(userInfoQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /user-infos/:id : get the "id" userInfo.
     *
     * @param id the id of the userInfoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the userInfoDTO, or with status 404 (Not Found)
     */
    @GetMapping("/user-infos/{id}")
    @Timed
    public ResponseEntity<UserInfoDTO> getUserInfo(@PathVariable Long id) {
        log.debug("REST request to get UserInfo : {}", id);
        Optional<UserInfoDTO> userInfoDTO = userInfoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userInfoDTO);
    }

    /**
     * DELETE  /user-infos/:id : delete the "id" userInfo.
     *
     * @param id the id of the userInfoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/user-infos/{id}")
    @Timed
    public ResponseEntity<Void> deleteUserInfo(@PathVariable Long id) {
        log.debug("REST request to delete UserInfo : {}", id);
        userInfoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
