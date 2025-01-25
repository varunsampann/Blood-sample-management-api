package com.varun.bsm.entity;

import com.varun.bsm.enumes.AdminType;
import com.varun.bsm.enumes.BloodGroup;
import com.varun.bsm.enumes.Gender;
import com.varun.bsm.enumes.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private BloodGroup bloodGroup;
    private LocalDate lastDonateAt;
    private int age;
    private Gender gender;
    private String availableCity;
    private boolean verified;
    private LocalDate createdAt;
    private LocalDate lastModifiedAt;
    private UserRole userRole;
    private AdminType adminType;


    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    private Admin admin;

//    public UserRole getUserRole() {
//        return userRole;
//    }
//
//    public void setUserRole(UserRole userRole) {
//        this.userRole = userRole;
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
//    public BloodGroup getBloodGroup() {
//        return bloodGroup;
//    }
//
//    public void setBloodGroup(BloodGroup bloodGroup) {
//        this.bloodGroup = bloodGroup;
//    }
//
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
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
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
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
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
//    public boolean isVerified() {
//        return verified;
//    }
//
//    public void setVerified(boolean verified) {
//        this.verified = verified;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//
//    public LocalDate getLastModifiedAt() {
//        return lastModifiedAt;
//    }
//
//    public void setLastModifiedAt(LocalDate lastModifiedAt) {
//        this.lastModifiedAt = lastModifiedAt;
//    }
//
//    public LocalDate getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDate createdAt) {
//        this.createdAt = createdAt;
//    }
}
