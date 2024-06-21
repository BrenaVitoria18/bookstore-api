package com.vbs.bookstore.config;

import com.vbs.bookstore.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}") // Pega o valor dessa linha application-dev.properties
    private  String strategy;

    @Bean
    public boolean instanciaBaseDeDados (){
        if (strategy.equals("create")){
            this.dbService.instanciaBaseDeDados();
            return true;
        }
        else {
            return false;
        }

    }


}
