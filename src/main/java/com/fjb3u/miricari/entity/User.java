package com.fjb3u.miricari.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    private String userId;
    private String userName;
    private String address;
    private String tel;
}
