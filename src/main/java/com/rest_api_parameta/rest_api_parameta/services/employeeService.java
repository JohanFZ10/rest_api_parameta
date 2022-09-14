package com.rest_api_parameta.rest_api_parameta.services;

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


    // public ArrayList<UsuarioModel>  obtenerPorPrioridad(Integer prioridad) {
    //     return usuarioRepository.findByPrioridad(prioridad);
    // }

    // public boolean eliminarUsuario(Long id) {
    //     try{
    //         usuarioRepository.deleteById(id);
    //         return true;
    //     }catch(Exception err){
    //         return false;
    //     }
    // }
}
