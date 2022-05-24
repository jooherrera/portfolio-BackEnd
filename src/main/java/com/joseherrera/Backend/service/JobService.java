package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.JobModel;
import com.joseherrera.Backend.repository.JobRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService implements IService<JobModel> {

    @Autowired
    JobRepository jobRepo;

    @Override
    public JobModel getByPrincipalKey(int id) {
        return jobRepo.findById(id).orElse(null);
    }

    @Override
    public void update(JobModel model) {
        jobRepo.save(model);
    }

    @Override
    public JobModel getOneByForeignKeyId(int fkId) {
        //return jobRepo.findById(fkId).orElse(null);
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<JobModel> getAllByForeignKeyId(int fkId) {
        return jobRepo.findByExperienceId(fkId).orElse(null);
    }

    @Override
    public void add(int experienceID) {
        JobModel newJob = new JobModel();
        newJob.setExperienceId(experienceID);
        jobRepo.save(newJob);
    }

    @Override
    public void delete(int id) {
        jobRepo.deleteById(id);
    }

    
}
