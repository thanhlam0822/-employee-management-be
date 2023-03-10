package com.example.managementemployeebe;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManagementEmployeeBeApplication {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		return modelMapper  ;
	}
	public static void main(String[] args) {
		SpringApplication.run(ManagementEmployeeBeApplication.class, args);
	}

}
