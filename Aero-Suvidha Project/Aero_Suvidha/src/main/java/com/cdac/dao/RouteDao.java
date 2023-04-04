package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entities.Route;

@Repository
public interface RouteDao extends JpaRepository<Route, Integer> {

}
