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

import com.devhome.models.CursoModel;
import com.devhome.repositories.CursoRepository;

@Controller
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public ModelAndView listar() {
		List<CursoModel> cursoModel = cursoRepository.findAll();
		ModelAndView mvc = new ModelAndView("cursos/listar.html");
		mvc.addObject("cursos", cursoModel);
		return mvc;
	}

	@GetMapping("/cadastrar")
	public ModelAndView formCadastro() {
		ModelAndView mvc = new ModelAndView("cursos/cadastrar");
		mvc.addObject("cursos", new CursoModel());
		return mvc;
	}

	@PostMapping("/cadastrar")
	public ModelAndView novoCurso(@ModelAttribute("cursos") CursoModel cursos) {
		ModelAndView mvc = new ModelAndView();
		cursoRepository.save(cursos);
		mvc.setViewName("redirect:/cursos");
		return mvc;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView mvc = new ModelAndView("cursos/editar.html");
		CursoModel cursos = cursoRepository.getReferenceById(id);
		mvc.addObject("cursos", cursos);
		return mvc;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(CursoModel cursos) {
		ModelAndView mvc = new ModelAndView("redirect:/cursos");
		cursoRepository.save(cursos);
		return mvc;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView mvc = new ModelAndView("redirect:/cursos");
		cursoRepository.deleteById(id);
		return mvc;
	}

}