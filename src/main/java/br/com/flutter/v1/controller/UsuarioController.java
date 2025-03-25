package br.com.flutter.v1.controller;

import br.com.flutter.v1.model.dto.UsuarioDTO;
import br.com.flutter.v1.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listUsuario() {
        return usuarioService.ListUsuario();
    }

    @GetMapping("/{id}")
    public UsuarioDTO getUsuario(@PathVariable Integer id) {
        return usuarioService.getUsuario(id);
    }

    @PostMapping()
    public UsuarioDTO saveUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.salvar(usuarioDTO);
    }

    @PutMapping("/{id}")
    public UsuarioDTO updateUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.atualizar(id, usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }

}
