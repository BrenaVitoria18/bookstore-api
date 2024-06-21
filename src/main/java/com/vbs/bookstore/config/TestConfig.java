package com.vbs.bookstore.config;

import com.vbs.bookstore.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // Identifica essa classe com um perfil de configuração
@Profile("test") //Cria um perfil de test para que será chamado no arquivo application.properties
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean //Toda vez que aplicação subir o perfil de test estiver configurado, atraves desta anotação vai rodar o metodo abaixo
    public boolean instanciaBaseDeDados(){
        this.dbService.instanciaBaseDeDados();
        return true;
    }

}
