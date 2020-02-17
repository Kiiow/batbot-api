package org.kio.batbot;

import org.kio.batbot.bo.Command;
import org.kio.batbot.bo.CommandCategory;
import org.kio.batbot.bo.CommandDetail;
import org.kio.batbot.bo.User;
import org.kio.batbot.dal.ICommandRepository;
import org.kio.batbot.dal.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@SpringBootApplication
public class BatbotApplication extends RepositoryRestConfigurerAdapter {

    @Autowired
    private IUserRepository UserDAL;
    private ICommandRepository CommandDAL;

    public static void main(String[] args) {
        SpringApplication.run(BatbotApplication.class, args);
        System.out.println("BatBot API just Started !");
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.getCorsRegistry()
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "DELETE")
                .allowCredentials(false)
                .maxAge(3600);
        config.exposeIdsFor(User.class)
               .exposeIdsFor(Command.class)
               .exposeIdsFor(CommandCategory.class)
               .exposeIdsFor(CommandDetail.class);
    }

}
