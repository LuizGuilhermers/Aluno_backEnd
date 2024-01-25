package com.controlealunos.controller;

import java.util.List;

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

import com.controlealunos.entities.Aluno;
import com.controlealunos.service.AlunoService;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*")
public class AlunoController {
	private final AlunoService alunoServices;
	 
    @Autowired
    public AlunoController (AlunoService alunoServices) {
        this.alunoServices = alunoServices;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity <Aluno> buscaAlunoIdControlId(@PathVariable Long id){
        Aluno aluno = alunoServices.buscarAlunoId(id);
        if(aluno!= null) {
            return ResponseEntity.ok(aluno);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Aluno>> buscaTodosAlunoControl() {
        List<Aluno> aluno = alunoServices.buscarTodosAluno();
 
        return ResponseEntity.ok(aluno);
    }
    
    @PostMapping
    public ResponseEntity<Aluno> salvaAlunoControl(@RequestBody Aluno aluno){
        Aluno salvaAluno = alunoServices.salvaAluno(aluno);
 
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaAluno);
 
    }
    @PutMapping ("/{id}")
    public ResponseEntity<Aluno> alterarPedidos(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno alterarAluno = alunoServices.alterarAluno(id,aluno);
        if (alterarAluno  != null) {
            return ResponseEntity.ok(alterarAluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaAlunoControl(@PathVariable Long idAluno) {
        boolean apagar = alunoServices.apagarAluno(idAluno);
        if(apagar) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
	

}
