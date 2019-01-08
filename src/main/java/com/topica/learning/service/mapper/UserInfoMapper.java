package com.topica.learning.service.mapper;

import com.topica.learning.domain.*;
import com.topica.learning.service.dto.UserInfoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity UserInfo and its DTO UserInfoDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface UserInfoMapper extends EntityMapper<UserInfoDTO, UserInfo> {

    @Mapping(source = "userinforls.id", target = "userinforlsId")
    @Mapping(source = "userinforls.login", target = "userinforlsLogin")
    UserInfoDTO toDto(UserInfo userInfo);

    @Mapping(source = "userinforlsId", target = "userinforls")
    UserInfo toEntity(UserInfoDTO userInfoDTO);

    default UserInfo fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        return userInfo;
    }
}
