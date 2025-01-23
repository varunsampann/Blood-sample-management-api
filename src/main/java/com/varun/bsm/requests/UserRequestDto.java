package com.varun.bsm.requests;

import com.varun.bsm.enumes.BloodGroup;
import com.varun.bsm.enumes.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class UserRequestDto {
     @NotNull
     @NotBlank
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private BloodGroup bloodGroup;
    private int age;
    private Gender gender;
    private String availableCity;

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
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
//    public BloodGroup getBloodGroup() {
//        return bloodGroup;
//    }
//
//    public void setBloodGroup(BloodGroup bloodGroup) {
//        this.bloodGroup = bloodGroup;
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
//    public Gender getGender() {
//        return gender;
//    }
//
//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }
//
//    public String getAvailableCity() {
//        return availableCity;
//    }
//
//    public void setAvailableCity(String availableCity) {
//        this.availableCity = availableCity;
//    }
}
