package io.camunda.example.dto;

import io.camunda.connector.generator.java.annotation.TemplateProperty;
import io.camunda.connector.generator.java.annotation.TemplateProperty.PropertyType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record MyConnectorRequest(
        @Valid @NotNull Command command,
        @Valid @NotNull Jdbc jdbc,
        @Valid @NotNull Authentication authentication) {}
