package ifce.edu.br.MeuPrimeiroSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifce.edu.br.MeuPrimeiroSpringBoot.model.Aluno;
import ifce.edu.br.MeuPrimeiroSpringBoot.service.AlunoServiceImpl;


@Controller
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	AlunoServiceImpl alunoservice;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("alunos",alunoservice.buscarTodos());
		return "/aluno/lista";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Aluno aluno) {
		return "/aluno/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Aluno aluno) {
		alunoservice.salvar(aluno);
		return "redirect:/alunos/cadastrar";	
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("aluno", alunoservice.buscarPorId(id));
		return "/aluno/cadastro";
		
	}
	
	@PostMapping("/editar")
	public String editar(Aluno aluno) {
		alunoservice.editar(aluno);
		return "redirect:/alunos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		alunoservice.excluir(alunoservice.buscarPorId(id));
		//return "redirect:/alunos/listar";
		return listar(model);
		
	}
}
