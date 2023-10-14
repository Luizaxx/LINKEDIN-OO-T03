package Model;

public class Usuario extends Geral {
    
    private int dN;// dia de nascimento
	private int mN;// mes de nascimento
	private int aN;// ano de nascimento
	private String areaA;
	private String instituição;

	public Usuario(String nome, int cpf, int cnpj, String Escolaridade, int dN, int mN, int aN, String areaA,
			String instituição) {
		super(nome, cpf, cnpj, Escolaridade);
		this.dN = dN;
		this.mN = mN;
		this.aN = aN;
		this.areaA = areaA;
		this.instituição = instituição;
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
