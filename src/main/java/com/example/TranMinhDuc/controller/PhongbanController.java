package com.example.TranMinhDuc.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.TranMinhDuc.entity.phongban;
import com.example.TranMinhDuc.services.PhongbanService;

import java.util.List;

@Controller
@RequestMapping("/phongban")
public class PhongbanController {
    @Autowired
    private PhongbanService phongbanService;

    @GetMapping
    public String listPhongban(Model model) {
        List<phongban> category = phongbanService.getAllphongban();
        model.addAttribute("categories", category);
        model.addAttribute("title", "category List");
        return "category/list";
    }

    @GetMapping("/add")
    public String addPhongbanForm(Model model){
        model.addAttribute("phongban", new phongban());

        return "phongban/add";
    }
    @PostMapping("/add")
    public String addNhanvien(@Valid @ModelAttribute("phongban") phongban phongban, BindingResult result , Model model){
        if(result.hasErrors()){

            return "phongban/add";
        }
        phongbanService.addPhongban(phongban);
        return "redirect:/phongban";
    }

   /* @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("id") long id, Model model){
        Category editCategory = categoryService.getCategoryById(id);
        if(editCategory != null){
            model.addAttribute("category", editCategory);

            return "category/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editCategory( @Valid @ModelAttribute("category") Category updateCategory ,BindingResult result, Model model){
        if(result.hasErrors()){

            return "category/edit";
        }
        categoryService.getAllCategories().stream()
                .filter(category -> category.getId() == updateCategory.getId())
                .findFirst()
                .ifPresent(category -> {categoryService.updateCategory(updateCategory);});
        return "redirect:/category";
    }

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return "redirect:/category";
    }*/
}
