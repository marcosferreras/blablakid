package es.unileon.prg1.blablakid;
public class Kids{
	
	private Kid kids[];
	private int siguiente;
	
	protected Kids(int numKids) throws BlaException{
		this.isNumOfKidsValid(numKids);
		kids = new Kid[numKids];
		
	}
	
	
	/*
	 * Comprueba que el n�mero de ni�os sea correcto, de modo que no puede ser inferior a 1.
	 * @param Numero maximo de ni�os recibido en tiempo de ejecuci�n
	 * @return Nada
	 */
	protected void isNumOfKidsValid(int numKids) throws BlaException {
		if(numKids <= 0) {
			throw new BlaException("Error: El numero de niños pasado como parametro en la ejecucion no es valido. Introduca un valor positivo y mayor que 0. ");
		} 
	}
	
	protected boolean addKid(Kid kid) throws BlaException {
		/*Boolean isSave = false;
		if(!checkKidExists(kid.getName()) && this.siguiente < kids.length) {
			kids[this.siguiente] = kid;	
			this.siguiente++;
			isSave = true;
		}
		return isSave;*/
		boolean isSave = false;
		if(checkKidExists(kid.getName())){
			throw new BlaException("Error: El niño "+kid.getName()+" ya existe");
		} else if (this.siguiente >= kids.length){
			throw new BlaException("Error: Se ha alcanzado el número máximo de niños");
		} else {
			kids[this.siguiente] = kid;
			this.siguiente++;
			isSave = true;
		}
			
		return isSave;
	}
	
	
	protected boolean checkKidExists(String name) {
		Boolean checkExist = false;
		int i = 0;
		while((checkExist == false) && (i < this.siguiente) && kids[i]!= null) {
			if(name.equals(kids[i].getName())){
				checkExist = true;
			}
			i++;
		}
		
		return checkExist;
	}
	boolean removeKid(String name){
		Boolean checkDelete = false;
		if(checkKidExists(name)) {
			int i = 0;
			while((checkDelete == false) && (i < this.siguiente) && kids[i]!= null) {
				if(name.equals(kids[i].getName())){
					kids[i] = null;
					checkDelete = true;
					organizeKids(i);
					this.siguiente--;
				}
				i++;
			}
			
		} else {
			System.out.println("Error: El niño introducido no existe");
		}
		return checkDelete;
	}
	Kid searchKid(String name) {
		Kid kid = null;
		Boolean checkExist = false;
		int i = 0;
		while((checkExist == false) && (i <= this.siguiente) && kids[i]!= null) {
			if(name.equals(kids[i].getName())){
				kid = kids[i];
				checkExist = true;
			}
			i++;
		}
		return kid;
	}
	void organizeKids(int position){
		int i = 0;
		while((position+1) < kids.length){
			kids[position] = kids[position+1];
			position++;
		}
		kids[(kids.length)-1] = null;
	}
	public String toString(){
		StringBuffer salida= new StringBuffer();
		salida.append("KIDS:");
		for(int i = 0; i < this.siguiente; i++){
			salida.append("\n****** "+kids[i].toString()+" ******");
		}
		return salida.toString();	
	}
			
}
