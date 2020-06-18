import model.Disciplina;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TesteDisciplina {
    
    public TesteDisciplina() {
    }
    
    @Test
    public void CadastrarDisciplinaTest(){
        
        Disciplina poo = new Disciplina();        

        poo.setCodigo_disciplina(10058);
	poo.setDescricao("Programação");
        poo.setCarga_horaria(90);
        poo.setEmenta("");        
        poo.setBibliografia("Livro a");
        poo.setPre_requesitos(false);
    }
    
    
    @Test
    public void CancelarDisciplinaTest(){
     
        Disciplina poo = new Disciplina();        

        poo.setCodigo_disciplina(10058);
	poo.setDescricao("Programação");
        poo.setCarga_horaria(90);
        poo.setEmenta("");        
        poo.setBibliografia("Livro a");
        poo.setPre_requesitos(false);
        
        assertEquals(poo.CancelarDisciplina(poo), true); 
        
        
        Disciplina eng = new Disciplina();        

        eng.setCodigo_disciplina(10058);
	eng.setDescricao("Engenharia II");
        eng.setCarga_horaria(90);
        eng.setEmenta("");        
        eng.setBibliografia("Livro a");
        eng.setPre_requesitos(false);
        
        assertEquals(eng.CancelarDisciplina(eng), true);
        
        Disciplina sd = new Disciplina();        

        sd.setCodigo_disciplina(10058);
	sd.setDescricao("Sistemas");
        sd.setCarga_horaria(90);
        sd.setEmenta("");        
        sd.setBibliografia("Livro a");
        sd.setPre_requesitos(true);
        
        assertEquals(sd.CancelarDisciplina(sd), false); 
    }
    
    @Test
    public void VerificarMatriculaAlunoNaDisciplinaTest(){
     
        Disciplina poo = new Disciplina();        
        assertEquals(poo.VerificarMatriculaAlunoNaDisciplina(10058, 11712313), true); 
        
        Disciplina eng = new Disciplina();        
        assertEquals(eng.VerificarMatriculaAlunoNaDisciplina(10060, 11712315), true); 
        assertEquals(eng.VerificarMatriculaAlunoNaDisciplina(10060, 11712313), false); 
        
    }
   
}
