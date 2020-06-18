/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.PreparedStatement;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;

/**
 *
 * @author SIAT
 */
public class AlunoDAO {
    
    private Connection con = null;
    
    public AlunoDAO(){
        try{
            con = ConnectionFactory.getConnetion();
        }
        catch (Exception ex) {
            System.err.println("Erro: "+ex);
        }
    }
    
    public boolean save(Aluno aluno){
        String sql = "INSERT INTO aluno (nome, endereco, telefone, matricula, situacao) "
                        + "values (?,?,?,?,?)";
        
        PreparedStatement stmt = null;
        
        try{
             stmt = (PreparedStatement) con.prepareStatement(sql);
             stmt.setString(1, aluno.getNome());             
             stmt.setString(2, aluno.getEndereco());
             stmt.setString(3, aluno.getTelefone());
             stmt.setInt(4, aluno.getMatricula());
             stmt.setString(5, aluno.getSituacao());
             
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
    public List<Aluno> findAll(){
        
        String sql = "SELECT * FROM aluno";
        
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
        List<Aluno> alunos = new ArrayList<>();
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement(sql); //Abriu a conexão
            rs = stmt.executeQuery(); //executa
            
            //usa para percorrer o resultSet
            while(rs.next())
            {
                Aluno aluno = new Aluno();
                aluno.setNome(rs.getString("nome"));
                alunos.add(aluno);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
         } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return alunos;
    }
}
