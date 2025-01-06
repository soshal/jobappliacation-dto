package com.example.companyservice;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Get all companies
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Get company by id
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    // Create a new company
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    // Update existing company
    public Company updateCompany(Long id, Company updatedCompany) {
        return companyRepository.findById(id).map(company -> {
            company.setName(updatedCompany.getName());
            company.setLocation(updatedCompany.getLocation());
            company.setIndustry(updatedCompany.getIndustry());
            return companyRepository.save(company);
        }).orElseThrow(() -> new RuntimeException("Company not found with id " + id));
    }

    // Delete company by id
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }


    public void updateCompany(ReviewMessage reviewMessage) {
    }
}
