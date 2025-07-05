package com.example.taller2acm.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.example.taller2acm.persistence.entity.ReservaEntity;
import com.example.taller2acm.service.IReservaService;
import com.example.taller2acm.service.IClienteService;
import com.example.taller2acm.service.IHabitacionService;

@Controller
@RequestMapping("/reserva")
@RequiredArgsConstructor
public class ReservaMvcController {

  private final IReservaService reservaService;
  private final IClienteService clienteService;
  private final IHabitacionService habitacionService;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("reservas", reservaService.findAll());
    return "reserva/list";
  }

  @GetMapping("/nuevo")
  public String createForm(Model model) {
    model.addAttribute("reserva", new ReservaEntity());
    model.addAttribute("clientes", clienteService.findAll());
    model.addAttribute("habitaciones", habitacionService.findAll());
    return "reserva/form";
  }

  @PostMapping
  public String save(@ModelAttribute ReservaEntity reserva) {
    reservaService.save(reserva);
    return "redirect:/reserva";
  }

  @GetMapping("/editar/{id}")
  public String editForm(@PathVariable Long id, Model model) {
    reservaService.findById(id).ifPresent(r -> model.addAttribute("reserva", r));
    model.addAttribute("clientes", clienteService.findAll());
    model.addAttribute("habitaciones", habitacionService.findAll());
    return "reserva/form";
  }

  @GetMapping("/borrar/{id}")
  public String delete(@PathVariable Long id) {
    reservaService.deleteById(id);
    return "redirect:/reserva";
  }
}
