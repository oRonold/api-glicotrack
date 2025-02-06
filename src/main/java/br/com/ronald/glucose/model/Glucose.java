package br.com.ronald.glucose.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "id_pacient")
    private Pacient pacient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDateTime examDate) {
        this.examDate = examDate;
    }

    public Integer getGlucoseLevel() {
        return glucoseLevel;
    }

    public void setGlucoseLevel(Integer glucoseLevel) {
        this.glucoseLevel = glucoseLevel;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }
}
