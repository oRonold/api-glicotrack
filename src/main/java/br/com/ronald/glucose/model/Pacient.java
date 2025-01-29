package br.com.ronald.glucose.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_pacient")
public class Pacient {

    @Id
    @Column(name = "glucose_id")
    private Long id;
    @Column(name = "pacient_name", nullable = false)
    private String name;
    @Column(name = "pacient_birth_date", nullable = false)
    private LocalDate birthDate;
    @Column(name = "pacient_gender", nullable = false)
    private String gender;
    @Column(name = "pacient_email", nullable = false, unique = true)
    private String email;
    @Column(name = "pacient_phone", nullable = false, unique = true)
    private String phone;
    @Column(name = "pacient_password", nullable = false)
    private String password;
}
