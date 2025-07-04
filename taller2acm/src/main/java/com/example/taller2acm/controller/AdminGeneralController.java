package com.example.taller2acm.controller;

import com.example.taller2acm.dto.AdminGeneralDTO;
import com.example.taller2acm.service.IAdminGeneralService;
import com.example.taller2acm.util.AdminGeneralMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/v1/admin-general")
@RequiredArgsConstructor
@Validated
public class AdminGeneralController {
    private final IAdminGeneralService service;

    @PostMapping
    public ResponseEntity<AdminGeneralDTO> create(@Valid @RequestBody AdminGeneralDTO dto) {
        // 1) DTO → Model
        var model = AdminGeneralMapper.modelFromDto(dto);
        // 2) Model → Entity
        var entity = AdminGeneralMapper.entityFromModel(model);
        // 3) Guardar Entity
        var savedEntity = service.save(entity);
        // 4) Entity → Model
        var savedModel  = AdminGeneralMapper.modelFromEntity(savedEntity);
        // 5) Model → DTO
        var resultDto   = AdminGeneralMapper.dtoFromModel(savedModel);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping
    public ResponseEntity<List<AdminGeneralDTO>> getAll() {
         List<AdminGeneralDTO> list = service.findAll().stream()
            .map(entity -> {
                var model = AdminGeneralMapper.modelFromEntity(entity);
                return AdminGeneralMapper.dtoFromModel(model);
            })
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminGeneralDTO> getById(@PathVariable Long id) {
       return service.findById(id)
            .map(entity -> {
                var model = AdminGeneralMapper.modelFromEntity(entity);
                return AdminGeneralMapper.dtoFromModel(model);
            })
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminGeneralDTO> update(@PathVariable Long id, @Valid @RequestBody AdminGeneralDTO dto) {
         var model    = AdminGeneralMapper.modelFromDto(dto);
        var entity   = AdminGeneralMapper.entityFromModel(model);
        entity.setId(id);
        var updatedE = service.save(entity);
        var updatedM = AdminGeneralMapper.modelFromEntity(updatedE);
        return ResponseEntity.ok(AdminGeneralMapper.dtoFromModel(updatedM));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
