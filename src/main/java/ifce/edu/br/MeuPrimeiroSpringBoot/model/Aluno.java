package ifce.edu.br.MeuPrimeiroSpringBoot.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "tbl_aluno")
public class Aluno {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name = "nome_aluno")
	private String nome;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "rg")
	private String rg;
	
	@Column (name = "cpf")
	private String cpf;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	@ManyToOne
	Sede sede;
	
	@OneToMany
	private Collection<Telefone> telefone = new ArrayList<Telefone>();
	
	@ManyToMany
	private Collection<Extracurricular> atividadesec = new ArrayList<Extracurricular>();
	
	
	public Collection<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(Collection<Telefone> telefone) {
		this.telefone = telefone;
	}
	
	@Column(name = "ira_aluno", length = 30, scale = 2 , precision = 2 )
	private Double ira;
	
	//Large Objects
	@Lob
	private byte [] fotografia ;
	
	@Temporal(TemporalType.DATE)
	private Calendar nascimento;
	
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	public byte[] getFotografia() {
		return fotografia;
	}
	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}
	public Double getIra() {
		return ira;
	}
	public void setIra(Double ira) {
		this.ira = ira;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Collection<Extracurricular> getAtividadesec() {
		return atividadesec;
	}
	public void setAtividadesec(Collection<Extracurricular> atividadesec) {
		this.atividadesec = atividadesec;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
