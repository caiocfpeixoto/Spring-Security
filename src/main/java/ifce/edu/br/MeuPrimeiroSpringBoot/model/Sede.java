package ifce.edu.br.MeuPrimeiroSpringBoot.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_sede")
public class Sede {
	@Id
	@GeneratedValue
	private Long id;
	
	private String nomesede;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomesede() {
		return nomesede;
	}

	public void setNomesede(String nomesede) {
		this.nomesede = nomesede;
	}
	
	

}
