package com.varun.bsm.responses;

import com.varun.bsm.enumes.AdminType;
import com.varun.bsm.enumes.BloodGroup;
import com.varun.bsm.enumes.Gender;
import com.varun.bsm.enumes.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private int userId;
    private String userName;
    private String availableCity;
    private int age;
    private Gender gender;
    private BloodGroup bloodGroup;
    private LocalDate lastDonateAt;
    private  boolean verified;
    private LocalDate createdAt;
    private LocalDate lastModifiedAt;
    private UserRole userRole;
    private AdminType type;

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getAvailableCity() {
//        return availableCity;
//    }
//
//    public void setAvailableCity(String availableCity) {
//        this.availableCity = availableCity;
//    }
//
//    public Gender getGender() {
//        return gender;
//    }
//
//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public BloodGroup getBloodGroup() {
//        return bloodGroup;
//    }
//
//    public void setBloodGroup(BloodGroup bloodGroup) {
//        this.bloodGroup = bloodGroup;
//    }
//
//    public LocalDate getLastDonateAt() {
//        return lastDonateAt;
//    }
//
//    public void setLastDonateAt(LocalDate lastDonateAt) {
//        this.lastDonateAt = lastDonateAt;
//    }
//
//    public boolean isVerified() {
//        return verified;
//    }
//
//    public void setVerified(boolean verified) {
//        this.verified = verified;
//    }
//
//    public LocalDate getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDate createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDate getLastModifiedAt() {
//        return lastModifiedAt;
//    }
//
//    public void setLastModifiedAt(LocalDate lastModifiedAt) {
//        this.lastModifiedAt = lastModifiedAt;
//    }
}
