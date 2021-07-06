package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import com.cognizant.exception.QuotesNotFoundException;
import com.cognizant.feign.AuthorisationClient;
import com.cognizant.model.QuotesMaster;
import com.cognizant.repository.QuotesmasterRepo;
import com.cognizant.service.QuotesService;

 


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

 

@RestController
@Slf4j
@RequestMapping(value = "/quotes-master")
public class QuotesController {

 

    
    @Autowired
    QuotesService quotesService; 

 

    @Autowired
    private AuthorisationClient authorisationClient;

 

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

 

    @GetMapping("/getQuotesForPolicy/{businessValue}/{propertyValue}/{propertyType}")
    //@GetMapping("/getQuotesForPolicy")
    @ApiOperation(value = "getQuotesForPolicy", notes = "get the Quote Details for Policy", httpMethod = "GET", response = QuotesMaster.class)
        public String getQuotesForPolicy(@RequestHeader(name = "Authorization") String token,
                @PathVariable Integer businessValue, @PathVariable Integer propertyValue, @PathVariable String propertyType)throws QuotesNotFoundException 
    //public String getQuotesForPolicy(@RequestHeader(name = "Authorization") String token,
    //@RequestParam Integer businessValue, @RequestParam Integer propertyValue, @RequestParam String propertyType)throws QuotesNotFoundException 
     
                 {
        if (authorisationClient.validate(token)) {
                log.info("Start");
                return quotesService.getQuotes(businessValue,propertyValue,propertyType);
                } 
            else {
                    throw new QuotesNotFoundException("Q2-No Quotes,Contact Insurance Provider");
            }
        }

 

    @GetMapping("/getQuotesDetails/{businessValue}/{propertyValue}")
    @ApiOperation(value = "getQuotesDetails", notes = "get the Quotes for Policy", httpMethod = "GET", response = QuotesMaster.class)
    public QuotesMaster getQuotesDetails(@RequestHeader(name = "Authorization") String token,
            @PathVariable Integer businessValue, @PathVariable Integer propertyValue) throws QuotesNotFoundException {
        if (authorisationClient.validate(token)) {
            return quotesService.getQuotesMaster(businessValue,propertyValue);
        } else {
            System.out.println("Not Found....!");
            throw new QuotesNotFoundException("Q4-Quotes Details Not Found.");
        }
    }

 

//    @GetMapping("/get")
//    public List<QuotesMaster> getAll(){
//        return (List<QuotesMaster>) repo.findAll();
//    }
}