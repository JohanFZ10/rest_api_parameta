package com.rest_api_parameta.rest_api_parameta.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api_parameta.rest_api_parameta.models.employeeModel;
import com.rest_api_parameta.rest_api_parameta.models.queryemployeeModel;
import com.rest_api_parameta.rest_api_parameta.services.employeeService;

@RestController
@RequestMapping("/parameta/employees")
public class employeeController {
    @Autowired
    employeeService employeeservice;

    @GetMapping()
    public ArrayList<employeeModel> getEmployees(){
        return employeeservice.getEmployees();
    }

    @PostMapping()
    public queryemployeeModel QueryEmployee(@RequestBody employeeModel employee){
        
        Boolean any_emptyfield = employeeservice.checkfields(employee);
        Integer [] employee_age = employeeservice.gettime_elapsed(employee.getDateBirth());
        Integer [] employee_time = employeeservice.gettime_elapsed(employee.getDateAdmission());


        if(!any_emptyfield && employee_age[0]>=18 && employee_time[0] != -1){
            // Save Information in Database
            System.out.println("Save Information in Database");
            employeeservice.saveEmployee(employee);
            queryemployeeModel queryemployeemodel = new queryemployeeModel();
            queryemployeemodel.setNames(employee.getNames());
            queryemployeemodel.setLastNames(employee.getLastNames());
            queryemployeemodel.setDocumentType(employee.getDocumentType());
            queryemployeemodel.setDocumentNumber(employee.getDocumentNumber());
            queryemployeemodel.setDateBirth(employee.getDateBirth());
            queryemployeemodel.setDateAdmission(employee.getDateAdmission());
            queryemployeemodel.setPositionCompany(employee.getPositionCompany());
            queryemployeemodel.setSalary(employee.getSalary());
            queryemployeemodel.setEmployeeTime(employee_time[0].toString()+" años "+employee_time[1].toString()+" meses "+employee_time[2].toString()+" dias ");
            queryemployeemodel.setEmployeeAge(employee_age[0].toString()+" años "+employee_age[1].toString()+" meses "+employee_age[2].toString()+" dias ");
            queryemployeemodel.setId(employee.getId());
            return queryemployeemodel;
        }
        else{
            // Error in the information entered
            System.out.println("Error in the information entered");
            return null;
        }
       
    }

    @GetMapping( path = "/{id}")
    public Optional<employeeModel> getbyId(@PathVariable("id") Long id) {
    
        return this.employeeservice.getbyId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.employeeservice.deleteEmployee(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No se pudo eliminar el usuario con id" + id;
        }
    }

}