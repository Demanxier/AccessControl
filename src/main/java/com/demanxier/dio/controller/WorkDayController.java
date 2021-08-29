package com.demanxier.dio.controller;

import com.demanxier.dio.Service.WorkDayService;
import com.demanxier.dio.model.Workday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/workday")
public class WorkDayController {

    @Autowired
    WorkDayService workDayService;

    @PostMapping
    public Workday createWorkDay(@RequestBody Workday workday){
        return workDayService.save(workday);
    }

    @GetMapping
    public List<Workday> getWorkDayList(){
        return workDayService.findAll();
    }

    @GetMapping("/{idWorkDay}")
    public ResponseEntity<Workday> getWorkDayById(@PathVariable("idWorkDay")Long idWorkDay) throws Exception{
        return ResponseEntity.ok(workDayService.getById(idWorkDay).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }

    @PutMapping
    public Workday updateWorkDay(@RequestBody Workday workday){
        return workDayService.update(workday);
    }

    @DeleteMapping("/{idWorkDay}")
    public ResponseEntity<Workday> deleteByID(@PathVariable("idWorkDay") Long idWorkDay) throws Exception{
        try{
            workDayService.delete(idWorkDay);
        }catch (Exception e){
            return (ResponseEntity<Workday>) ResponseEntity.ok();
        }
        return null;
    }


}
