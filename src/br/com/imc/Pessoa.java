package br.com.imc;
import java.io.Serializable;


//Interface Serializable indica que os objetos instanciados a partir da classe podem ser serializados.
public class Pessoa implements Serializable {

	private String nome;
	private double pc; // peso corporal
	private double alt; // altura em metros

	public Pessoa(String nome, double pc, double alt) {
		super();
		this.nome = nome;
		this.pc = pc;
		this.alt = alt;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPc() {
		return pc;
	}

	public void setPc(double pc) {
		this.pc = pc;
	}

	public double getAlt() {
		return alt;
	}

	public void setAlt(double alt) {
		this.alt = alt;
	}

	public double IMC() {
		return (getPc() / (getAlt() * getAlt()));
	}

	public String interpretaIMC() {
		double vlrIMC = IMC();
		if (vlrIMC < 18.5)
			return ("Peso baixo");
		else if (vlrIMC < 25.0)
			return ("Peso adequado");
		else if (vlrIMC < 30.0)
			return ("Sobrepeso");
		else
			return ("Obesidade");
	}

}
