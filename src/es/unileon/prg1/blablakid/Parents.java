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
	

	public Parent checkParentExists(String name) {
		boolean out=false;
		Parent aux=null;
		int i=0;
		while (i<this.next && !out) {
			if (parent[i].getName().toLowerCase().equals(name.toLowerCase())) {
				out=true;
				aux=this.parent[i];
			}
			else i++;
		}
		return aux;
	}
	
	public void add(Parent parent) throws BlaException{
		if (checkParentExists(parent.getName())!=null) throw new BlaException("Error:That parent has allready exist");
		else {
			this.parent[next++]=parent;
		}
	}
	
	public void remove(String name) throws BlaException{
		Parent aux1, aux2;
		int j=0;
		aux2=checkParentExists(name);
		if (aux2!=null) {
			while(this.parent[j]!=null) {
				if (aux2.getName()==this.parent[j].getName()) {
					this.parent[j]=null;
				}else j++;
			}
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
	