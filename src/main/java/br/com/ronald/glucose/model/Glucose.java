package br.com.ronald.glucose.model;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
