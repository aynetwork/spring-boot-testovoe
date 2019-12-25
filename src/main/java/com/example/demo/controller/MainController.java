package com.example.demo.controller;

import com.example.demo.domain.PurchaseInfo;
import com.example.demo.service.PurchaseInfoService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    private PurchaseInfoService purchaseInfoService;

    @Value("${spring.profiles.active:prod}")
    private String profile;

    @Autowired
    public MainController(PurchaseInfoService purchaseInfoService) {
        this.purchaseInfoService = purchaseInfoService;
    }


    @GetMapping("/")
    public String main(Model model){
        List<PurchaseInfo> purchases = purchaseInfoService.findAll();
        model.addAttribute("isDevMode", profile);
        return "main";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") PurchaseInfo purchaseInfo, Model model){
        model.addAttribute("purchase", purchaseInfo);
        return "edit";
    }


    @PostMapping("/edit/{id}")
    @ResponseBody
    public String update(
            @PathVariable("id") PurchaseInfo purchaseFromDb,
            @Valid PurchaseInfo purchaseInfo,
            BindingResult bindingResult,
            Model model
    ){

        if (bindingResult.hasErrors()) {
            model.addAttribute("purchase", purchaseFromDb);
            model.addAttribute("purchaseError", "Check values! Some of them are wrong!");
            return "edit";
        }

        purchaseInfoService.save(purchaseInfo, purchaseFromDb.getId());

        return "redirect:/";
    }


    @DeleteMapping("{id}")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved User"),
    })
    public void delete(@PathVariable("id") PurchaseInfo purchaseInfo) {
        purchaseInfoService.delete(purchaseInfo);
    }

   @GetMapping("/login")
    public String login(){
        return "login";
    }


}
