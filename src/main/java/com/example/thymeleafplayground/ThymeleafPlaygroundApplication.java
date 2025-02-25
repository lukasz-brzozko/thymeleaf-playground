package com.example.thymeleafplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.dialect.SpringStandardDialect;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.util.Map;

@SpringBootApplication
@RestController
@CrossOrigin("*")
public class ThymeleafPlaygroundApplication {

    private final TemplateEngine templateEngine;

    public ThymeleafPlaygroundApplication() {
        this.templateEngine = new TemplateEngine();
        StringTemplateResolver resolver = new StringTemplateResolver();
        resolver.setTemplateMode("HTML");
        resolver.setCacheable(false);
        this.templateEngine.setTemplateResolver(resolver);

        // Using SpringStandardDialect instead of OGNL
        this.templateEngine.setDialect(new SpringStandardDialect());
    }

    // Endpoint for rendering Thymeleaf with provided variables
    @PostMapping("/render")
    public String renderTemplate(@RequestBody Map<String, Object> request) {
        String template = (String) request.get("template");
        Map<String, Object> variables = (Map<String, Object>) request.get("variables");

        Context context = new Context();
        if (variables != null) {
            context.setVariables(variables);
        }

        return templateEngine.process(template, context);
    }

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafPlaygroundApplication.class, args);
    }
}
