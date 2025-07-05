package com.example.taller2acm.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.example.taller2acm.persistence.entity.HotelEntity;
import com.example.taller2acm.service.IHotelService;

@Controller
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelMvcController {

  private final IHotelService hotelService;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("hoteles", hotelService.findAll());
    return "hotel/list";
  }

  @GetMapping("/nuevo")
  public String createForm(Model model) {
    model.addAttribute("hotel", new HotelEntity());
    return "hotel/form";
  }

  @PostMapping
  public String save(@ModelAttribute HotelEntity hotel) {
    hotelService.save(hotel);
    return "redirect:/hotel";
  }

  @GetMapping("/editar/{id}")
  public String editForm(@PathVariable Long id, Model model) {
    hotelService.findById(id).ifPresent(h -> model.addAttribute("hotel", h));
    return "hotel/form";
  }

  @GetMapping("/borrar/{id}")
  public String delete(@PathVariable Long id) {
    hotelService.deleteById(id);
    return "redirect:/hotel";
  }
}
