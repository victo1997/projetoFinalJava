package projetoFinal.projetoFinal.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import projetoFinal.projetoFinal.pessoa.PessoaRepositorio;

@Controller
public class PessoaControle {
	
	@Autowired
	private PessoaRepositorio pessoaRepo;
	
	
	
	@GetMapping("/rh/pessoas")
	public String pessoas(Model model) {
		model.addAttribute("listaPessoas", pessoaRepo.findAll());
		return"rh/pessoas/index";
	}
	
}
