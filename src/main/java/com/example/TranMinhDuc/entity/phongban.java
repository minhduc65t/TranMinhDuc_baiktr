package com.example.TranMinhDuc.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "phongban")
public class phongban {

    @Id
    @Column(name = "maphong")
    @NotEmpty(message = " maphong ko the trong")
    private String maphong;

    @Column(name = "tenphong")
    @NotEmpty(message = " tenphong ko the trong")
    private String tenphong;




    @OneToMany(mappedBy = "phongban",cascade = CascadeType.ALL)
    private List<nhanvien> nhanviens;

}
