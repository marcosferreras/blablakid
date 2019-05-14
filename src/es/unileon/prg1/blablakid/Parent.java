package es.unileon.prg1.blablakid;
public class Parent{
	
	private String name;
	private Week week;
	private Kids kids;
	
	public Parent(String name,Kids kids) throws BlaException {
		this.name=name;
		this.kids=kids;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}