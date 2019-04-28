package es.unileon.prg1.blablakid;
public class Parent{
	private String name;
	//private Week Week;
	private String hijo[];
	private int n_hijos;
	private int n_viajes;
	
	protected Parent(String name,int n_hijos,int n_viajes, String hijo[]) throws BlaException {
		this.name=name;
		if (isCorrectNumberHijos(n_hijos)) {
			for (int i=0;i<n_hijos;i++) {
				this.hijo[i]=hijo[i];
			}
		}
		if (isCorrectNumberViajes(n_viajes)) {
			this.n_viajes=n_viajes;
		}
	}
	
	protected boolean isCorrectNumberHijos(int number) throws BlaException {
		boolean salida=false;
		if (number>0) salida=true;
		else throw new BlaException("El numero de hijos ha de ser mayor de 0.");
		return salida;
	}
	
	protected boolean isCorrectNumberViajes(int number) throws BlaException {
		boolean salida=false;
		if (number>0) salida=true;
		else throw new BlaException("El numero de viajes ha de ser mayor de 0.");
		return salida;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getHijo(int number) {
		return hijo[number];
	}

	public void setHijo(String hijo, int numero) {
		this.hijo[numero] = hijo;
	}

	public int getN_hijos() {
		return n_hijos;
	}

	public void setN_hijos(int n_hijos) {
		this.n_hijos = n_hijos;
	}

	public int getN_viajes() {
		return n_viajes;
	}

	public void setN_viajes(int n_viajes) {
		this.n_viajes = n_viajes;
	}
	
	
}