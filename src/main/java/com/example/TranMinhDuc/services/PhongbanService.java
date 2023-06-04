package com.example.TranMinhDuc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TranMinhDuc.entity.phongban;
import com.example.TranMinhDuc.repository.IPhongbanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PhongbanService {
    @Autowired
    private IPhongbanRepository phongbanRepository;

    public List<phongban> getAllphongban(){ return phongbanRepository.findAll();}

    /*public phongban getPhongbanById(Long id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()){
            return optionalCategory.get();
        }else {
            throw new RuntimeException("Category Not Found");
        }
    }*/
    public phongban savePhongban(phongban phongban){return phongbanRepository.save(phongban);}

    /*public void deleteCategory(Long id){categoryRepository.deleteById(id);}*/

    public void addPhongban(phongban phongban)
    {
        phongbanRepository.save(phongban);
    }
   /* public void updateCategory(Category category){
        categoryRepository.save(category);
    }*/

}

