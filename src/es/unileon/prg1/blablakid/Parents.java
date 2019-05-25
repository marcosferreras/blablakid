package es.unileon.prg1.blablakid;

import java.util.Arrays;

public class Parents {
	int next;
	private Parent parent[];
	
	public Parents(int numParents) throws BlaException {
		if (isCorrectNumber(numParents)) {
			parent = new Parent[numParents];
			this.next=0;
		}
	}
	
	private boolean isCorrectNumber(int numParents) throws BlaException {
		boolean salida;
		if (numParents>0) salida=true;
		else {
			salida=false;
			throw new BlaException ("El numero introducido mayor que 0.");
		}
		return salida;
	}
	

	public Parent checkParentExists(String name) {
		boolean out=false;
		Parent aux=null;
		int i=0;
		while (i<this.next && !out) {
			if (parent[i].getName().equals(name)) {
				out=true;
				aux=this.parent[i];
			}
			else i++;
		}
		return aux;
	}
	
	public void add(Parent parent) throws BlaException{
		if (checkParentExists(parent.getName())!=null) throw new BlaException("That parent has allready exist");
		else {
			this.parent[next]=parent;
			this.next++;
		}
	}
	
	public void remove(String name) throws BlaException{
		Parent aux1, aux2;
		int i=0;
		aux2=checkParentExists(name);
		if (aux2!=null) {
			aux2=null;
			while(this.parent[i]!=null) i++;
			for (int j=i;j<next;j++) {
				aux1=this.parent[j+1];
				this.parent[j]=aux1;
			}
			this.parent[next-1]=null;
			next--;
		} else throw new BlaException("Error: That parent does not exist");
	}


	public void remove(String name,String start, String end,WeekDays weekDay) throws BlaException{
		Parent aux=checkParentExists(name);
		if (aux!=null) {
			aux.remove(start, end, weekDay);
		}else throw new BlaException("that parent dosent exist");
	}
	
	public void remove(String name,Ride ride,WeekDays weekDay) throws BlaException{
		Parent aux=checkParentExists(name);
		if (aux!=null) {
			aux.add(ride, weekDay);
		}else throw new BlaException("that parent dosent exist");
	}
}
	