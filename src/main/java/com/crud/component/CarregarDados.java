package com.crud.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.crud.model.Papel;
import com.crud.repository.PapelRepository;

@Component
public class CarregarDados implements CommandLineRunner {
	
	@Autowired
	private PapelRepository repository;

	@Override
	public void run(String... args) throws Exception {

		String[] papeis = { "ADMIN", "USER", "MENEGER" };

		for (String papeisStrin : papeis) {
			Papel papel = repository.findByPapel(papeisStrin);
			if (papel == null) {
				papel = new Papel(papeisStrin);
				repository.save(papel);
			}
		}

	}

}
