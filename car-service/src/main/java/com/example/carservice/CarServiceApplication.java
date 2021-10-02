package com.example.carservice;

import com.example.carservice.domain.Car;
import com.example.carservice.repository.CarRepository;


import com.example.carservice.service.CarService;
import com.example.carservice.service.impl.CarServiceImpl;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
///import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.List;
import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})

public class CarServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);


    }

    //  http://localhost:8090/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
    @Configuration
    public class SwaggerConfig {

        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .info(
                            new Info()
                                    .title("Car-service Api")
                                    .version("1.0.0")
                    );
        }

    }

//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .info(
//                        new Info()
//                                .title("My Lab")
//                                .version("1.0.0")
//                                .contact(
//                                        new Contact()
//                                                .email("Seregi4.87@gmail.com")
//                                                .name("Levanov Siarhei")
//                                )
//                );
//    }

//@Bean
//    public Docket api(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//}


    //    @Configuration
//    static class OktaOAuth2WebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            // @formatter:off
//            http
//                .authorizeRequests().anyRequest().authenticated()
//                    .and()
//                .oauth2ResourceServer().jwt();
//            // @formatter:on
//        }
//    }

//    @Bean
//    ApplicationRunner init(CarRepository repository) {
//        return args -> {
//            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
//                "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
//                repository.save(new Car(name));
//            });
//            repository.findAll().forEach(System.out::println);
//        };
//    }
}

