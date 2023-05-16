package com.crud.javashastra.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.javashastra.entity.Cpart;

public interface BookRepository extends CrudRepository<Cpart, Integer> {

}
