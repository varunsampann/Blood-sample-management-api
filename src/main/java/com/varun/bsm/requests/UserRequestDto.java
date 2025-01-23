package com.varun.bsm.requests;

import com.varun.bsm.enumes.BloodGroup;
import com.varun.bsm.enumes.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
public class UserRequestDto {
    @NotNull(message = "Username cannot be null.")
    @NotBlank(message = "Username cannot be blank.")
    @Pattern(regexp = "^[A-Za-z][A-Za-z0-9._]{2,19}$",
            message = "Username must start with a letter, can include letters, numbers, underscores (_), or periods (.), and be 3 to 20 characters long.")
    private String userName;

    @NotNull(message = "Password cannot be null.")
    @NotBlank(message = "Password cannot be blank.")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[$@#])[A-Za-z\\d@$#]{8,}$",
            message = "Password must contain at least 8 characters, including one uppercase letter, one lowercase letter, one number, and one special character ($, @, or #).")
    private String password;

    @NotNull(message = "Email cannot be null.")
    @NotBlank(message = "Email cannot be blank.")
    @Email(message = "Invalid email format.")
    private String email;

    @NotNull(message = "Phone number cannot be null.")
    @Pattern(regexp = "^[6-9]\\d{9}$",
            message = "Phone number must be a valid 10-digit Indian number starting with 6, 7, 8, or 9.")
    private String phoneNumber;

    @NotNull(message = "Blood group cannot be null.")
    private BloodGroup bloodGroup;

    @Min(value = 1, message = "Age must be at least 1.")
    @Max(value = 100, message = "Age must not exceed 100.")
    private int age;

    @NotNull(message = "Gender cannot be null.")
    private Gender gender;

    @NotNull(message = "City cannot be null.")
    @NotBlank(message = "City cannot be blank.")
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
