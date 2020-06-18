/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Aluno;
import model.Curso;
import java.util.ArrayList;
import java.util.Collection;
import model.dao.AlunoDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteAluno {
    
    public TesteAluno() {
        
    }
    
    @Test
    public void AlunoAtivoTest(){
     
        Aluno alunos = new Aluno();
        
        assertEquals(alunos.AlunoAtivo(11712313), true);
        assertEquals(alunos.AlunoAtivo(11712315), true);        
        assertEquals(alunos.AlunoAtivo(11712316), false);

    }
  
    @Test
    public void ConsultarSituacaoAlunoTest(){
     
        Aluno alunos = new Aluno();
        
        assertEquals(alunos.ConsultarSituacaoAluno("Maria", 11712313), true);        
        //assertEquals(alunos.ConsultarSituacaoAluno("Matheus", 11712313), true); //para dar erro
        assertEquals(alunos.ConsultarSituacaoAluno("João", 11712315), true);
    }
    
    @Test
    public void matricularAlunoCursoTest(){
     
        Aluno alunos = new Aluno();        
        Curso cursos = new Curso();

        assertEquals(alunos.matricularAlunoCurso(2, 11712313), true);        
        assertEquals(alunos.matricularAlunoCurso(2, 11712315), false);        
    }
    
    @Test
    public void CadastrarAlunoTest(){
     
        Aluno maria = new Aluno();        
        maria.setNome("Maria");
	maria.setTelefone("000000");
        maria.setEndereco("rua a");
        maria.setSituacao("matriculado");
        maria.setMatricula(11712313);
        
        //Abre a conexão com o BD
        AlunoDAO dao = new AlunoDAO();
      
        //Chama da DAO o save
        if(dao.save(maria)){
            System.out.println("Salvo com sucesso!");
        }
        else{
            fail("Erro ao salvar");
        }

    }
    
}
