package br.com.alura.clinica.application.medico;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/medicos")
@SuppressWarnings("rawtypes")
public class MedicoController {
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

	@PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosMedico dto, UriComponentsBuilder uriBuilder) {
        try {
            DadosMedico medicoCadastrado = medicoService.cadastrar(dto);
            URI uri = uriBuilder
                    .path("/medicos/{crm}")
                    .buildAndExpand(medicoCadastrado.crm())
                    .toUri();

            return ResponseEntity.created(uri).body(medicoCadastrado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity buscarTodos() {
        try {
            var medicos = medicoService.buscaTodos();
            return ResponseEntity.ok(medicos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity buscaPorId(@PathVariable Long id) {
        try {
            var medico = medicoService.buscarPorId(id);
            return ResponseEntity.ok(medico);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizaDados(@RequestBody DadosAtualizaMedico dto, @PathVariable Long id) {
        try {
            var medico = medicoService.atualizar(dto, id);
            return ResponseEntity.ok(medico);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            medicoService.deletar(id);
            return ResponseEntity.ok("Médico deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
