package br.com.fiap.Show.repository;

import br.com.fiap.Show.entity.Banda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandaRepository extends JpaRepository<Banda, Integer> {
}
