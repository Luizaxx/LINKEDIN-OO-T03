package Model;

public class UsuarioModel{



	private String nome;
	private int cpf;
	private String escolaridade;
    private int dN;// dia de nascimento
	private int mN;// mes de nascimento
	private int aN;// ano de nascimento
	private String areaA;
	private String instituição;

	public UsuarioModel(String nome, int cpf, int cnpj, String escolaridade, int dN, int mN, int aN, String areaA,
			String instituição) {
		this.nome = nome;
		this.cpf = cpf;
		this.escolaridade = escolaridade;
		this.dN = dN;
		this.mN = mN;
		this.aN = aN;
		this.areaA = areaA;
		this.instituição = instituição;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getnEscolaridade() {
		return escolaridade;
	}
    
	public void setnEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public int getdN() {
		return dN;
	}

	public void setdN(int dN) {
		this.dN = dN;
	}

	public int getmN() {
		return mN;
	}

	public void setmN(int mN) {
		this.mN = mN;
	}

	public int getaN() {
		return aN;
	}

	public void setaN(int aN) {
		this.aN = aN;
	}

	public String getAreaA() {
		return areaA;
	}

	public void setAreaA(String areaA) {
		this.areaA = areaA;
	}

	public String getInstituição() {
		return instituição;
	}

	public void setInstituição(String instituição) {
		this.instituição = instituição;
	}

}
