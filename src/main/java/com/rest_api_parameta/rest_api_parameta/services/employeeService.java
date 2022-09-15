package com.rest_api_parameta.rest_api_parameta.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest_api_parameta.rest_api_parameta.models.employeeModel;
import com.rest_api_parameta.rest_api_parameta.respositories.employeeRepository;


@Service
public class employeeService {
    @Autowired
    employeeRepository employeerepository;

    
    public ArrayList<employeeModel> getEmployees() {
        return (ArrayList<employeeModel>) employeerepository.findAll();
    }

    public employeeModel saveEmployee(employeeModel employee){
        return employeerepository.save(employee);
    }

    public Optional<employeeModel> getbyId(Long id){
        return employeerepository.findById(id);
    }

    public boolean deleteEmployee(Long id) {
        try{
            employeerepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    // Functions and Others Methods
    //Check Fields of RequestBody
    public Boolean checkfields(employeeModel employee) {
        
        if (employee.getNames().replace(" ","").isEmpty() || employee.getLastNames().replace(" ","").isEmpty() || 
            employee.getDocumentType().replace(" ","").isEmpty() || employee.getDocumentNumber().replace(" ","").isEmpty() ||
            employee.getDateBirth().replace(" ","").isEmpty() || employee.getDateAdmission().replace(" ","").isEmpty() || 
            employee.getPositionCompany().replace(" ","").isEmpty() || (employee.getSalary() <= 0 || employee.getSalary().equals(""))) {

            //System.out.println("Any field is empty!");
            return true;
         }
        return false; 
    }

    // Get time elapsed since a start date
    public Integer [] gettime_elapsed(String initial_date) {
        Integer [] time = new Integer[3];
        time[0] = -1; time[1] = 0; time[2] = 0;
        // Check date format
        //System.out.println("Fecha: "+initial_date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            TemporalAccessor objeto = formatter.parse(initial_date);
            //System.out.println("Fecha Valida");
            LocalDate fechaNacimiento = LocalDate.parse(initial_date, formatter);
            Period time_elapsed = Period.between(fechaNacimiento, LocalDate.now());
            time[0] = time_elapsed.getYears(); // Get Years
            time[1] = time_elapsed.getMonths(); // Get Months
            time[2] = time_elapsed.getDays(); // Get Days

            return time; 
             
        } catch (Exception e) {
            //System.out.println("Invalid Date");
            // time[0] = -1;
            return time;
        }
    }
 
}
