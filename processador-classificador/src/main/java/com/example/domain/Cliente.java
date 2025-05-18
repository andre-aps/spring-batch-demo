package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

    private String nome;
    private String sobrenome;
    private String idade;
    private String email;
    private List<Transacao> transacoes = new ArrayList<>();

}
