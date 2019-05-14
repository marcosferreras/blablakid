package es.unileon.prg1.blablakid;
public class Kids{
	
	private Kid kids[];
	private int next;
	
	public Kids(int numKids) throws BlaException{
		this.isNumOfKidsValid(numKids);
		kids = new Kid[numKids];
		
	}
	private void isNumOfKidsValid(int numKids) throws BlaException {
		if(numKids <= 0) {
			throw new BlaException("Error: El numero de niños pasado como parametro en la ejecucion no es valido. Introduca un valor positivo y mayor que 0. ");
		} 
	}
	/*
	 * Add a kid to the collection 
	 * @param A kid to add
	 */
	protected boolean add(Kid kid) throws BlaException {
		boolean saveCorrect = false;
		if(search(kid.getName()) != null){
			throw new BlaException("Error: El niño "+kid.getName()+" ya existe");
		} else if (this.next >= kids.length){
			throw new BlaException("Error: Se ha alcanzado el número máximo de niños");
		} else {
			kids[this.next] = kid;
			saveCorrect = true;
			this.next++;
		}
		return saveCorrect;
	}
	/*
	 * Remove a Kid from the collection
	 * @param Name of the kid to remove
	 */
	public void remove(String name)throws BlaException{
		Kid kid = search(name);
		if(kid == null) {
			throw new BlaException("Error: El niño introducido no existe");
		} else {
					organize(position(kid));
					this.next--;				
		}
	}
	private int position(Kid kid) {
		boolean exist = false;
		int i = 0;
		while((exist == false) && (i < this.next)) {
			if(kid.getName().equals(this.kids[i].getName())){
				exist = true;
			}
			i++;
		}
		return (i-1);
	}
	/*
	 * Search a kid in the collection
	 * @param Name of the kid to search
	 * @return A kid object
	 */
	public Kid search(String name){
		Kid kid = null;
		Boolean exist = false;
		int i = 0;
		while((exist == false) && (i < this.next)) {
			if(name.equals(kids[i].getName())){
				kid = kids[i];
				exist = true;
			}
			i++;
		}
		return kid;
	}
	private void organize(int position){
		while(position < this.next){
			kids[position] = kids[position+1];
			position++;
		}
		kids[this.next-1] = null;
	}
	public String toString(){
		StringBuffer salida= new StringBuffer();
		salida.append("KIDS:");
		for(int i = 0; i < this.next; i++){
			salida.append(kids[i].toString());
		}
		return salida.toString();	
	}
			
}
