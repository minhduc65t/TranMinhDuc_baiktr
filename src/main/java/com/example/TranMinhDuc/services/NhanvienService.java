package com.example.TranMinhDuc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TranMinhDuc.entity.nhanvien;
import com.example.TranMinhDuc.repository.INhanvienRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NhanvienService {
    @Autowired
    private INhanvienRepository NhanvienRepository;

    public List<nhanvien> getAllnhanvien()
    {
        return NhanvienRepository.findAll();
    }
    public nhanvien getnhanvienById(String id){
        Optional<nhanvien> optional = NhanvienRepository.findById(id);
        return  optional.orElse(null);
    }
    public void addnhanvien(nhanvien nhanvien)
    {
        NhanvienRepository.save(nhanvien);
    }
    public void updatenhanvien(nhanvien nhanvien){
        NhanvienRepository.save(nhanvien);
    }
    public void deletenhanvien(String id){
        NhanvienRepository.deleteById(id);
    }
}
