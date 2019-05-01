package es.unileon.prg1.blablakid;
public class Kid{
	String name;
	Activities activities;
	protected Kid (String name){
		this.name = name;
		activities = new Activities();
	}
	String getName(){
		return this.name;
	}
	
	public String toString(){
		return this.name;
	}
}
