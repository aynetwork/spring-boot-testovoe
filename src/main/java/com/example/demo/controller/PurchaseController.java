package com.example.demo.controller;

import com.example.demo.domain.PurchaseInfo;
import com.example.demo.domain.dto.InfoDto;
import com.example.demo.repo.PurchaseInfoRepo;
import com.example.demo.service.PurchaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class PurchaseController {

    @Autowired
    EntityManager em;

    @Autowired
    PurchaseInfoRepo purchaseRepo;

    @Autowired
    private PurchaseInfoService purchaseInfoService;


    @GetMapping
    public List<PurchaseInfo> main(Model model){
        List<PurchaseInfo> purchases = purchaseInfoService.findAll();
        model.addAttribute("purchases", purchases);
        return purchases;
    }

    @GetMapping("{id}")
    public PurchaseInfo edit(
            @PathVariable("id") Long id

    ) {
        PurchaseInfo purchaseInfo = purchaseRepo.findById(id).get();
        return purchaseInfo;
    }

    @GetMapping("/actions/{action}")
    public List<PurchaseInfo> edit(
            @PathVariable("action") String action

    ) {
        List<PurchaseInfo> purchaseInfos = new ArrayList<>();
        switch (action) {
            case "last_week":
                LocalDateTime lastWeek = LocalDateTime.now().minusDays(7);
                purchaseInfos = purchaseRepo.findLastWeek(lastWeek);
                break;
            case "most_buy":
                purchaseInfos = purchaseRepo.findFirstByOrderByCountDesc();
                break;
        }
        return purchaseInfos;
    }

    @GetMapping("/actions/most_half_year")
    public PurchaseInfo most_half_year() {
        return purchaseRepo.sumHalfYear();
    }


//    @GetMapping("/actions/most_buy")
//    public void years_most_buy() {
//        InfoDto purchaseInfo = purchaseRepo.mostBuy();
//        return purchaseInfo;
//    }

    @PutMapping("{id}")
    public PurchaseInfo update(
            @PathVariable("id") PurchaseInfo purchaseFromDb,
            @RequestBody PurchaseInfo purchaseInfo,
            BindingResult bindingResult
//            @RequestBody PurchaseInfo message
    ) throws IOException {
        return purchaseInfoService.save(purchaseInfo, purchaseFromDb.getId());
    }

    @DeleteMapping("{id}")
    public Map delete(@PathVariable("id") PurchaseInfo purchaseInfo) {
        purchaseInfoService.delete(purchaseInfo);
        return new HashMap<>();
    }

   /* @GetMapping("/get")
    public List<Country> get(){
        return purchaseRepo.findAll();
    }*/

}
