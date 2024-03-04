package frogpay.com.testefrog.resources;

import frogpay.com.testefrog.entity.DadosBancarios;
import frogpay.com.testefrog.entity.Endereco;
import frogpay.com.testefrog.entity.Pessoa;
import frogpay.com.testefrog.services.EnderecoService;
import frogpay.com.testefrog.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{idPessoa}")
    public Endereco save(@RequestBody Endereco dadosBancarios, @PathVariable UUID idPessoa) {
        return enderecoService.saveEndereco(dadosBancarios,idPessoa);
    }


    @GetMapping("/{idPessoa}")
    public ResponseEntity<Endereco> getEnderecoByPessoaId(@PathVariable UUID idPessoa) {
        Endereco endereco = enderecoService.getEnderecoByPessoaId(idPessoa);
        if (endereco != null) {
            return ResponseEntity.ok(endereco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{parteNome}")
    public ResponseEntity<List<Endereco>> getEnderecoByParteNome(@PathVariable String parteNome) {
        List<Endereco> enderecos = enderecoService.getEnderecoByParteNome(parteNome);
        if (!enderecos.isEmpty()) {
            return ResponseEntity.ok(enderecos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}