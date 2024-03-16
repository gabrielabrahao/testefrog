package frogpay.com.testefrog.services;
import frogpay.com.testefrog.entity.DadosBancarios;
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

import java.util.UUID;

@Service
public class DadosBancariosService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private DadosBancariosRepository dadosBancariosRepository;


    public DadosBancarios saveDadosBancarios(DadosBancarios dadosBancarios, UUID idPessoa) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow(()
                -> new ValidacaoException("Pessoa não encontrada"));
        DadosBancarios dadosBancariosOld = dadosBancariosRepository.findByPessoaId(idPessoa);
        if (dadosBancariosOld != null) {
            updateDadosBancarios(dadosBancarios, idPessoa);
        }
        dadosBancarios.setPessoa(pessoa);
        return dadosBancariosRepository.save(dadosBancarios);
    }

    public DadosBancarios updateDadosBancarios(DadosBancarios dadosBancarios, UUID idPessoa) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow(()
                -> new ValidacaoException("Pessoa não encontrada"));
        DadosBancarios dadosBancariosOld = dadosBancariosRepository.findByPessoaId(idPessoa);
        dadosBancarios.setId(dadosBancariosOld.getId());
        dadosBancarios.setPessoa(pessoa);
        return dadosBancariosRepository.save(dadosBancarios);
    }



    public DadosBancarios getDadosBancariosByPessoaId(UUID idPessoa) {
        return dadosBancariosRepository.findByPessoaId(idPessoa);
    }


}
