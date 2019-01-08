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
import io.github.jhipster.service.filter.LocalDateFilter;

/**
 * Criteria class for the UserInfo entity. This class is used in UserInfoResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /user-infos?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class UserInfoCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter phone;

    private StringFilter classLevel;

    private StringFilter school;

    private StringFilter location;

    private StringFilter gender;

    private LocalDateFilter dateofbirth;

    private StringFilter device;

    private StringFilter deviceToken;

    private LongFilter userinforlsId;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getPhone() {
        return phone;
    }

    public void setPhone(StringFilter phone) {
        this.phone = phone;
    }

    public StringFilter getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(StringFilter classLevel) {
        this.classLevel = classLevel;
    }

    public StringFilter getSchool() {
        return school;
    }

    public void setSchool(StringFilter school) {
        this.school = school;
    }

    public StringFilter getLocation() {
        return location;
    }

    public void setLocation(StringFilter location) {
        this.location = location;
    }

    public StringFilter getGender() {
        return gender;
    }

    public void setGender(StringFilter gender) {
        this.gender = gender;
    }

    public LocalDateFilter getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDateFilter dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public StringFilter getDevice() {
        return device;
    }

    public void setDevice(StringFilter device) {
        this.device = device;
    }

    public StringFilter getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(StringFilter deviceToken) {
        this.deviceToken = deviceToken;
    }

    public LongFilter getUserinforlsId() {
        return userinforlsId;
    }

    public void setUserinforlsId(LongFilter userinforlsId) {
        this.userinforlsId = userinforlsId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UserInfoCriteria that = (UserInfoCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(phone, that.phone) &&
            Objects.equals(classLevel, that.classLevel) &&
            Objects.equals(school, that.school) &&
            Objects.equals(location, that.location) &&
            Objects.equals(gender, that.gender) &&
            Objects.equals(dateofbirth, that.dateofbirth) &&
            Objects.equals(device, that.device) &&
            Objects.equals(deviceToken, that.deviceToken) &&
            Objects.equals(userinforlsId, that.userinforlsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        phone,
        classLevel,
        school,
        location,
        gender,
        dateofbirth,
        device,
        deviceToken,
        userinforlsId
        );
    }

    @Override
    public String toString() {
        return "UserInfoCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (phone != null ? "phone=" + phone + ", " : "") +
                (classLevel != null ? "classLevel=" + classLevel + ", " : "") +
                (school != null ? "school=" + school + ", " : "") +
                (location != null ? "location=" + location + ", " : "") +
                (gender != null ? "gender=" + gender + ", " : "") +
                (dateofbirth != null ? "dateofbirth=" + dateofbirth + ", " : "") +
                (device != null ? "device=" + device + ", " : "") +
                (deviceToken != null ? "deviceToken=" + deviceToken + ", " : "") +
                (userinforlsId != null ? "userinforlsId=" + userinforlsId + ", " : "") +
            "}";
    }

}
