package com.brennodev.cadastro_usuarios_api.infrastructure.repository;

import com.brennodev.cadastro_usuarios_api.infrastructure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
