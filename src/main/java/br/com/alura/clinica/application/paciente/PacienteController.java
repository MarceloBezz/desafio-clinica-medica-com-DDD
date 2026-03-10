package br.com.alura.clinica.application.paciente;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.clinica.domain.paciente.Paciente;
import jakarta.validation.Valid;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/pacientes")
@SuppressWarnings("rawtypes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosPaciente dto, UriComponentsBuilder uriBuilder) {
        try {
            Paciente pacienteCadastrado = pacienteService.cadastrar(dto);
            URI uri = uriBuilder
                    .path("/medicos/{crm}")
                    .buildAndExpand(pacienteCadastrado.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(new DadosPaciente(pacienteCadastrado));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity buscarTodos() {
        try {
            var pacientes = pacienteService.buscaTodos();
            return ResponseEntity.ok(pacientes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity buscaPorId(@PathVariable Long id) {
        try {
            var paciente = pacienteService.buscarPorId(id);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizaDados(@RequestBody DadosAtualizaPaciente dto, @PathVariable Long id) {
        try {
            var paciente = pacienteService.atualizar(dto, id);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            pacienteService.deletar(id);
            return ResponseEntity.ok("Paciente deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
