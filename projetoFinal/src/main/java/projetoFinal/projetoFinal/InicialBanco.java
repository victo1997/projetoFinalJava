package projetoFinal.projetoFinal;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import projetoFinal.projetoFinal.pessoa.Pessoa;
import projetoFinal.projetoFinal.pessoa.PessoaRepositorio;

@Component
@Transactional
public class InicialBanco implements CommandLineRunner {
	
	@Autowired
	private PessoaRepositorio pessoaRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Pessoa p1 = new Pessoa("Victor");
		p1.setDataNascimento(LocalDate.of(1997, 5, 12));
		p1.setEmail("victor@gmail.com");
		
		Pessoa p2 = new Pessoa("Maria");
		p2.setDataNascimento(LocalDate.of(1995, 6, 13));
		p2.setEmail("maria@gmail.com");
		
		
		pessoaRepo.save(p1);
		pessoaRepo.save(p2);
		
	}
}
