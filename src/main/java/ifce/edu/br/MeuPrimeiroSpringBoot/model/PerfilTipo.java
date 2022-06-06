package ifce.edu.br.MeuPrimeiroSpringBoot.model;

public enum PerfilTipo {
	ADMIN(1,"ADMIN"), ALUNO(2,"ALUNO");

	private long cod;
	private String desc;
	
	private PerfilTipo(long cod,String desc) {
		this.cod=cod;
		this.desc=desc;
	}

	public long getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
	
}
