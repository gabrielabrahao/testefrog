package frogpay.com.testefrog.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;

    private String nome;

    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private boolean ativo;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}
