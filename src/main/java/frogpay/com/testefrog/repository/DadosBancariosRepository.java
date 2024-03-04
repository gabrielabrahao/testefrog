package frogpay.com.testefrog.repository;

import frogpay.com.testefrog.entity.DadosBancarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DadosBancariosRepository extends JpaRepository<DadosBancarios, UUID> {

    DadosBancarios findByPessoaId(UUID idPessoa);
}
