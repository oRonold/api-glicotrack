package br.com.ronald.glucose.model;

import br.com.ronald.glucose.model.dto.PacientEnrollDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_pacient")
public class Pacient implements UserDetails {

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

    @OneToMany(mappedBy = "pacient")
    private List<Glucose> glucoses;

    public Pacient(PacientEnrollDTO dto, String password) {
        this.name = dto.name();
        this.birthDate = dto.birtdate();
        this.gender = dto.gender();
        this.email = dto.email();
        this.phone = dto.phone();
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }
}
