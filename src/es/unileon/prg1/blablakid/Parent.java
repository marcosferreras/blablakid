package es.unileon.prg1.blablakid;
public class Parent{
	
	private String name;
	private Week week;
	private Kids kids;
	
	public Parent(String name,int number) throws BlaException {
		this.name=name;
		week = new Week(number);
	}

	public void addKids(Kids kids) throws BlaException {
		this.kids=kids;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}