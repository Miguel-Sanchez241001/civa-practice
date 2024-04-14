package com.civa.app;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.civa.app.models.Posicion;
import com.civa.app.models.enums.PosicionType;
import com.civa.app.repository.PosicionRepo;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	@Autowired
	PosicionRepo repository;
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	@Bean
	public GroupedOpenApi myApi() {
		return GroupedOpenApi.builder()
			.group("public apis")
			.pathsToMatch("/**")
			.build();
	}
	@Override
	public void run(String... args) throws Exception {

				if(repository.findAll().size()==0) {
					repository.save(new Posicion(PosicionType.PORTERO));
					repository.save(new Posicion(PosicionType.DEFENSA_CENTRAL));
					repository.save(new Posicion(PosicionType.LATERAL_DERECHO));
					repository.save(new Posicion(PosicionType.LATERAL_IZQUIERDO));
					repository.save(new Posicion(PosicionType.MEDIOCENTRO_DEFENSIVO));
					repository.save(new Posicion(PosicionType.MEDIOCENTRO));
					repository.save(new Posicion(PosicionType.MEDIOCAMPISTA_DERECHO));
					repository.save(new Posicion(PosicionType.MEDIOCAMPISTA_IZQUIERDO));
					repository.save(new Posicion(PosicionType.DELANTERO_CENTRO));
					repository.save(new Posicion(PosicionType.EXTREMO_DERECHO));
					repository.save(new Posicion(PosicionType.EXTREMO_IZQUIERDO));

				}	
		   
	}
}
