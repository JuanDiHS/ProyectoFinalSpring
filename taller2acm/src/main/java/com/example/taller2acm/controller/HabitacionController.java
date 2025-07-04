package com.example.taller2acm.controller;

import com.example.taller2acm.dto.HabitacionDTO;
import com.example.taller2acm.service.IHabitacionService;
import com.example.taller2acm.util.HabitacionMapper;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/habitacion")
@RequiredArgsConstructor
@Validated
public class HabitacionController {
    private final IHabitacionService service;

    @PostMapping
    public ResponseEntity<HabitacionDTO> create(@Valid @RequestBody HabitacionDTO dto) {
         // 1) DTO → Model
        var model = HabitacionMapper.modelFromDto(dto);
        // 2) Model → Entity
        var entity = HabitacionMapper.entityFromModel(model);
        // 3) Guardar Entity
        var savedEntity = service.save(entity);
        // 4) Entity → Model
        var savedModel  = HabitacionMapper.modelFromEntity(savedEntity);
        // 5) Model → DTO
        var resultDto   = HabitacionMapper.dtoFromModel(savedModel);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping
    public ResponseEntity<List<HabitacionDTO>> getAll() {
        List<HabitacionDTO> list = service.findAll().stream()
            .map(entity -> {
                var model = HabitacionMapper.modelFromEntity(entity);
                return HabitacionMapper.dtoFromModel(model);
            })
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitacionDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> {
                var model = HabitacionMapper.modelFromEntity(entity);
                return HabitacionMapper.dtoFromModel(model);
            })
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HabitacionDTO> update(@PathVariable Long id, @Valid @RequestBody HabitacionDTO dto) {
         var model    = HabitacionMapper.modelFromDto(dto);
        var entity   = HabitacionMapper.entityFromModel(model);
        entity.setId(id);
        var updatedE = service.save(entity);
        var updatedM = HabitacionMapper.modelFromEntity(updatedE);
        return ResponseEntity.ok(HabitacionMapper.dtoFromModel(updatedM));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}