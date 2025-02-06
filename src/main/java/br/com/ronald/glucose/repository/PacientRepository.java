package br.com.ronald.glucose.repository;

import br.com.ronald.glucose.model.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacientRepository extends JpaRepository<Pacient, Long> {

    @Query("select p from Pacient p where p.email = ?1")
    Pacient findbyEmail(String email);
}
