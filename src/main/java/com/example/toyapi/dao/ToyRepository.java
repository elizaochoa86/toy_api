package com.example.toyapi.dao;

import com.example.toyapi.entities.Toy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ToyRepository extends CrudRepository<Toy, Integer> {
}
