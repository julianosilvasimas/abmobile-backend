package com.abmobile;

//import java.util.Arrays;

//import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//import com.abmobile.domain.Ind_Precos;
//import com.abmobile.repositories.PrecosRepository;


@SpringBootApplication
public class ABMobileApplication extends SpringBootServletInitializer  {  
	
	//@Autowired
	//private PrecosRepository precosRepository;

	public static void main(String[] args) {
		SpringApplication.run(ABMobileApplication.class, args);
	}
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ABMobileApplication.class);
	}
	
}
