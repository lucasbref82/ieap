package br.com.flutter.v1.model;

import br.com.flutter.v1.model.enums.EstadoCivilEnum;
import br.com.flutter.v1.model.enums.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    private String nome;
    private String senha;
    private SexoEnum sexo;
    private LocalDate dataNascimento;
    private EstadoCivilEnum estadoCivil;
    private String naturalidade;
    private String nacionalidade;

}
