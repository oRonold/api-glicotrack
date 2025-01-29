package br.com.ronald.glucose.repository;

import br.com.ronald.glucose.model.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientRepository extends JpaRepository<Pacient, Long> {
}
