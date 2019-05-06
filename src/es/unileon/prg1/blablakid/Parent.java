package es.unileon.prg1.blablakid;
public class Parent{
	
	private String name;
	private Week Week;
	private Kid hijo[];
	
	public Parent(String name,Kid hijo[]) throws BlaException {
		this.name=name;
		this.hijo=hijo;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Kid getHijo(int number) {
		return hijo[number];
	}

	public void setHijo(Kid hijo, int numero) {
		this.hijo[numero] = hijo;
	}
}