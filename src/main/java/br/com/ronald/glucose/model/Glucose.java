package br.com.ronald.glucose.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_glucose")
public class Glucose {

    @Id
    @Column(name = "glucose_id")
    private Long id;
    @Column(name = "glucose_date", nullable = false)
    private LocalDateTime examDate;
    @Column(name = "glucose_level", nullable = false)
    private Integer glucoseLevel;
    @Column(name = "glucose_type", nullable = false)
    private String examType;
    @Column(name = "glucose_observations")
    private String observations;
}
