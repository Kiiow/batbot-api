package org.kio.batbot;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.kio.batbot.dal.ICommandRepository;
import org.kio.batbot.dal.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@SpringBootApplication
public class BatbotApplication extends RepositoryRestConfigurerAdapter {

    /*@Autowired
    private IUserRepository UserDAL;
    private ICommandRepository CommandDAL;*/

    public static void main(String[] args) {
        SpringApplication.run(BatbotApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("BatBot API").description("API of discord BatBot"));
    }
}
