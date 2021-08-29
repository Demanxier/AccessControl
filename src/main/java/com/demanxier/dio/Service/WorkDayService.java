package com.demanxier.dio.Service;

import com.demanxier.dio.Repository.WorkDayRepository;
import com.demanxier.dio.model.Workday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkDayService {

    WorkDayRepository workDayRepository;

    @Autowired
    public WorkDayService(WorkDayRepository workDayRepository){
        this.workDayRepository = workDayRepository;
    }

    public Workday save(Workday workday){
        return workDayRepository.save(workday);
    }

    public List<Workday> findAll(){
        return  workDayRepository.findAll();
    }

    public Optional<Workday> getById(Long idWorkDay){
        return workDayRepository.findById(idWorkDay);
    }

    public Workday update(Workday workday){
        return workDayRepository.save(workday);
    }

    public void delete(Long idWorkDay){
        workDayRepository.deleteById(idWorkDay);
    }

}
