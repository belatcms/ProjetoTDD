import model.Turma;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;


public class TesteTurma {
    
    public TesteTurma() {
    }
    
    @Test
    public void CadastrarTurmaTest(){
        
        Turma SI = new Turma(); 
        Calendar c = Calendar.getInstance();
        Date data = new Date();

        SI.setAno(data);
	SI.setSemestre(8);
        SI.setDia(data);
        SI.setHorario(c.getTime());        
    }

}
