package br.com.ronald.glucose.model;

import br.com.ronald.glucose.model.dto.PacientEnrollDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor

@Entity
@Table(name = "tb_pacient")
public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pacient_id")
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

    @OneToMany
    private List<Glucose> glucoses;

    public Pacient(){

    }

    public Pacient(PacientEnrollDTO dto, String password) {
        this.name = dto.name();
        this.birthDate = dto.birtdate();
        this.gender = dto.gender();
        this.email = dto.email();
        this.phone = dto.phone();
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Glucose> getGlucoses() {
        return glucoses;
    }

    public void setGlucoses(List<Glucose> glucoses) {
        this.glucoses = glucoses;
    }
}
