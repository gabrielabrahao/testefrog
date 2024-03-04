package frogpay.com.testefrog.services;
import frogpay.com.testefrog.entity.Endereco;
import frogpay.com.testefrog.entity.Pessoa;
import frogpay.com.testefrog.exception.ValidacaoException;
import frogpay.com.testefrog.repository.DadosBancariosRepository;
import frogpay.com.testefrog.repository.EnderecoRepository;
import frogpay.com.testefrog.repository.LojaRepository;
import frogpay.com.testefrog.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private DadosBancariosRepository dadosBancariosRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;




    public Endereco getEnderecoByPessoaId(UUID idPessoa) {
        return enderecoRepository.findByIdPessoa(idPessoa);
    }


    public List<Endereco> getEnderecoByParteNome(String parteNome) {
        return enderecoRepository.findByNomeContainingInPessoa(parteNome);
    }


    public Endereco saveEndereco(Endereco dadosBancarios, UUID idPessoa) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow(() -> new ValidacaoException("Pessoa não encontrada"));
        dadosBancarios.setPessoa(pessoa);
        return enderecoRepository.save(dadosBancarios);
    }

}
