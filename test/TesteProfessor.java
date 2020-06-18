/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Professor;
import model.dao.ProfessorDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SIAT
 */
public class TesteProfessor {
    
    public TesteProfessor() {
        
    }
    
    @Test
    public void CadastrarProfessorTest(){
     
        Professor joao = new Professor();
	joao.setNome("João");
	joao.setTelefone("000000");
        joao.setEndereco("rua a");
        joao.setTitulacao("PosDoutorado");
        
        ProfessorDAO dao = new ProfessorDAO();
        
        if(dao.save(joao)){
            System.out.println("Salvo com sucesso!");
        }
        else{
            fail("Erro ao salvar");
        }
    }
}
