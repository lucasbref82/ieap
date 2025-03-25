package br.com.flutter.v1.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EstadoCivilEnum {
    SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    UNIAO_ESTAVEL("União Estável"),
    DIVORCIADO("Divorciado"),
    VIUVO("Viuvo");


    @Getter
    private String descricao;

}
