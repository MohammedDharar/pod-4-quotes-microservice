package com.cognizant.service;

import javax.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.cognizant.exception.QuotesNotFoundException;
import com.cognizant.model.QuotesMaster;
import com.cognizant.repository.QuotesmasterRepo;

 

@Service
public class QuotesService {
    
    @Autowired
     QuotesmasterRepo quotesmasterRepo;
    
    
    //private QuotesmasterRepo quotesmasterRepo;
    @Transactional
    public String getQuotes(Integer businessValue,Integer propertyValue,String propertyType) throws QuotesNotFoundException {
        QuotesMaster quotesMaster=quotesmasterRepo.findByBusinessValueAndPropertyValueAndPropertyType(businessValue,propertyValue, propertyType);
        if(quotesMaster==null) {
            throw new QuotesNotFoundException("QS1-Quotes Not Found.");
        }
        return quotesMaster.getQuotes();
        
    }

 

        @Transactional
    public QuotesMaster getQuotesMaster(Integer businessValue,Integer propertyValue) throws QuotesNotFoundException {
        // TODO Auto-generated method stub
            QuotesMaster quotesMaster= quotesmasterRepo.findByBusinessValueAndPropertyValue(businessValue,
                    propertyValue);
            if(quotesMaster==null) {
                throw new QuotesNotFoundException("QS1-Quotes Not Found.");
            }
            return quotesMaster;
    }
        

 

}
