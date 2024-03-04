package frogpay.com.testefrog.repository;

import frogpay.com.testefrog.entity.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LojaRepository extends JpaRepository<Loja, UUID> {
}
