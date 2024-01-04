package io.camunda.example.dto;

import io.camunda.connector.generator.java.annotation.TemplateProperty;
import jakarta.validation.constraints.NotEmpty;

public record Jdbc(@NotEmpty
                   @TemplateProperty() String jdbcUrl) {
}
