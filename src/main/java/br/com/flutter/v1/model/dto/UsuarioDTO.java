package br.com.flutter.v1.model.dto;

import br.com.flutter.v1.model.enums.EstadoCivilEnum;
import br.com.flutter.v1.model.enums.SexoEnum;

import java.time.LocalDate;

public class UsuarioDTO {
    private String nome;
    private SexoEnum sexo;
    private LocalDate dataNascimento;
    private EstadoCivilEnum estadoCivil;
    private String naturalidade;
    private String nacionalidade;
}
