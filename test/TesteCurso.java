/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.Curso;
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
public class TesteCurso {
    
    public TesteCurso() {
    }
    
    public void CursoDisponivelTest(){
     
        Curso cursos = new Curso();
        
        assertEquals(cursos.CursoDisponivel(15), false);
        assertEquals(cursos.CursoDisponivel(3), true);
    }
}
