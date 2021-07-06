package com.cognizant.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 

@Entity
@Table(name = "Quotes_Master")
//@Getter
//@Setter
//@NoArgsConstructor
@ApiModel(description = "Model Class for the Quotes Master")
public class QuotesMaster {
	public QuotesMaster(Integer id, Integer businessValue, Integer propertyValue, String propertyType, String quotes) {
		super();
		this.id = id;
		this.businessValue = businessValue;
		this.propertyValue = propertyValue;
		this.propertyType = propertyType;
		this.quotes = quotes;
	}


	public QuotesMaster() {}
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ID")
	    @ApiModelProperty(value = "Id of Quotes Master")
	    private Integer id;
	    
	    
	    @Column(name="Business_Value")
	    @ApiModelProperty(value = "business Value of Quotes Master")
	    private Integer businessValue;
	    
	   
	    @Column(name="Property_Value")
	    @ApiModelProperty(value = "property Value of policy Quotes Master")
	    private Integer propertyValue;
	    
	    
	    @Column(name="Property_Type")
	    @ApiModelProperty(value = "property Value of policy Quotes Master")
	    private String propertyType;
	    
	    
	    @Column(name="Quotes")
	    @ApiModelProperty(value = "quotes of Quotes Master")
	    private String quotes;


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public Integer getBusinessValue() {
			return businessValue;
		}


		public void setBusinessValue(Integer businessValue) {
			this.businessValue = businessValue;
		}


		public Integer getPropertyValue() {
			return propertyValue;
		}


		public void setPropertyValue(Integer propertyValue) {
			this.propertyValue = propertyValue;
		}


		public String getPropertyType() {
			return propertyType;
		}


		public void setPropertyType(String propertyType) {
			this.propertyType = propertyType;
		}


		public String getQuotes() {
			return quotes;
		}


		public void setQuotes(String quotes) {
			this.quotes = quotes;
		}
	
}
