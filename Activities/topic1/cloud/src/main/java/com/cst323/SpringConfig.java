package com.cst323;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cst323.cloud.Business.PetsBusinessInterface;
import com.cst323.cloud.Business.PetsBusinessService;

@Configuration
public class SpringConfig {
    
    @Bean(name="petsBusinessService", initMethod = "init", destroyMethod = "destroy")
    public PetsBusinessInterface getPetsBusiness(){
        return new PetsBusinessService();
    }
}
