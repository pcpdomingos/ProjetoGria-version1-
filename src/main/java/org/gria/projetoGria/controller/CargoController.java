package org.gria.projetoGria.controller;

import java.util.List;

import javax.validation.Valid;

import org.gria.projetoGria.model.Cargo;
import org.gria.projetoGria.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cargos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(value="API Spring - Projeto Gria")
public class CargoController {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@ApiOperation(value="Retorna uma lista dos cargos")
	@GetMapping("/todos")
	public ResponseEntity<List<Cargo>> GetAll(){
		return ResponseEntity.ok(cargoRepository.findAll());
	}

	@ApiOperation(value="Retorna os cargos por ID")
	@GetMapping("id/{id}")
	public ResponseEntity<Cargo> GetById(@PathVariable long id){
		return cargoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@ApiOperation(value="Retorna os cargos por nome da empresa")
	@GetMapping("/empresa/{empresa}")
	public ResponseEntity<List<Cargo>> GetByEmpresa(@PathVariable String empresa){
		return ResponseEntity.ok(cargoRepository.findAllByNomeContainingIgnoreCase(empresa));
	}
	
	@ApiOperation(value="Retorna os cargos por nome do cargo")
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cargo>> GetByTitulo(@PathVariable String nome){
		return ResponseEntity.ok(cargoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@ApiOperation(value="Cadastra um novo cargo")
	@PostMapping
	public ResponseEntity<Cargo> postCargo (@Valid @RequestBody Cargo cargo){
		return ResponseEntity.status(HttpStatus.CREATED).body(cargoRepository.save(cargo));
	}
	
	@ApiOperation(value="Faz a edição de um cargo")
	@PutMapping
	public ResponseEntity<Cargo> put (@RequestBody Cargo cargo){
		return ResponseEntity.status(HttpStatus.OK).body(cargoRepository.save(cargo));
	}
	
	@ApiOperation(value="Deleta um cargo buscando por ID")
	@DeleteMapping("id/{id}")
	public void delete(@PathVariable long id) {
		cargoRepository.deleteById(id);
	}	
}

