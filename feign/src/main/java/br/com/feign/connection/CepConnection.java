package br.com.feign.connection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.feign.model.Adress;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viaCep")
public interface CepConnection {

	@GetMapping("{cep}/json")
	Adress findAdressCep(@PathVariable("cep") String cep);

}
