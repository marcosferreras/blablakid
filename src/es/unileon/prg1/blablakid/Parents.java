package es.unileon.prg1.blablakid;

public class Parents {
	int numOfParents;
	private Parent parent[];
	
	private Parents(int numParents) throws BlaException {
		if (isCorrectNumber(numParents)) {
			parent = new Parent[numParents];
			this.numOfParents=1;
		}
	}
	
	private boolean isCorrectNumber(int numParents) throws BlaException {
		boolean salida;
		if (numParents>=0) salida=true;
		else {
			salida=false;
			throw new BlaException ("El numero introducido mayor que 0.");
		}
		return salida;
	}
	
	public boolean checkParentExists(String name) {
			boolean salida=false;
		int i=0;
		do {
			if (parent[i].getName()==name) salida=true;
			i++;
		}while ((salida==false) && (parent[i]!=null));
		return salida;
	}
	
	public void add(Parent parent) throws BlaException{
		int i=0;
		while ( this.parent[i] != null) i++;
		if (checkParentExists(parent.getName())) throw new BlaException("Esa persona ya existe");
		else this.parent[i]=parent;
	}
	
	public void deleateParent(Parent parent) throws BlaException{
		int i=0;
		if (checkParentExists(parent.getName())==true) {
			while(this.parent[i].getName()!=parent.getName()) i++;
			this.parent[i]=null;
			reorganice(i);
		} else throw new BlaException("Esa persona no existe");
	}
	
	private void reorganice(int number) {
		int i=0;
		while (this.parent[i]!=null) i++;
		Parent aux;
		for (int j=number;j<i;j++) {
			aux=this.parent[j+1];
			this.parent[j]=aux;
		}
		this.parent[i]=null;
	}
}
	