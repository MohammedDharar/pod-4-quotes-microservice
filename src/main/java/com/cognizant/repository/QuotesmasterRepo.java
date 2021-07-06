package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.QuotesMaster;

@Repository
public interface QuotesmasterRepo extends JpaRepository<QuotesMaster, Integer> {
	QuotesMaster findByBusinessValueAndPropertyValueAndPropertyType(Integer businessValue,Integer propertyValue,String propertyType);

	QuotesMaster findByBusinessValueAndPropertyValue(Integer businessValue, Integer propertyValue);
	}

