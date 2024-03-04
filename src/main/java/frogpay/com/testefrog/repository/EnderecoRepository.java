package frogpay.com.testefrog.repository;

import frogpay.com.testefrog.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

    @Query("SELECT e FROM Endereco e WHERE e.pessoa.id = :idPessoa")
    Endereco findByIdPessoa(@Param("idPessoa")  UUID idPessoa);

    @Query("SELECT e FROM Endereco e WHERE e.pessoa.nome LIKE %:parteNome%")
    List<Endereco> findByNomeContainingInPessoa(@Param("parteNome") String parteNome);
}
