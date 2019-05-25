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
			throw new BlaException("Error: You must indicate how parameter the maximum number of kids when you run the program");
		} 
	}
	/*
	 * Add a kid to the collection 
	 * @param A kid to add
	 */
	protected boolean add(Kid kid) throws BlaException {
		boolean saveCorrect = false;
		if(search(kid.getName()) != null){
			throw new BlaException("Error: The kid "+kid.getName()+" already exists");
		} else if (this.next >= kids.length){
			throw new BlaException("Error: The limit of "+kids.length+" has been reached. Try to remove a kid");
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
			throw new BlaException("Error: The kid "+name+" does not exist");
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
			if(name.toLowerCase().equals(kids[i].getName().toLowerCase())){
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
	
	public int getNext() {
		return this.next;
	}
	public int getLength() {
		return this.kids.length;
	}
	
	public Kid getKid(int i) {
		return this.kids[i];
	}
	public String checkStatus() {
		StringBuffer salida= new StringBuffer();
		salida.append("RIDES STATUS:");
		for(int i = 0; i < this.next; i++){
			salida.append(kids[i].checkStatus());
		}
		return salida.toString();
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
