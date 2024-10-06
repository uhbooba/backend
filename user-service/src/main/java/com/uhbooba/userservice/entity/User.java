package com.uhbooba.userservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 15)
    private String name;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false, length = 15)
    private String phone;

    @Column(nullable = false)
    private Boolean isTwoFactorAuthEnabled;

    @Column(nullable = false)
    private Boolean isFirstLogin;

    @Column(nullable = false)
    private Integer missionStatus;

    @Builder
    public User(String name, String username, String password, String phone) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.isTwoFactorAuthEnabled = false;
        this.isFirstLogin = true;
        this.missionStatus = 0;
    }

    public User(String username, String name) {
        this.username = username;
        this.name = name;
    }

    public void setMissionCleared(int missionNumber) {
        missionStatus |= (1 << missionNumber);
    }

    public boolean isMissionCleared(int missionNumber) {
        return (missionStatus & (1 << missionNumber)) != 0;
    }

    public int getClearedMissionCount() {
        int count = 0;
        int status = missionStatus;
        while (status != 0) {
            count += (status & 1);
            status >>= 1;
        }
        return count;
    }

}
