package com.binh.blog.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
//Đánh dấu lớp thực thể
@Entity
@AllArgsConstructor
@Getter
@Setter
public class User {
    //Khóa
    @Id
    //Thiết lập mã tự động tăng
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> roles;
    public User(String userName,String password,List<Role> roles){
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }
} 
