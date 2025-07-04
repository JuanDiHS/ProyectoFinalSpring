package com.example.taller2acm.controller;

import com.example.taller2acm.dto.HotelDTO;
import com.example.taller2acm.service.IHotelService;
import com.example.taller2acm.util.HotelMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/hotel")
@RequiredArgsConstructor
@Validated
public class HotelController {
    private final IHotelService service;

    @PostMapping
    public ResponseEntity<HotelDTO> create(@Valid @RequestBody HotelDTO dto) {
        // 1) DTO → Model
        var model = HotelMapper.modelFromDto(dto);
        // 2) Model → Entity
        var entity = HotelMapper.entityFromModel(model);
        // 3) Guardar Entity
        var savedEntity = service.save(entity);
        // 4) Entity → Model
        var savedModel  = HotelMapper.modelFromEntity(savedEntity);
        // 5) Model → DTO
        var resultDto   = HotelMapper.dtoFromModel(savedModel);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAll() {
         List<HotelDTO> list = service.findAll().stream()
            .map(entity -> {
                var model = HotelMapper.modelFromEntity(entity);
                return HotelMapper.dtoFromModel(model);
            })
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getById(@PathVariable Long id) {
         return service.findById(id)
            .map(entity -> {
                var model = HotelMapper.modelFromEntity(entity);
                return HotelMapper.dtoFromModel(model);
            })
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
