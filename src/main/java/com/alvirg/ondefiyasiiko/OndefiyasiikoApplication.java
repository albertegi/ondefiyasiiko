package com.alvirg.ondefiyasiiko;

import com.alvirg.ondefiyasiiko.role.Role;
import com.alvirg.ondefiyasiiko.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class OndefiyasiikoApplication {

	public static void main(String[] args) {

		SpringApplication.run(OndefiyasiikoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner runner(RoleRepository roleRepository){
//		return args -> {
//			final Optional<Role> userRole = roleRepository.findByName("USER_ROLE");
//			if(userRole.isEmpty()){
//				final Role role = new Role();
//				role.setName("ROLE_USER");
//				role.setCreatedBy("APP");
//				roleRepository.save(role);
//			}
//		};
//	}

}
