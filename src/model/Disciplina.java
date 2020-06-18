package model;

public class Disciplina {

	private int codigo_disciplina;
	private String descricao;
	private int carga_horaria;
	private String ementa;
	private String bibliografia;
	private boolean pre_requesitos;

	public int getCodigo_disciplina() {
		return codigo_disciplina;
	}

	public void setCodigo_disciplina(int codigo_disciplina) {
		this.codigo_disciplina = codigo_disciplina;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(int carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public String getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	public boolean getPre_requesitos() {
		return pre_requesitos;
	}

	public void setPre_requesitos(boolean pre_requesitos) {
		this.pre_requesitos = pre_requesitos;
	}

        public boolean CancelarDisciplina(Disciplina disciplinas){
            
            Boolean retorno = false;
            
            if(disciplinas.pre_requesitos == false)
            {
                retorno = true; //pode cancelar
            }
            
           return retorno; 
        }
        
        public boolean VerificarMatriculaAlunoNaDisciplina(int codigo_disciplina, int matricula ){
            
            Boolean retorno = false;
            
            if(codigo_disciplina == 10058 && matricula == 11712313)
            {
                retorno = true; //Aluno Matriculado na disciplina
            }
            
            if(codigo_disciplina == 10060 && matricula == 11712315)
            {
                retorno = true; //Aluno Matriculado na disciplina
            }
            
           return retorno; 
        }
}
