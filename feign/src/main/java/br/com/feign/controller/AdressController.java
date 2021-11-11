package br.com.feign.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.feign.connection.CepConnection;
import br.com.feign.model.Adress;

@RestController
public class AdressController {

	CepConnection cepService;

	public AdressController(CepConnection cepService) {
		super();
		this.cepService = cepService;
	}

	@GetMapping("/{cep}")
	public ResponseEntity<Adress> getCep(@PathVariable String cep) {
		Adress adress = cepService.findAdressCep(cep);
		return adress != null ? ResponseEntity.ok().body(adress) : ResponseEntity.notFound().build();
	}

}
