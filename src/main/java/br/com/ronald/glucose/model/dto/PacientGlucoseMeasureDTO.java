package br.com.ronald.glucose.model.dto;

import br.com.ronald.glucose.model.FastingOrPostprandial;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacientGlucoseMeasureDTO(
        @NotNull
        Integer glucoseLevel,
        @NotBlank
        String fastingOrPostprandial) {
}
