package model;

import java.util.ArrayList;
import java.util.Collection;

public class Aluno extends Pessoa {
        private String Nome;
        private String Endereco;
        private String Telefone;
        private Curso Curso; //Vincula o curso
        private int matricula;
        private String situacao;
        
        public String getNome() {
        return Nome;
    }

        public void setNome(String Nome) {
            this.Nome = Nome;
        }

        public String getEndereco() {
            return Endereco;
        }

        public void setEndereco(String Endereco) {
            this.Endereco = Endereco;
        }

        public String getTelefone() {
            return Telefone;
        }

        public void setTelefone(String Telefone) {
            this.Telefone = Telefone;
        }
        
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
        
        public Curso getCurso() {
            return Curso;
        }
        
        public void setCurso(Curso Curso) {
            this.Curso = Curso;
        }
        
        public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
        
        public boolean AlunoAtivo (int matricula){
            
            Boolean retorno = false;
            if(matricula == 11712313 || matricula == 11712315 )
            {
                retorno = true;
            }

            return retorno;
        }
        
        public boolean ConsultarSituacaoAluno(String aluno,int matricula ) {
            
            Boolean retorno = false;
            if(aluno == "Maria" && matricula == 11712313)
            {
                retorno = true; //Aprovado
            }
            
            if(aluno == "João" && matricula == 11712315)
            {
                retorno = true; //Aprovado
            }
            
            return retorno;
        }
        
        public boolean matricularAlunoCurso(int curso, int matricula){
            Boolean retorno = false;
            
            if(curso == 2 && matricula == 11712313)
            {
                retorno = true; //matriculado
            }
            
           return retorno; 
        }
        
}
