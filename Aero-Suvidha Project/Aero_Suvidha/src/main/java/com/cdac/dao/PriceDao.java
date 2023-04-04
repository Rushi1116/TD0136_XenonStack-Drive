package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entities.Price;
@Repository
public interface PriceDao extends JpaRepository<Price, Integer> {

}
