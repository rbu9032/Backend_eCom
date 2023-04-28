package com.rbu.ecp.config;


import com.rbu.ecp.entity.*;
import org.hibernate.type.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Value("${allowed.origins}")
    private String[] theAllowedOrigins;
    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH};

        //disable HTTP methods for Product, ProductCategory, State, City: PUT, POST, DELETE
        disableHttpMethod(Product.class, config, theUnsupportedActions);
        disableHttpMethod(ProductCategory.class, config, theUnsupportedActions);
        disableHttpMethod(State.class, config, theUnsupportedActions);
        disableHttpMethod(City.class, config, theUnsupportedActions);
        disableHttpMethod(Order.class, config, theUnsupportedActions);

        //call an internal helper method
        config.exposeIdsFor(entityManager.getMetamodel().getEntities()
                            .stream().map(e -> e.getJavaType()).collect(Collectors.toList())
                            .toArray(new Class[0]));
        //configure cors mapping
        cors.addMapping(config.getBasePath() + "/**").allowedOrigins(theAllowedOrigins);

    }

    private void disableHttpMethod(Class theClass,RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }


}
