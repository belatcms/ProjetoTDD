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
import model.Professor;

/**
 *
 * @author SIAT
 */
public class ProfessorDAO {
    
    private Connection con = null;
    
    public ProfessorDAO(){
        try{
            con = ConnectionFactory.getConnetion();
        }
        catch (Exception ex) {
            System.err.println("Erro: "+ex);
        }
    }
    
    public boolean save(Professor prof){
        String sql = "INSERT INTO professor (nome, endereco, telefone, titulacao)"
                        + "values (?,?,?,?)";
        
        PreparedStatement stmt = null;
        
        try{
             stmt = (PreparedStatement) con.prepareStatement(sql);
             stmt.setString(1, prof.getNome());             
             stmt.setString(2, prof.getEndereco());
             stmt.setString(3, prof.getTelefone());
             stmt.setString(4, prof.getTitulacao());
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
    public List<Professor> findAll(){
        
        String sql = "SELECT * FROM professor";
        
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<Professor> professores = new ArrayList<>();
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement(sql); //Abriu a conexão
            rs = stmt.executeQuery(); //executa
            
            //usa para percorrer o resultSet
            while(rs.next())
            {
                Professor prof = new Professor();
                prof.setNome(rs.getString("nome"));
                professores.add(prof);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
         } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return professores;
    }
}
