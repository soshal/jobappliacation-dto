package com.example.jobservice;


import com.example.jobservice.JobDTO;
import com.example.jobservice.Job;





public class JobMapper {

    // Map Job entity to JobDTO
    public static JobDTO toJobDTO(Job job, Company company) {
        JobDTO dto = new JobDTO();
        dto.setId(job.getId());
        dto.setTitle(job.getTitle());
        dto.setDescription(job.getDescription());
        dto.setSalary(job.getSalary());
        dto.setCompanyId(job.getCompany()); // Set the company ID
        dto.setCompany(company); // Set the full Company object from the external service
        return dto;
    }

    // Map JobDTO to Job entity
    public static Job toJobEntity(JobDTO dto) {
        Job job = new Job();
        job.setId(dto.getId());
        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setSalary(dto.getSalary());

        // Set the company ID (assuming you only store company ID in Job entity)
        job.setCompany(dto.getCompanyId());
        return job;
    }
}
