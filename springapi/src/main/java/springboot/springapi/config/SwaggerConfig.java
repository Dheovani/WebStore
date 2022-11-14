package springboot.springapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public ApiInfo apiInfo() {
        StringBuilder info = new StringBuilder();
        info.append("A api será responsável por realizar a comunicação entre o front-end do projeto, nosso componente React ")
            .append("e o back-end do projeto, o Springcore. A comunicação será feita via JSON.");

        return new ApiInfoBuilder()
                    .title("REST API SPRINGBOOT PROJECT")
                    .description(info.toString())
                    .termsOfServiceUrl("")
                    .license("")
                    .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                    .version("v1")
                    .build();
    }

    @Bean
    public Docket api2() {
        return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("springboot.springapi.api"))
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(apiInfo());
    }
    
}
