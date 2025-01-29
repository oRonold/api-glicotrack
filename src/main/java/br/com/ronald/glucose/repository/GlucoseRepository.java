package br.com.ronald.glucose.repository;

import br.com.ronald.glucose.model.Glucose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlucoseRepository extends JpaRepository<Glucose, Long> {
}
