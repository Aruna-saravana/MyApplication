package com.myapplication.person.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapplication.person.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, String>{

}
