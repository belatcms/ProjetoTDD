/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.PreparedStatement;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Turma;

/**
 *
 * @author SIAT
 */
public class TurmaDAO {
    
    private Connection con = null;
    
    public TurmaDAO(){
        con = ConnectionFactory.getConnetion();
    }
    
    public boolean save(Turma turma){
        String sql = "INSERT INTO turma (ano, semestre, dia, horario)"
                        + "values (?,?,?,?)";
        
        PreparedStatement stmt = null;
        
        try{
             stmt = (PreparedStatement) con.prepareStatement(sql);
             stmt.setDate(1, (Date) turma.getAno());             
             stmt.setInt(2, turma.getSemestre());
             stmt.setDate(3, (Date) turma.getDia());
             stmt.setDate(4, (Date) turma.getHorario());
             //Executa função
             stmt.executeUpdate(); 
             
             return true;
        } catch (SQLException ex) {
                System.err.println("Erro: "+ex);
                return false;
        } finally{
            //Fecha conexão
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //Consulta
    public List<Turma> findAll(){
        
        String sql = "SELECT * FROM turma";
        
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<Turma> turmas = new ArrayList<>();
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement(sql); //Abriu a conexão
            rs = stmt.executeQuery(); //executa
            
            //usa para percorrer o resultSet
            while(rs.next())
            {
                Turma turma = new Turma();
                turma.setAno(rs.getDate("ano"));
                turmas.add(turma);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
         } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return turmas;
    }
}
