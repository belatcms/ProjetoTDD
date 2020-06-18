package model;

import java.util.ArrayList;
import java.util.Collection;

public class Curso {

	private int codigo_curso;
	private String descricao;
	private String coordenador_curso;
        
	public int getCodigo_curso() {
		return codigo_curso;
	}

	public void setCodigo_curso(int codigo_curso) {
		this.codigo_curso = codigo_curso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCoordenador_curso() {
		return coordenador_curso;
	}

	public void setCoordenador_curso(String coordenador_curso) {
		this.coordenador_curso = coordenador_curso;
	}

        public boolean CursoDisponivel (int codigo_curso){
            
           Boolean retorno = false;
            
            if(codigo_curso == 2 || codigo_curso == 5 )
            {
                retorno = true; //Disponível
            }
            
           return retorno; 
        }
        
}
