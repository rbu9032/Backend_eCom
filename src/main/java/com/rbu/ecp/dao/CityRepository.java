package com.rbu.ecp.dao;

import com.rbu.ecp.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//@CrossOrigin("http://localhost:4200/")
@RepositoryRestResource
public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findByStateCode(@Param("code") String code);
}
