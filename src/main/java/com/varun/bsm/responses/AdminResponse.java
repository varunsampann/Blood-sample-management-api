package com.varun.bsm.responses;

import com.varun.bsm.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {

    private int adminId;
    private int hospitalId;
    private int userId;
    private User user;

}
