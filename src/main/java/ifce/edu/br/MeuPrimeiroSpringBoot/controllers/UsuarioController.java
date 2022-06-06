package ifce.edu.br.MeuPrimeiroSpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifce.edu.br.MeuPrimeiroSpringBoot.model.Usuario;

@Controller
@RequestMapping("u")
public class UsuarioController {
	// para cadastro de novos usuários
	@GetMapping("/novo/cadastro/usuario")
	//
	public String cadastrodeUsuario(Usuario usuario) {
		return "usuario/cadastro";
	}
}
