package com.demanxier.dio.Service;

import com.demanxier.dio.Repository.AccessLevelRepository;
import com.demanxier.dio.model.AccessLevel;
import com.demanxier.dio.model.Workday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessLevelService {

    AccessLevelRepository accessLevelRepository;

    @Autowired
    public AccessLevelService (AccessLevelRepository accessLevelRepository){
        this.accessLevelRepository = accessLevelRepository;
    }

    public AccessLevel save(AccessLevel accessLevel){
        return accessLevelRepository.save(accessLevel);
    }

    public List<AccessLevel> findAll(){
        return  accessLevelRepository.findAll();
    }

    public Optional<AccessLevel> getById(Long idAccessLevel){
        return accessLevelRepository.findById(idAccessLevel);
    }

    public AccessLevel update(AccessLevel accessLevel){
        return accessLevelRepository.save(accessLevel);
    }

    public void delete(Long idAccessLevel){
        accessLevelRepository.deleteById(idAccessLevel);
    }
}
