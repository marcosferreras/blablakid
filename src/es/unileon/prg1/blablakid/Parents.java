package es.unileon.prg1.blablakid;

public class Parents {
	int maxNumOfParents;
	private Parent parent[];
	
	protected Parents(int numParents) throws BlaException {
		if (isCorrectNumber(numParents)) parent = new Parent[numParents];
	}
	
	protected boolean isCorrectNumber(int numParents) throws BlaException {
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
		}while ((salida==false) && (parent[i]!=null) && (i<this.maxNumOfParents));
		return salida;
	}
	
	public boolean addParent(Parent parent) {
		int i=0;
		boolean salida=true;
		while ( this.parent[i] != null) i++;
		if (i>maxNumOfParents) salida=false;
		else this.parent[i]=parent;
		return salida;
	}
	
	public boolean deleateParent(Parent parent) throws BlaException{
		boolean salida=false;
		int i=0;
		if (checkParentExists(parent.getName())==true) {
			while(this.parent[i].getName()!=parent.getName()) i++;
			this.parent[i]=null;
			reorganice(i);
			salida=true;
		} else throw new BlaException("Esa persona no existe");
		return salida;
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
	