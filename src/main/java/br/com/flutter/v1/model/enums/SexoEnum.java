package br.com.flutter.v1.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SexoEnum {
    MASCULINO("Masculino"),
    FEMININO("Feminino");


    @Getter
    private String sexo;
}
