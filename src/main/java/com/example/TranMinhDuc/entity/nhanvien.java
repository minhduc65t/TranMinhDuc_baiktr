package com.example.TranMinhDuc.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table(name ="nhanvien")
public class nhanvien {
    @Id
    @Column(name =  "manv")
    private String manv;


    @Column(name = "tennv")
    @NotEmpty(message = "Tennv must not be empty")
    private String tennv;

    @Column(name = "phai")
    @NotEmpty(message = "phao must not be empty")
    private String phai;



    @Column(name = "noisinh")
    @NotEmpty(message = "noisinh must not be empty")
    private String noisinh;

    @Column (name = "luong")
    @NotNull(message = "luong is required")
    private  Double luong;



    @ManyToOne
    @JoinColumn(name = "phongban_id")
    private phongban phongban;


}
