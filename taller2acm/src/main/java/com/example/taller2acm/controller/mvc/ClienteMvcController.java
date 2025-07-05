package com.example.taller2acm.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import com.example.taller2acm.persistence.entity.ClienteEntity;
import com.example.taller2acm.service.IClienteService;

@Controller
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteMvcController {

    private final IClienteService clienteService;

    // Listar clientes
    @GetMapping
    public String list(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "cliente/list";
    }

    // Formulario de creación
    @GetMapping("/nuevo")
    public String createForm(Model model) {
        model.addAttribute("cliente", new ClienteEntity());
        return "cliente/form";
    }

    // Guardar alta o edición
   @PostMapping({ "", "/nuevo" })
public String save(@ModelAttribute ClienteEntity cliente) {
  clienteService.save(cliente);
  return "redirect:/cliente";
}

    // **Formulario de edición**
    @GetMapping("/editar/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        clienteService.findById(id)
            .ifPresent(c -> model.addAttribute("cliente", c));
        return "cliente/form";
    }

    // Borrar
    @GetMapping("/borrar/{id}")
    public String delete(@PathVariable Long id) {
        clienteService.deleteById(id);
        return "redirect:/cliente";
    }


}

