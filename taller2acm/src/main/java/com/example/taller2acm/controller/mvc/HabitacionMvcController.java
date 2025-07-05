package com.example.taller2acm.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.example.taller2acm.persistence.entity.HabitacionEntity;
import com.example.taller2acm.service.IHabitacionService;
import com.example.taller2acm.service.IHotelService;
import com.example.taller2acm.service.ITipoHabitacionService;

@Controller
@RequestMapping("/habitacion")
@RequiredArgsConstructor
public class HabitacionMvcController {

  private final IHabitacionService habitacionService;
  private final IHotelService hotelService;
  private final ITipoHabitacionService tipoService;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("habitaciones", habitacionService.findAll());
    return "habitacion/list";
  }

  @GetMapping("/nuevo")
  public String createForm(Model model) {
    model.addAttribute("habitacion", new HabitacionEntity());
    model.addAttribute("hoteles", hotelService.findAll());
    model.addAttribute("tipos", tipoService.findAll());
    return "habitacion/form";
  }

  @PostMapping
  public String save(@ModelAttribute HabitacionEntity habitacion) {
    habitacionService.save(habitacion);
    return "redirect:/habitacion";
  }

  @GetMapping("/editar/{id}")
  public String editForm(@PathVariable Long id, Model model) {
    habitacionService.findById(id).ifPresent(h -> model.addAttribute("habitacion", h));
    model.addAttribute("hoteles", hotelService.findAll());
    model.addAttribute("tipos", tipoService.findAll());
    return "habitacion/form";
  }

  @GetMapping("/borrar/{id}")
  public String delete(@PathVariable Long id) {
    habitacionService.deleteById(id);
    return "redirect:/habitacion";
  }
}
