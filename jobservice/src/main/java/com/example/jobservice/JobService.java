package com.example.jobservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public JobService(JobRepository jobRepository, RestTemplate restTemplate) {
        this.jobRepository = jobRepository;
        this.restTemplate = restTemplate;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(Long id, Job updatedJob) {
        return jobRepository.findById(id).map(job -> {
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setSalary(updatedJob.getSalary());
            return jobRepository.save(job);
        }).orElseThrow(() -> new RuntimeException("Job not found with id " + id));
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    // Fetch the company details from the external service using RestTemplate
    public Company getCompanyDetails(Long companyId) {
        return restTemplate.getForObject("http://companyservice/companies/" + companyId, Company.class);
    }

    // Method to get JobDTO with Company information
    public JobDTO getJobWithCompany(Long jobId) {
        Optional<Job> job = jobRepository.findById(jobId);
        if (job.isPresent()) {
            Job jobEntity = job.get();
            Company company = getCompanyDetails(jobEntity.getCompany()); // Fetch company details using companyId
            return JobMapper.toJobDTO(jobEntity, company); // Map Job to JobDTO
        }
        throw new RuntimeException("Job not found with id " + jobId);
    }
}
