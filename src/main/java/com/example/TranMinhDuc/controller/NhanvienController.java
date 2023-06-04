package com.example.TranMinhDuc.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.TranMinhDuc.entity.nhanvien;
import com.example.TranMinhDuc.services.NhanvienService;
import com.example.TranMinhDuc.services.PhongbanService;

import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanvienController {

    @Autowired
    private NhanvienService nhanvienService;

    @Autowired
    private PhongbanService phongbanService;

    @GetMapping
    public String listNhanvien(Model model) {
        List<nhanvien> nhanviens = nhanvienService.getAllnhanvien();
        model.addAttribute("nhanviens", nhanviens);
        model.addAttribute("title", "Nhanvien List");
        return "nhanvien/list";
    }
    @GetMapping("/add")
        public String addNhanvienForm(Model model){
        model.addAttribute("nhanvien", new nhanvien());
        model.addAttribute("phongbans",phongbanService.getAllphongban());
        return "nhanvien/add";
        }
      @PostMapping("/add")
      public String addNhanvien(@Valid  @ModelAttribute("book") nhanvien nhanvien, BindingResult result ,Model model){
        if(result.hasErrors()){
            model.addAttribute("phongbans",phongbanService.getAllphongban());
            return "nhanvien/add";
        }
        nhanvienService.addnhanvien(nhanvien);
        return "redirect:/nhanviens";
        }
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") String id, Model model){
        nhanvien editNhanVien = nhanvienService.getnhanvienById(id);
        if(editNhanVien != null){
            model.addAttribute("nhanvien", editNhanVien);
            model.addAttribute("listPhongBan", phongbanService.getAllphongban());
            return "nhanvien/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editNhanvien(@Valid @ModelAttribute("nhanvien")nhanvien updateNhanVien, BindingResult bindingResult, Model model ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("listPhongBan", phongbanService.getAllphongban());
            return "nhanvien/edit";
        }
        nhanvienService.updatenhanvien(updateNhanVien);
        return "redirect:/nhanviens";
    }
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id){
        nhanvienService.deletenhanvien(id);
        return "redirect:/nhanviens";
    }




}
