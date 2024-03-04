package frogpay.com.testefrog.resources;

import frogpay.com.testefrog.entity.DadosBancarios;
import frogpay.com.testefrog.entity.Endereco;
import frogpay.com.testefrog.entity.Pessoa;
import frogpay.com.testefrog.services.DadosBancariosService;
import frogpay.com.testefrog.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dadosbancarios")
public class DadosBancariosController {

    @Autowired
    private DadosBancariosService dadosBancariosService;

    @PostMapping("/{idPessoa}")
    public DadosBancarios save(@RequestBody DadosBancarios dadosBancarios, @PathVariable UUID idPessoa) {
        return dadosBancariosService.saveDadosBancarios(dadosBancarios,idPessoa);
    }


    @GetMapping("/{idPessoa}")
    public ResponseEntity<DadosBancarios> getDadosBancariosByPessoaId(@PathVariable UUID idPessoa) {
        DadosBancarios dadosBancarios = dadosBancariosService.getDadosBancariosByPessoaId(idPessoa);
        if (dadosBancarios != null) {
            return ResponseEntity.ok(dadosBancarios);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}