package com.example.taller2acm.controller;



import com.example.taller2acm.dto.EmpleadoDTO;
import com.example.taller2acm.service.IEmpleadoService;
import com.example.taller2acm.util.EmpleadoMapper;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/empleado")
@RequiredArgsConstructor
@Validated
public class EmpleadoController {
    private final IEmpleadoService service;

    @PostMapping
    public ResponseEntity<EmpleadoDTO> create(@Valid @RequestBody EmpleadoDTO dto) {
        // 1) DTO → Model
        var model = EmpleadoMapper.modelFromDto(dto);
        // 2) Model → Entity
        var entity = EmpleadoMapper.entityFromModel(model);
        // 3) Guardar Entity
        var savedEntity = service.save(entity);
        // 4) Entity → Model
        var savedModel  = EmpleadoMapper.modelFromEntity(savedEntity);
        // 5) Model → DTO
        var resultDto   = EmpleadoMapper.dtoFromModel(savedModel);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> getAll() {
       List<EmpleadoDTO> list = service.findAll().stream()
            .map(entity -> {
                var model = EmpleadoMapper.modelFromEntity(entity);
                return EmpleadoMapper.dtoFromModel(model);
            })
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> {
                var model = EmpleadoMapper.modelFromEntity(entity);
                return EmpleadoMapper.dtoFromModel(model);
            })
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(@PathVariable Long id, @Valid @RequestBody EmpleadoDTO dto) {
        var model    = EmpleadoMapper.modelFromDto(dto);
        var entity   = EmpleadoMapper.entityFromModel(model);
        entity.setId(id);
        var updatedE = service.save(entity);
        var updatedM = EmpleadoMapper.modelFromEntity(updatedE);
        return ResponseEntity.ok(EmpleadoMapper.dtoFromModel(updatedM));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
