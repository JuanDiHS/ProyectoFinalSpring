package com.example.taller2acm.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.taller2acm.dto.ClienteDTO;
import com.example.taller2acm.service.IClienteService;
import com.example.taller2acm.util.ClienteMapper;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteMvcController {
  private final IClienteService service;

  @GetMapping
   public String list(Model model) {
        var dtos = service.findAll().stream()
            .map(ent -> ClienteMapper.dtoFromModel(
                            ClienteMapper.modelFromEntity(ent)))
            .toList();
        model.addAttribute("clientes", dtos);
        return "cliente/list";
    }

    public String createForm(Model model) {
        model.addAttribute("cliente", new ClienteDTO());
        return "cliente/form";
    }

  @GetMapping("/editar/{id}")
   public String editForm(@PathVariable Long id, Model model) {
        service.findById(id).ifPresent(ent -> {
            ClienteDTO dto = ClienteMapper.dtoFromModel(
                                ClienteMapper.modelFromEntity(ent));
            model.addAttribute("cliente", dto);
        });
        return "cliente/form";
    }

  @PostMapping
  public String save(@ModelAttribute ClienteDTO dto) {

    var modelObj = ClienteMapper.modelFromDto(dto);
    var entity   = ClienteMapper.entityFromModel(modelObj);
    service.save(entity);
    return "redirect:/cliente";
}

  @GetMapping("/borrar/{id}")
  public String delete(@PathVariable Long id) {
    service.deleteById(id);
    return "redirect:/cliente";
  }

 @GetMapping("/prueba")
public String test() {
  return "cliente/solo";
}
@GetMapping("/list-solo")
public String listSolo() {
  return "cliente/list";
}
@GetMapping("/thymeleaf-test")
public String thymeleafTest() {
  return "test";
}




}

