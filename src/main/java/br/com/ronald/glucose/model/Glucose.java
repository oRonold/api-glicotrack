package br.com.ronald.glucose.model;

import br.com.ronald.glucose.model.dto.PacientGlucoseMeasureDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

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
    private String glucoseType;
    @Column(name = "glucose_observations")
    private String observations;
    @Enumerated(EnumType.STRING)
    @Column(name = "glucose_exam_type", nullable = false)
    private FastingOrPostprandial fastingOrPostprandial;

    @ManyToOne
    @JoinColumn(name = "id_pacient")
    private Pacient pacient;

    public Glucose(){

    }

    public Glucose(PacientGlucoseMeasureDTO dto){
        this.examDate = LocalDateTime.now();
        this.glucoseLevel = dto.glucoseLevel();
        this.fastingOrPostprandial = FastingOrPostprandial.valueOf(dto.fastingOrPostprandial());
    }

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

    public String getGlucoseType() {
        return glucoseType;
    }

    public void setGlucoseType(String glucoseType) {
        this.glucoseType = glucoseType;
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

    public FastingOrPostprandial getFastingOrPostprandial() {
        return fastingOrPostprandial;
    }

    public void setFastingOrPostprandial(FastingOrPostprandial fastingOrPostprandial) {
        this.fastingOrPostprandial = fastingOrPostprandial;
    }
}
