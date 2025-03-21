package br.com.ronald.glucose.model;

import br.com.ronald.glucose.model.dto.PacientGlucoseMeasureDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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

    public Glucose(PacientGlucoseMeasureDTO dto){
        this.examDate = LocalDateTime.now();
        this.glucoseLevel = dto.glucoseLevel();
        this.fastingOrPostprandial = FastingOrPostprandial.valueOf(dto.fastingOrPostprandial());
    }

}
