package com.example.taller2acm.controller;

import com.example.taller2acm.dto.PagoDTO;
import com.example.taller2acm.service.IPagoService;
import com.example.taller2acm.util.PagoMapper;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;




@RestController
@RequestMapping("/api/v1/pago")
@RequiredArgsConstructor
@Validated
public class PagoController {
    private final IPagoService service;

    @PostMapping
    public ResponseEntity<PagoDTO> create(@Valid @RequestBody PagoDTO dto) {
           // 1) DTO → Model
        var model = PagoMapper.modelFromDto(dto);
        // 2) Model → Entity
        var entity = PagoMapper.entityFromModel(model);
        // 3) Guardar Entity
        var savedEntity = service.save(entity);
        // 4) Entity → Model
        var savedModel  = PagoMapper.modelFromEntity(savedEntity);
        // 5) Model → DTO
        var resultDto   = PagoMapper.dtoFromModel(savedModel);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping
    public ResponseEntity<List<PagoDTO>> getAll() {
        List<PagoDTO> list = service.findAll().stream()
            .map(entity -> {
                var model = PagoMapper.modelFromEntity(entity);
                return PagoMapper.dtoFromModel(model);
            })
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> getById(@PathVariable Long id) {
       return service.findById(id)
            .map(entity -> {
                var model = PagoMapper.modelFromEntity(entity);
                return PagoMapper.dtoFromModel(model);
            })
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    

    @GetMapping("/reserva/{reservaId}")
    public ResponseEntity<List<PagoDTO>> getByReserva(@PathVariable Long reservaId) {
        List<PagoDTO> list = service.findByReservaId(reservaId)   
        .stream()
        .map(entity -> {
            // 1) Entity → Model
            var model = PagoMapper.modelFromEntity(entity);
            // 2) Model → DTO
            return PagoMapper.dtoFromModel(model);
        })
        .collect(Collectors.toList());
    return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}