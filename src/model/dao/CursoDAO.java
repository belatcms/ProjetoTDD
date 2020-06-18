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
import model.Curso;

/**
 *
 * @author SIAT
 */
public class CursoDAO {
    
    private Connection con = null;
    
    public CursoDAO(){
        con = ConnectionFactory.getConnetion();
    }
    
    public boolean save(Curso curso){
        String sql = "INSERT INTO curso (descricao, coordenador_curso)"
                        + "values (?,?)";
        
        PreparedStatement stmt = null;
        
        try{
             stmt = (PreparedStatement) con.prepareStatement(sql);
             stmt.setString(1, curso.getDescricao());             
             stmt.setString(2, curso.getCoordenador_curso());
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
    public List<Curso> findAll(){
        
        String sql = "SELECT * FROM curso";
        
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<Curso> cursos = new ArrayList<>();
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement(sql); //Abriu a conexão
            rs = stmt.executeQuery(); //executa
            
            //usa para percorrer o resultSet
            while(rs.next())
            {
                Curso curso = new Curso();
                curso.setDescricao(rs.getString("descricao"));
                curso.setCoordenador_curso(rs.getString("coordenador_curso"));
                cursos.add(curso);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
         } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return cursos;
    }
}
