package br.com.flutter.v1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensagemRetorno {
    private boolean sucesso;
    private String mensagem;
    private Object retorno;
}
