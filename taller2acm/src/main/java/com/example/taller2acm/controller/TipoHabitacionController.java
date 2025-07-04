package com.example.taller2acm.controller;


import com.example.taller2acm.dto.TipoHabitacionDTO;
import com.example.taller2acm.service.ITipoHabitacionService;
import com.example.taller2acm.util.TipoHabitacionMapper;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/tipo-habitacion")
@RequiredArgsConstructor
@Validated
public class TipoHabitacionController {
    private final ITipoHabitacionService service;

    @PostMapping
    public ResponseEntity<TipoHabitacionDTO> create(@Valid @RequestBody TipoHabitacionDTO dto) {
           // 1) DTO → Model
        var model = TipoHabitacionMapper.modelFromDto(dto);
        // 2) Model → Entity
        var entity = TipoHabitacionMapper.entityFromModel(model);
        // 3) Guardar Entity
        var savedEntity = service.save(entity);
        // 4) Entity → Model
        var savedModel  = TipoHabitacionMapper.modelFromEntity(savedEntity);
        // 5) Model → DTO
        var resultDto   = TipoHabitacionMapper.dtoFromModel(savedModel);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping
    public ResponseEntity<List<TipoHabitacionDTO>> getAll() {
         List<TipoHabitacionDTO> list = service.findAll().stream()
            .map(entity -> {
                var model = TipoHabitacionMapper.modelFromEntity(entity);
                return TipoHabitacionMapper.dtoFromModel(model);
            })
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoHabitacionDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> {
                var model = TipoHabitacionMapper.modelFromEntity(entity);
                return TipoHabitacionMapper.dtoFromModel(model);
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