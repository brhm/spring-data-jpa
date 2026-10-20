package com.brhmkskn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brhmkskn.entities.Customer;
import com.brhmkskn.entities.Home;

@Repository
public interface IHomeRepository  extends JpaRepository<Home, Long>{

}
