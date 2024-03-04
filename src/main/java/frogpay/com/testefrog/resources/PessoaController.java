package frogpay.com.testefrog.resources;

import frogpay.com.testefrog.entity.DadosBancarios;
import frogpay.com.testefrog.entity.Endereco;
import frogpay.com.testefrog.entity.Pessoa;
import frogpay.com.testefrog.services.PessoaService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public Pessoa savePessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.savePessoa(pessoa);
    }

    @GetMapping("/pessoas")
    public ResponseEntity<Page<Pessoa>> buscarPessoas(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanhoPagina) {

        Page<Pessoa> pessoas = pessoaService.buscarPessoas(pagina, tamanhoPagina);
        return ResponseEntity.ok(pessoas);
    }


}