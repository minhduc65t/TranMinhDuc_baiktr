package com.example.TranMinhDuc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.TranMinhDuc.entity.phongban;
@Repository
public interface IPhongbanRepository extends JpaRepository<phongban, String> {
}
