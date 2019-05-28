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
			throw new BlaException ("Error:The number must be greater than zero");
		}
		return salida;
	}
	
	public void removeKid(String name) throws BlaException{
		for (int i=0;i<this.next;i++) {
			if(parent[i].find(name)!=-1) this.parent[i].remove(name);
		}
	}
	public int search(String name) {
		int i=0,out=-1;
		while (i<this.next && -1==out) {
			if (parent[i].getName().toLowerCase().equals(name.toLowerCase())) {
				out=i;
			}
			i++;
		}
		return out;
	}
	
	public Parent getParent(int number) {
		return this.parent[number];
	}
	
	public void add(Parent parent) throws BlaException{
		if (search(parent.getName())!=-1) throw new BlaException("Error:That parent has allready exist");
		else {
			this.parent[next++]=parent;
		}
	}
	
	public void remove(String name) throws BlaException{
		Parent aux1;
		int j=search(name);
		if (j!=-1) {
			for (int i=j;i<=this.next;i++) {
				aux1=this.parent[i+1];
				this.parent[i]=this.parent[i+1];
				this.parent[i]=aux1;
			}
			next--;
		} else throw new BlaException("Error: That parent does not exist");
	}
	
	public String toString() {
		StringBuffer output= new StringBuffer();
		output.append("\nPARENTS:");
		for (int i=0;i<this.next;i++) {
			output.append(parent[i].toString());
		}
		return output.toString();
	}
}
	