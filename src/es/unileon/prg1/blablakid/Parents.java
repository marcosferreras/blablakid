package es.unileon.prg1.blablakid;

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
	
	public int getNext() {
		return next;
	}

	public void setNext(int numOfParents) {
		this.next = numOfParents;
	}

	public Parent getParent(int number) {
		return parent[number];
	}

	public boolean checkParentExists(String name) {
		boolean salida=false;
		int i=0;
		while (i<this.next) {
			if (parent[i].getName().equals(name)) {
				salida=true;
			}
			i++;
		}
		return salida;
	}
	
	public void add(Parent parent) throws BlaException{
		if (checkParentExists(parent.getName())) throw new BlaException("That parent has allready exist");
		else {
			this.parent[next]=parent;
			this.next++;
		}
	}
	
	public void remove(String name) throws BlaException{
		int i=0;
		if (checkParentExists(name)) {
			while(this.parent[i].getName()!=name) i++;
			this.parent[i]=null;
			Parent aux;
			for (int j=i;j<next;j++) {
				aux=this.parent[j+1];
				this.parent[j]=aux;
			}
			this.parent[next]=null;
			next--;
		} else throw new BlaException("Error: That parent does not exist");
	}
}
	