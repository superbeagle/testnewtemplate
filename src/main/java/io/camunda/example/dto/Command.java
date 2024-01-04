package io.camunda.example.dto;

import io.camunda.connector.generator.java.annotation.TemplateProperty;
import jakarta.validation.constraints.NotEmpty;

import java.util.Map;

public record Command(
        @NotEmpty
        @TemplateProperty() String sql,

        @NotEmpty
        @TemplateProperty() String commandType) {}

        //@NotEmpty
        //@TemplateProperty() Map<Integer, Object> params) {}
