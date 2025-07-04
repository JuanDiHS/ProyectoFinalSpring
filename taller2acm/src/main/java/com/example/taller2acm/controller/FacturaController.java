package com.example.taller2acm.controller;

import com.example.taller2acm.dto.FacturaDTO;
import com.example.taller2acm.service.IFacturaService;
import com.example.taller2acm.util.FacturaMapper;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/factura")
@RequiredArgsConstructor
@Validated
public class FacturaController {
    private final IFacturaService service;

    @PostMapping
    public ResponseEntity<FacturaDTO> create(@Valid @RequestBody FacturaDTO dto) {
         // 1) DTO → Model
        var model = FacturaMapper.modelFromDto(dto);
        // 2) Model → Entity
        var entity = FacturaMapper.entityFromModel(model);
        // 3) Guardar Entity
        var savedEntity = service.save(entity);
        // 4) Entity → Model
        var savedModel  = FacturaMapper.modelFromEntity(savedEntity);
        // 5) Model → DTO
        var resultDto   = FacturaMapper.dtoFromModel(savedModel);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping
    public ResponseEntity<List<FacturaDTO>> getAll() {
        List<FacturaDTO> list = service.findAll().stream()
            .map(entity -> {
                var model = FacturaMapper.modelFromEntity(entity);
                return FacturaMapper.dtoFromModel(model);
            })
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/reserva/{reservaId}")
    public ResponseEntity<List<FacturaDTO>> getByReserva(@PathVariable Long reservaId) {
        List<FacturaDTO> list = service.findByReservaId(reservaId)
        .stream()
        .map(entity -> {
            // 1) Entity → Model
            var model = FacturaMapper.modelFromEntity(entity);
            // 2) Model → DTO
            return FacturaMapper.dtoFromModel(model);
        })
        .collect(Collectors.toList());
    return ResponseEntity.ok(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> {
                var model = FacturaMapper.modelFromEntity(entity);
                return FacturaMapper.dtoFromModel(model);
            })
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}