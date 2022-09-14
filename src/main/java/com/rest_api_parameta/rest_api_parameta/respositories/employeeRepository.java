package com.rest_api_parameta.rest_api_parameta.respositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest_api_parameta.rest_api_parameta.models.employeeModel;

@Repository
public interface employeeRepository extends CrudRepository<employeeModel, Long> {
   

}
