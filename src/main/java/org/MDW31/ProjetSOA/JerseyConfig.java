package org.MDW31.ProjetSOA;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig {

    @Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(org.MDW31.ProjetSOA.controllers.UserController.class);
        resourceConfig.register(org.MDW31.ProjetSOA.controllers.AuthorController.class);
        resourceConfig.register(org.MDW31.ProjetSOA.controllers.BookController.class);
        resourceConfig.register(org.MDW31.ProjetSOA.controllers.BorrowingController.class);

        return resourceConfig;
    }
}
