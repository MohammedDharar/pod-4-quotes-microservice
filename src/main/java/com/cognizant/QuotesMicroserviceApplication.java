package com.cognizant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.cognizant.model.QuotesMaster;
import com.cognizant.repository.QuotesmasterRepo;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
public class QuotesMicroserviceApplication implements CommandLineRunner{
	

	private QuotesmasterRepo quotesmasterRepo;
	
	QuotesMicroserviceApplication(QuotesmasterRepo quotesmasterRepo){
		this.quotesmasterRepo=quotesmasterRepo;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(QuotesMicroserviceApplication.class, args);
	}

	/**
	 * ConfigureSwagger2
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket configureSwagger2() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/quotes-master/**"))
				.apis(RequestHandlerSelectors.basePackage("com.cognizant")).build();
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		QuotesMaster quotesMaster=new QuotesMaster((Integer)1,(Integer)0,(Integer)0,"Equipment","80,000 INR");
		quotesmasterRepo.save(quotesMaster);
		QuotesMaster quotesMaster1=new QuotesMaster((Integer)2,(Integer)0,(Integer)0,"Equipment","80,000 INR");
		quotesmasterRepo.save(quotesMaster1);
		QuotesMaster quotesMaster2=new QuotesMaster((Integer)3,(Integer)1,(Integer)1,"Equipment","50,000 INR");
		quotesmasterRepo.save(quotesMaster2);
		QuotesMaster quotesMaster3=new QuotesMaster((Integer)4,(Integer)3,(Integer)3,"Equipment","50,000 INR");
		quotesmasterRepo.save(quotesMaster3);
		QuotesMaster quotesMaster4=new QuotesMaster((Integer)5,(Integer)4,(Integer)4,"Equipment","50,000 INR");
		quotesmasterRepo.save(quotesMaster4);
		QuotesMaster quotesMaster5=new QuotesMaster((Integer)6,(Integer)5,(Integer)5,"Equipment","80,000 INR");
		quotesmasterRepo.save(quotesMaster5);
		QuotesMaster quotesMaster6=new QuotesMaster((Integer)7,(Integer)8,(Integer)5,"Factory Equipment","2,00,000 INR");
		quotesmasterRepo.save(quotesMaster6);
		QuotesMaster quotesMaster7=new QuotesMaster((Integer)8,(Integer)9,(Integer)10,"Property in Tranisit","4,00,000 INR");
		quotesmasterRepo.save(quotesMaster7);
		QuotesMaster quotesMaster8=new QuotesMaster((Integer)9,(Integer)7,(Integer)8,"warehouse","2,00,000 INR");
		quotesmasterRepo.save(quotesMaster8);
		QuotesMaster quotesMaster9=new QuotesMaster((Integer)10,(Integer)2,(Integer)6,"warehouse","2,00,000 INR");
		quotesmasterRepo.save(quotesMaster9);
	}
}
