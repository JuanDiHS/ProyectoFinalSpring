package com.example.taller2acm.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.example.taller2acm.persistence.entity.UsuarioEntity;
import com.example.taller2acm.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioMvcController {

  private final IUsuarioService usuarioService;

  @GetMapping
  public String list(Model model) {
    model.addAttribute("usuarios", usuarioService.findAll());
    return "usuario/list";
  }

  @GetMapping("/nuevo")
  public String createForm(Model model) {
    model.addAttribute("usuario", new UsuarioEntity());
    return "usuario/form";
  }

  @PostMapping
  public String save(@ModelAttribute UsuarioEntity usuario) {
    usuarioService.save(usuario);
    return "redirect:/usuario";
  }

  @GetMapping("/editar/{id}")
  public String editForm(@PathVariable Long id, Model model) {
    usuarioService.findById(id).ifPresent(u -> model.addAttribute("usuario", u));
    return "usuario/form";
  }

  @GetMapping("/borrar/{id}")
  public String delete(@PathVariable Long id) {
    usuarioService.deleteById(id);
    return "redirect:/usuario";
  }
}

