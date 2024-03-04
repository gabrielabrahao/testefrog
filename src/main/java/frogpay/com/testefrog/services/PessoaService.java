package frogpay.com.testefrog.services;
import frogpay.com.testefrog.entity.Pessoa;
import frogpay.com.testefrog.repository.DadosBancariosRepository;
import frogpay.com.testefrog.repository.EnderecoRepository;
import frogpay.com.testefrog.repository.LojaRepository;
import frogpay.com.testefrog.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private DadosBancariosRepository dadosBancariosRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private LojaRepository lojaRepository;

    public Pessoa savePessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Page<Pessoa> buscarPessoas(int pagina, int tamanhoPagina) {
        Pageable pageable = PageRequest.of(pagina, tamanhoPagina);
        return pessoaRepository.findAll(pageable);
    }



}
