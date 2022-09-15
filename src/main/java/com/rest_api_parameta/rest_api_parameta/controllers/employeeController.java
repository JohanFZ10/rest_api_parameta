package com.rest_api_parameta.rest_api_parameta.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest_api_parameta.rest_api_parameta.models.employeeModel;
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
    public employeeModel saveEmployee(@RequestBody employeeModel employee){
        
        Boolean any_emptyfield = employeeservice.checkfields(employee);
        Integer [] employee_age = employeeservice.gettime_elapsed(employee.getDateBirth());
        Integer [] employee_time = employeeservice.gettime_elapsed(employee.getDateAdmission());

        if(!any_emptyfield && employee_age[0]>=18 && employee_time[0] != -1){
            // Save Information in Database
            System.out.println("Save Information in Database");
            return this.employeeservice.saveEmployee(employee);
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

    // @GetMapping("/query")
    // public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
    //     return this.usuarioService.obtenerPorPrioridad(prioridad);
    // }

    // @DeleteMapping( path = "/{id}")
    // public String eliminarPorId(@PathVariable("id") Long id){
    //     boolean ok = this.usuarioService.eliminarUsuario(id);
    //     if (ok){
    //         return "Se eliminó el usuario con id " + id;
    //     }else{
    //         return "No pudo eliminar el usuario con id" + id;
    //     }
    // }

}