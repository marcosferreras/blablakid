package es.unileon.prg1.blablakid;
public class Kids{
	
	private Kid kids[];
	private int next;
	
	public Kids(int numKids) throws BlaException{
		this.isNumOfKidsValid(numKids);
		kids = new Kid[numKids];
		
	}
	
	
	/*
	 * Comprueba que el n�mero de ni�os sea correcto, de modo que no puede ser inferior a 1.
	 * @param Numero maximo de ni�os recibido en tiempo de ejecuci�n
	 * @return Nada
	 */
	private void isNumOfKidsValid(int numKids) throws BlaException {
		if(numKids <= 0) {
			throw new BlaException("Error: El numero de niños pasado como parametro en la ejecucion no es valido. Introduca un valor positivo y mayor que 0. ");
		} 
	}
	
	protected boolean add(Kid kid) throws BlaException {
		/*Boolean isSave = false;
		if(!checkKidExists(kid.getName()) && this.next < kids.length) {
			kids[this.next] = kid;	
			this.next++;
			isSave = true;
		}
		return isSave;*/
		boolean isSave = false;
		if(checkExists(kid.getName())){
			throw new BlaException("Error: El niño "+kid.getName()+" ya existe");
		} else if (this.next >= kids.length){
			throw new BlaException("Error: Se ha alcanzado el número máximo de niños");
		} else {
			kids[this.next] = kid;
			this.next++;
			isSave = true;
		}
			
		return isSave;
	}
	
	
	protected boolean checkExists(String name) {
		Boolean checkExist = false;
		int i = 0;
		while((checkExist == false) && (i < this.next) && kids[i]!= null) {
			if(name.equals(kids[i].getName())){
				checkExist = true;
			}
			i++;
		}
		
		return checkExist;
	}
	public void remove(String name)throws BlaException{
		Boolean isDelete = false;
		if(checkExists(name) == false) {
			throw new BlaException("Error: El niño introducido no existe");
		} else {
			int i = 0;
			while((isDelete == false) && (i < this.next) && kids[i]!= null) {
				if(name.equals(kids[i].getName())){
					kids[i] = null;
					isDelete = true;
					organize(i);
					this.next--;
				}
				i++;
			}
		}
	}
	public Kid search(String name) {
		Kid kid = null;
		Boolean exist = false;
		int i = 0;
		while((exist == false) && (i < this.next) && kids[i]!= null) {
			if(name.equals(kids[i].getName())){
				kid = kids[i];
				exist = true;
			}
			i++;
		}
		return kid;
	}
	private void organize(int position){
		while((position+1) < kids.length){
			kids[position] = kids[position+1];
			position++;
		}
		kids[(kids.length)-1] = null;
	}
	public String toString(){
		StringBuffer salida= new StringBuffer();
		salida.append("KIDS:");
		for(int i = 0; i < this.next; i++){
			salida.append("\n****** "+kids[i].toString()+" ******");
		}
		return salida.toString();	
	}
			
}
