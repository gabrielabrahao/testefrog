package frogpay.com.testefrog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tb_dados_bancarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DadosBancarios {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    private Pessoa pessoa;

    @Column(name = "codigo_banco")
    private String codigoBanco;

    @Column(name = "agencia")
    private String agencia;

    @Column(name = "conta")
    private String conta;

    @Column(name = "digito_conta")
    private String digitoConta;


}
