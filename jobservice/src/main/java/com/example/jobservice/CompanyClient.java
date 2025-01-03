package com.example.jobservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "companyservice")
public interface CompanyClient {

    @GetMapping("/companies/{companyId}")
    Company getCompanyDetails(@PathVariable("companyId") Long companyId);
}
