package com.snayder.casadocodigo.repositories;

import com.snayder.casadocodigo.domain.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CupomRepository extends JpaRepository<Cupom, String> {
}
