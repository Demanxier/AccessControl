package com.demanxier.dio.controller;

import com.demanxier.dio.Service.AccessLevelService;
import com.demanxier.dio.model.AccessLevel;
import com.demanxier.dio.model.Workday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/accesslevel")
public class AccessLevelController {

    @Autowired
    AccessLevelService accessLevelService;

    @PostMapping
    public AccessLevel createAccessLevel(@RequestBody AccessLevel accessLevel){
        return accessLevelService.save(accessLevel);
    }

    @GetMapping
    public List<AccessLevel> getAccessLevelList(){
        return accessLevelService.findAll();
    }

    @GetMapping("/{idAccessLevel}")
    public ResponseEntity<AccessLevel> getAccessLevelByID(@PathVariable("idAccessLevel")Long idAccessLevel) throws Exception{
        return ResponseEntity.ok(accessLevelService.getById(idAccessLevel).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }

    @PutMapping
    public AccessLevel updateAccessLevel(@RequestBody AccessLevel accessLevel){
        return accessLevelService.update(accessLevel);
    }

    @DeleteMapping("/{idAccessLevel}")
    public ResponseEntity<AccessLevel> deleteByID(@PathVariable("idAccessLevel") Long idAccessLevel) throws Exception {
        try {
            accessLevelService.delete(idAccessLevel);
        } catch (Exception e) {
            return (ResponseEntity<AccessLevel>) ResponseEntity.ok();
        }
        return null;
    }
}

