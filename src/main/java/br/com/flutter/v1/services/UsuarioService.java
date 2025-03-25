package br.com.flutter.v1.services;

import br.com.flutter.v1.model.Usuario;
import br.com.flutter.v1.model.dto.UsuarioDTO;
import br.com.flutter.v1.model.mapper.UsuarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioMapper usuarioMapper;

    public UsuarioDTO getUsuario(Integer id) {
        return usuarioMapper.domainToDto(new Usuario());
    }

    public List<UsuarioDTO> ListUsuario() {
        return usuarioMapper.domainToDto(List.of(new Usuario()));
    }

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        return usuarioMapper.domainToDto(new Usuario());
    }

    public UsuarioDTO atualizar(Integer id, UsuarioDTO usuarioDTO) {
        return usuarioMapper.domainToDto(new Usuario());
    }

    public void deletar() {

    }
}
