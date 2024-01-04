package io.camunda.example.dto;

import io.camunda.connector.generator.java.annotation.TemplateProperty;
import jakarta.validation.constraints.NotEmpty;

public record Authentication(
    @NotEmpty
    @TemplateProperty(label = "Username", description = "Username to use to connect to the database")
    String userName,
    @NotEmpty @TemplateProperty(label = "Password", description = "Password to use to connect to the database")
    String password) { }
