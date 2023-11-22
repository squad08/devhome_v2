package com.devhome.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.devhome.models.UsuarioModel;
import com.devhome.repositories.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public ModelAndView listar() {
		List<UsuarioModel> usuarioModel = usuarioRepository.findAll();
		ModelAndView mvc = new ModelAndView("usuarios/listar.html");
		mvc.addObject("usuarios", usuarioModel);
		return mvc;
	}

	@GetMapping("/cadastrar")
	public ModelAndView formUsuario() {
		ModelAndView mvc = new ModelAndView("usuarios/cadastrar");
		mvc.addObject("usuarios", new UsuarioModel());
		return mvc;
	}

	@PostMapping("/cadastrar")
	public ModelAndView novoUsuario(@ModelAttribute("usuarios") UsuarioModel usuarios) {
		ModelAndView mvc = new ModelAndView();
		usuarioRepository.save(usuarios);
		mvc.setViewName("redirect:/usuarios");
		return mvc;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mvc = new ModelAndView("usuarios/editar.html");
		UsuarioModel usuario = usuarioRepository.getReferenceById(id);
		mvc.addObject("usuario", usuario);
		return mvc;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(UsuarioModel usuarios) {
		ModelAndView mvc = new ModelAndView("redirect:/usuarios");
		usuarioRepository.save(usuarios);
		return mvc;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView mvc = new ModelAndView("redirect:/usuarios");
		usuarioRepository.deleteById(id);
		return mvc;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView mvc = new ModelAndView("usuarios/detalhar.html");
		UsuarioModel usuario = usuarioRepository.getReferenceById(id);
		mvc.addObject("usuario", usuario);
		return mvc;
	}

}