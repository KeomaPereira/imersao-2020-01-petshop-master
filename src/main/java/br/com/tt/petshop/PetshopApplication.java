package br.com.tt.petshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetshopApplication.class, args);
	}

//USAR O H2
//URL: http://localhost:8080/h2-console/
//JDBC URL: dbc:h2:mem:testdb
//VM options na configuração do debug: -Dspring.profiles.active=local

}
