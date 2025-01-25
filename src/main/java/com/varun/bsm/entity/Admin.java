package com.varun.bsm.entity;

import com.varun.bsm.enumes.AdminType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;
    private AdminType type;
//
    @OneToOne
    private User user;
@ManyToOne
    private Hospital hospital;

}
