package com.example.goliathwelcomeapplication.config;

import com.example.goliathwelcomeapplication.entity.Comment;
import com.example.goliathwelcomeapplication.entity.Crew;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private String allowedOrrigins = "http://localhost:3000";;





    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){

        HttpMethod[] unSupportedMethods = {
                HttpMethod.POST,
                HttpMethod.PUT,
                HttpMethod.PATCH,
                HttpMethod.DELETE
        };


        config.exposeIdsFor(Crew.class);
        config.exposeIdsFor(Comment.class);

        cors.addMapping(config.getBasePath() + "/**").allowedOrigins(allowedOrrigins);

        disableHttpMethods(Crew.class,config,unSupportedMethods);
        disableHttpMethods(Comment.class,config,unSupportedMethods);
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] unSupportedMethods){

        config.getExposureConfiguration().forDomainType(Crew.class)
                .withItemExposure(((metdata, httpMethods) ->
                        httpMethods.disable(unSupportedMethods)))
                .withCollectionExposure(((metdata, httpMethods) ->
                        httpMethods.disable(unSupportedMethods)));
    }

}
