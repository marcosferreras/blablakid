package es.unileon.prg1.blablakid;
public class Kids{
	
	int maxNumOfKids;
	private Kid kids[];
	private int siguiente;
	
	protected Kids(int numKids) throws BlaException{
		this.isNumOfKidsValid(numKids);
		kids = new Kid[numKids];
		
	}
	
	
	/*
	 * Comprueba que el número de niños sea correcto, de modo que no puede ser inferior a 1.
	 * @param Número máximo de niños recibido en tiempo de ejecución
	 * @return Nada
	 */
	protected void isNumOfKidsValid(int numKids) throws BlaException {
		if(numKids > 0) {
			maxNumOfKids = numKids;
		} else {
			throw new BlaException("Error: El número de niños pasado como parámetro en la ejecución no es válido. Introduca un valor positivo y mayor que 0. ");
		}
	}
	
	protected boolean addKid(String name) {
		Boolean isSave = false;
		if(!checkKidExists(name) && this.siguiente <= maxNumOfKids) {
			kids[this.siguiente] = new Kid(name);	
			this.siguiente++;
			isSave = true;
		}
		return isSave;
	}
	
	
	protected boolean checkKidExists(String name) {
		Boolean checkExist = false;
		int i = 0;
		while((checkExist == false) && (i <= this.siguiente) && kids[i]!= null) {
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
			while((checkDelete == false) && (i <= this.siguiente) && kids[i]!= null) {
				if(name.equals(kids[i].getName())){
					kids[i] = null;
					checkDelete = true;
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
}