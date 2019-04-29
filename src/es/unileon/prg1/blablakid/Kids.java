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
	
	protected boolean addKid(String name) {
		Boolean isSave = false;
		if(!checkKidExists(name) && this.siguiente < kids.length) {
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
			System.out.println("Error: El ni�o introducido no existe");
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