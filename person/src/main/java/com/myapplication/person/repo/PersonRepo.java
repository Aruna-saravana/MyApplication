package com.myapplication.person.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapplication.person.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, String>{

}
