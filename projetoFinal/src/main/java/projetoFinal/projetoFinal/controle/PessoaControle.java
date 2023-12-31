package projetoFinal.projetoFinal.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import projetoFinal.projetoFinal.pessoa.Pessoa;
import projetoFinal.projetoFinal.pessoa.PessoaRepositorio;

import java.util.Optional;

@Controller
public class PessoaControle {
	
	@Autowired
	private PessoaRepositorio pessoaRepo;
	
	@GetMapping("/")
	public String paginaInicial() {
		return "rh/pessoas/paginaInicial";
	}
	
	
	
	@GetMapping("/rh/pessoas")
	public String pessoas(Model model) {
		model.addAttribute("listaPessoas", pessoaRepo.findAll());
		return"/rh/pessoas/index";
	}
	
	@GetMapping("/rh/pessoas/nova")
	public String novaPessoa(@ModelAttribute("pessoa")Pessoa pessoa) {
		return "/rh/pessoas/form";
	}
	
	@GetMapping("/rh/pessoas/{id}")
	public String alterarPessoa(@PathVariable("id") long id, Model model){
		Optional<Pessoa> pessoaOpt = pessoaRepo.findById(id);
		if (pessoaOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa inválida. ");
		}
		
		model.addAttribute("pessoa", pessoaOpt.get());
		return "rh/pessoas/form";
	}
	
	@PostMapping("/rh/pessoas/salvar")
	public String SalvarPessoa(@ModelAttribute("pessoa")Pessoa pessoa) {
		pessoaRepo.save(pessoa);
		return "redirect:/rh/pessoas";
	}
	@GetMapping("/rh/pessoas/excluir/{id}")
	public String excluirPessoa(@PathVariable("id") long id) {
		Optional<Pessoa> pessoaOpt = pessoaRepo.findById(id);
		if (pessoaOpt.isEmpty()) {
			throw new IllegalArgumentException("Pessoa inválida. ");
		}
		pessoaRepo.delete(pessoaOpt.get());
		return "redirect:/rh/pessoas";
	}
	
}
