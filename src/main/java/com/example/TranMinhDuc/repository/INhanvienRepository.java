package com.example.TranMinhDuc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.TranMinhDuc.entity.nhanvien;
@Repository
public interface INhanvienRepository extends JpaRepository<nhanvien, String> {
}
