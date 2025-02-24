package br.com.ronald.glucose.model.dto;

import br.com.ronald.glucose.model.FastingOrPostprandial;
import br.com.ronald.glucose.model.Glucose;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PacientMeasureDetailsDTO(Long id,
                                       @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                                       LocalDateTime examDate, Integer glucoseLevel, String glucoseType, FastingOrPostprandial fastingOrPostprandial, String observations) {

    public PacientMeasureDetailsDTO(Glucose glucose){
        this(glucose.getId(), glucose.getExamDate(), glucose.getGlucoseLevel(), glucose.getGlucoseType(), glucose.getFastingOrPostprandial(), glucose.getObservations());
    }
}
