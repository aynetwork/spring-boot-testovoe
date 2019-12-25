package com.example.demo.soap;

import com.example.demo.domain.Purchase;
import com.example.demo.domain.PurchaseInfo;
import com.example.demo.repo.PurchaseInfoRepo;
import com.example.demo.repo.PurchaseRepo;
import io.spring.guides.gs_producing_web_service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDateTime;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private PurchaseRepo purchaseRepo;
    private PurchaseInfoRepo purchaseInfoRepo;

    @Autowired
    public CountryEndpoint(PurchaseInfoRepo purchaseInfoRepo, PurchaseRepo purchaseRepo) {
        this.purchaseInfoRepo = purchaseInfoRepo;
        this.purchaseRepo = purchaseRepo;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPurchaseInfoRequest")
    @ResponsePayload
    public GetPurchaseInfoResponse getPurchaseInfo(@RequestPayload GetPurchaseInfoRequest request) {
        GetPurchaseInfoResponse response = new GetPurchaseInfoResponse();
        PurchaseInfo byName = purchaseInfoRepo.findByName(request.getName());
        io.spring.guides.gs_producing_web_service.PurchaseInfo purchaseInfo = new io.spring.guides.gs_producing_web_service.PurchaseInfo();
        Assert.notNull(byName, "Source must not be null");
        BeanUtils.copyProperties(byName, purchaseInfo);
        response.setPurchaseInfo(purchaseInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "setPurchaseInfoRequest")
    @ResponsePayload
    public SetPurchaseInfoResponse setCountry(@RequestPayload SetPurchaseInfoRequest request) {
        SetPurchaseInfoResponse response = new SetPurchaseInfoResponse();

        if (request.getPurchase() == null) {
            throw new ServiceFaultException("The purchase field is required");
        }

        PurchaseInfo purchaseInfo = new PurchaseInfo();

        BeanUtils.copyProperties(request, purchaseInfo);

        purchaseInfo.setCreationDate(LocalDateTime.now());
        Purchase purchase = purchaseRepo.findByName(capFirstLetter(request));
        purchaseInfo.setPurchase(purchase);
        PurchaseInfo save = purchaseInfoRepo.save(purchaseInfo);

        if (save != null) {
            response.setStatus(true);
        }

        return response;
    }

    private String capFirstLetter(@RequestPayload SetPurchaseInfoRequest request) {
        String searchStr = request.getPurchase().toString();

        return searchStr.substring(0, 1).toUpperCase() + searchStr.substring(1).toLowerCase();
    }
}