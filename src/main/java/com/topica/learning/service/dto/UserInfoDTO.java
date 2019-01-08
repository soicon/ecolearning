package com.topica.learning.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the UserInfo entity.
 */
public class UserInfoDTO implements Serializable {

    private Long id;

    private String phone;

    private String classLevel;

    private String school;

    private String location;

    private String gender;

    private LocalDate dateofbirth;

    private String device;

    private String deviceToken;

    private Long userinforlsId;

    private String userinforlsLogin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Long getUserinforlsId() {
        return userinforlsId;
    }

    public void setUserinforlsId(Long userId) {
        this.userinforlsId = userId;
    }

    public String getUserinforlsLogin() {
        return userinforlsLogin;
    }

    public void setUserinforlsLogin(String userLogin) {
        this.userinforlsLogin = userLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserInfoDTO userInfoDTO = (UserInfoDTO) o;
        if (userInfoDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userInfoDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
            "id=" + getId() +
            ", phone='" + getPhone() + "'" +
            ", classLevel='" + getClassLevel() + "'" +
            ", school='" + getSchool() + "'" +
            ", location='" + getLocation() + "'" +
            ", gender='" + getGender() + "'" +
            ", dateofbirth='" + getDateofbirth() + "'" +
            ", device='" + getDevice() + "'" +
            ", deviceToken='" + getDeviceToken() + "'" +
            ", userinforls=" + getUserinforlsId() +
            ", userinforls='" + getUserinforlsLogin() + "'" +
            "}";
    }
}
