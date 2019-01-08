package com.topica.learning.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A UserInfo.
 */
@Entity
@Table(name = "user_info")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "class_level")
    private String classLevel;

    @Column(name = "school")
    private String school;

    @Column(name = "location")
    private String location;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dateofbirth")
    private LocalDate dateofbirth;

    @Column(name = "device")
    private String device;

    @Column(name = "device_token")
    private String deviceToken;

    @OneToOne    @JoinColumn(unique = true)
    private User userinforls;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public UserInfo phone(String phone) {
        this.phone = phone;
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public UserInfo classLevel(String classLevel) {
        this.classLevel = classLevel;
        return this;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }

    public String getSchool() {
        return school;
    }

    public UserInfo school(String school) {
        this.school = school;
        return this;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getLocation() {
        return location;
    }

    public UserInfo location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public UserInfo gender(String gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public UserInfo dateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
        return this;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getDevice() {
        return device;
    }

    public UserInfo device(String device) {
        this.device = device;
        return this;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public UserInfo deviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
        return this;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public User getUserinforls() {
        return userinforls;
    }

    public UserInfo userinforls(User user) {
        this.userinforls = user;
        return this;
    }

    public void setUserinforls(User user) {
        this.userinforls = user;
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
        UserInfo userInfo = (UserInfo) o;
        if (userInfo.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userInfo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserInfo{" +
            "id=" + getId() +
            ", phone='" + getPhone() + "'" +
            ", classLevel='" + getClassLevel() + "'" +
            ", school='" + getSchool() + "'" +
            ", location='" + getLocation() + "'" +
            ", gender='" + getGender() + "'" +
            ", dateofbirth='" + getDateofbirth() + "'" +
            ", device='" + getDevice() + "'" +
            ", deviceToken='" + getDeviceToken() + "'" +
            "}";
    }
}
