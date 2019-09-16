/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;

/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class PetClinicApplication {

	
	@Autowired
	PetRepository petRepository;
	@Autowired
	VisitRepository visitRepository;

	private static final Logger log = LoggerFactory.getLogger(PetClinicApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PetClinicApplication.class, args);
    }
    
//    @Bean
//	public CommandLineRunner demoVetRepository(VetRepository vetRepository, SpecialityRepository specialityRepository) {
//		return (args) -> {
//			log.info("*****************************************************");
//			log.info("BOOTCAMP - Spring y Spring Data - vetRepository");
//			log.info("*****************************************************");
//
//			/*
//			 * List<Vet> vets = vetRepository.findAll();
//			 * 
//			 * for(Vet vet : vets) { log.info(vet.toString()); }
//			 */
//
//			// Exer1
//
//			/*
//			 * log.info("Criar objecto"); Vet vet = new Vet(); vet.setFirstName("Antonio");
//			 * vet.setLastName("Abreu");
//			 * 
//			 * log.info("Persistir"); vet = vetRepository.save(vet);
//			 * 
//			 * log.info("Comprovar que se fooi criado"); Vet vetAux =
//			 * vetRepository.findOne(vet.getId()); log.info(vetAux.toString());
//			 * 
//			 * log.info("Editar obj e adicionar uma especialidade"); Specialty s =
//			 * specialityRepository.findOne(1); vet.addSpecialty(s); vet =
//			 * vetRepository.save(vet); log.info(vet.toString());
//			 * 
//			 * log.info("Listar todos os vet"); for (Vet v : vetRepository.findAll()) {
//			 * log.info("Vet:" + v); }
//			 */
//
//			/*
//			 * log.info("Find last Name:-------------"); List<Vet> vetLastName =
//			 * vetRepository.findByLastName("Abreu");
//			 * 
//			 * for (Vet vet : vetLastName) { log.info(vet.toString()); }
//			 * 
//			 * log.info("Find last Name&& firstName:-------------");
//			 * 
//			 * List<Vet> v = vetRepository.findByFirstNameAndLastName("Antonio", "Abreu");
//			 * 
//			 * for (Vet vet : v) { log.info(v.toString()); }
//			 * 
//			 * log.info("Find last Name ||firstname:-------------");
//			 * 
//			 * List<Vet> v1 = vetRepository.findByFirstNameAndLastName("Antonio", "Abreu");
//			 * 
//			 * for (Vet vet : v1) { log.info(v.toString()); }
//			 * 
//			 * 
//			 * log.info(
//			 * "Exer3---------------------------------------------------------------");
//			 * 
//			 * 
//			 * log.info("radiologia-----------------------------------"); for (Vet vet :
//			 * vetRepository.findBySpecialityName("radiology")) { log.info(vet.toString());
//			 * }
//			 */
//
//
//		};
//	}

//	@Bean
//   	public CommandLineRunner demoOwnerRepository(OwnerRepository ownerRepository) {
//   		return (args) -> {
//   			log.info("*****************************************************");
//   			log.info("BOOTCAMP - Spring y Spring Data - OwnerRepository");
//   			log.info("*****************************************************");
//
//			log.info("ID:--------------------------------------------------");
//			/**/
//   			
//			log.info("Filtrar por nome---------------------------------------------------------------");
//   			for(Owner o:ownerRepository.findByFirstNameContainingOrLastNameContaining("Edu", "Est")){
//   				log.info("Owner:"+o);
//   				
//   			}
//   			
//   			log.info("Filtrar por nome mediante query--------------------------------------------------");
//   			for(Owner o:ownerRepository.searchOwner("an")){
//   				log.info("Owner:"+o);
//   				
//   			}
//   			log.info("Ordenar por Apelido------------------------------------------------------------");
//			for (Owner o : ownerRepository.findByOrderByLastName()) {
//   				log.info("Owner:"+o);
//   				
//   			}
//   			
//
//
//   		};
//   	}

	@Bean
	public CommandLineRunner demoReto() {
   		return (args) -> {
   			log.info("*****************************************************");
   			log.info("BOOTCAMP - Spring y Spring Data - Reto");
   			log.info("*****************************************************");

   			log.info("Obter as mascotes nascidas em ? ordenadas por ordem Ascendente");
			log.info("Obter os pets nascidos em 2010 ordenados por data ascendente");
			Date date1 = Date.from(LocalDate.of(1965, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date date2 = Date.from(LocalDate.of(2010, 12, 31).atStartOfDay(ZoneId.systemDefault()).toInstant());
   			
			for (Pet p : petRepository.findByBirthDateBetweenOrderByBirthDateAsc(date1, date2)) {
				log.info("Pets: " + p);
			}

			Date date3 = Date.from(LocalDate.of(2008, 12, 31).atStartOfDay(ZoneId.systemDefault()).toInstant());
			log.info("Criar Visitas");
			Visit v1 = new Visit();
			v1.setPetId(1);
			v1.setDate(date3);
			v1.setDescription("lala");

			log.info("Persistir");
			visitRepository.save(v1);

			Visit v2 = new Visit();
			v2.setPetId(2);
			v2.setDate(date3);
			v2.setDescription("dada");

			log.info("Persistir");
			visitRepository.save(v2);

			Visit v3 = new Visit();
			v3.setPetId(3);
			v3.setDate(date3);
			v3.setDescription("fafa");

			log.info("Persistir");
			visitRepository.save(v3);
			

			log.info("---------------*********");
			log.info("Visitas de Mascotas");
			for (Visit v : visitRepository.findByPetId(3)) {
				log.info("Visitas:" + v);
				
			}

			log.info("Top4");
			for (Visit v : visitRepository.findTop4ByOrderByDateDesc()) {
				log.info("Visitas:" + v);

			}


   		};
   	}

    
}
