package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.JobModel;
import com.joseherrera.Backend.repository.BaseRepository;
import com.joseherrera.Backend.repository.JobRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService extends BaseService<JobModel, JobRepository> {

    @Override
    public List<JobModel> getAllByForeignKeyId(int fkId) {
        return repo.findByExperienceId(fkId).orElse(null);
    }

    @Override
    public void add(int experienceID) {
        JobModel newJob = new JobModel();
        newJob.setExperienceId(experienceID);
        repo.save(newJob);
    }

}
