package com.example.taller2acm.controller;

import com.example.taller2acm.dto.ReservaDTO;
import com.example.taller2acm.service.IReservaService;
import com.example.taller2acm.util.ReservaMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/reserva")
@RequiredArgsConstructor
@Validated

public class ReservaController {

    private final IReservaService service;


    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody ReservaDTO dto){


             // 1) DTO → Model
        var model = ReservaMapper.modelFromDto(dto);
        // 2) Model → Entity
        var entity = ReservaMapper.entityFromModel(model);
        // 3) Guardar Entity
        var savedEntity = service.save(entity);
        // 4) Entity → Model
        var savedModel  = ReservaMapper.modelFromEntity(savedEntity);
        // 5) Model → DTO
        var resultDto   = ReservaMapper.dtoFromModel(savedModel);
        return ResponseEntity.ok(resultDto);
    }

     @GetMapping
    public ResponseEntity<List<ReservaDTO>> getAll() {
         List<ReservaDTO> list = service.findAll().stream()
            .map(entity -> {
                var model = ReservaMapper.modelFromEntity(entity);
                return ReservaMapper.dtoFromModel(model);
            })
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> {
                var model = ReservaMapper.modelFromEntity(entity);
                return ReservaMapper.dtoFromModel(model);
            })
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> update(@PathVariable Long id, @Valid @RequestBody ReservaDTO dto) {
        var model    = ReservaMapper.modelFromDto(dto);
        var entity   = ReservaMapper.entityFromModel(model);
        entity.setId(id);
        var updatedE = service.save(entity);
        var updatedM = ReservaMapper.modelFromEntity(updatedE);
        return ResponseEntity.ok(ReservaMapper.dtoFromModel(updatedM));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }




    }


