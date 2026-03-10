package br.com.alura.clinica.application.consulta;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/consultas")
@SuppressWarnings("rawtypes")
public class ConsultaController {
    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity agendarConsulta(@RequestBody DadosConsulta dto, UriComponentsBuilder uriBuilder) {
        try {
            var consulta = consultaService.agendarConsulta(dto);
            URI uri = uriBuilder
                    .path("/consultas/{id}")
                    .buildAndExpand(consulta.getId())
                    .toUri();

            return ResponseEntity.created(uri).body(new DadosConsulta(consulta));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarConsultaPorId(@PathVariable Long id) {
        try {
            var consulta = consultaService.buscarPorId(id);
            return ResponseEntity.ok(consulta);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity cancelarConsulta(@PathVariable Long id) {
        try {
            consultaService.cancelarConsulta(id);
            return ResponseEntity.ok("Consulta cancelada!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
