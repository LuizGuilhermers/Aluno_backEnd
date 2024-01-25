package com.controlealunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlealunos.entities.Aluno;
import com.controlealunos.repository.AlunoRepository;

@Service
public class AlunoService {
	private final AlunoRepository alunoRepository;
	 
    @Autowired
    public AlunoService (AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    public List<Aluno> buscarTodosAluno(){
        return alunoRepository.findAll();
    }
    public Aluno buscarAlunoId(Long idAluno) {
        Optional <Aluno> Pedidos = alunoRepository.findById(idAluno);
        return Pedidos.orElse(null);
    }
    public Aluno salvaAluno (Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    public Aluno alterarAluno(Long id, Aluno alterarAluno) {
        Optional <Aluno> existeAluno = alunoRepository.findById(id);
        if (existeAluno.isPresent()) {
            alterarAluno.setId(id);
            return alunoRepository.save(alterarAluno);
        }
        return null;
 
    }
    public boolean apagarAluno(Long idAluno) {
        Optional <Aluno> existeAluno = alunoRepository.findById(idAluno);
        if (existeAluno.isPresent()) {
            alunoRepository.deleteById(idAluno);
            return true;
        }
        return false;
    }

}