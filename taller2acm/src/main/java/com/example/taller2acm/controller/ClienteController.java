package com.example.taller2acm.controller;

import com.example.taller2acm.dto.ClienteDTO;
import com.example.taller2acm.service.IClienteService;
import com.example.taller2acm.util.ClienteMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/api/v1/cliente")
@RequiredArgsConstructor
@Validated
public class ClienteController {
    private final IClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO dto) {
        // 1) DTO → Model
        var model = ClienteMapper.modelFromDto(dto);
        // 2) Model → Entity
        var entity = ClienteMapper.entityFromModel(model);
        // 3) Guardar Entity
        var savedEntity = service.save(entity);
        // 4) Entity → Model
        var savedModel  = ClienteMapper.modelFromEntity(savedEntity);
        // 5) Model → DTO
        var resultDto   = ClienteMapper.dtoFromModel(savedModel);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
         List<ClienteDTO> list = service.findAll().stream()
            .map(entity -> {
                var model = ClienteMapper.modelFromEntity(entity);
                return ClienteMapper.dtoFromModel(model);
            })
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
        return service.findById(id)
            .map(entity -> {
                var model = ClienteMapper.modelFromEntity(entity);
                return ClienteMapper.dtoFromModel(model);
            })
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteDTO dto) {
         var model    = ClienteMapper.modelFromDto(dto);
        var entity   = ClienteMapper.entityFromModel(model);
        entity.setId(id);
        var updatedE = service.save(entity);
        var updatedM = ClienteMapper.modelFromEntity(updatedE);
        return ResponseEntity.ok(ClienteMapper.dtoFromModel(updatedM));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}