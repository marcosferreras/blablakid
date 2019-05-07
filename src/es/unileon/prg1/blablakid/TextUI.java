package es.unileon.prg1.blablakid;

public class TextUI {
	private Blablakid blablakid;//esta declarado ya para todos los blablakid (todos sus metodos)
	public TextUI (Blablakid blablakid) {
		this.blablakid = blablakid;
	}
	
	protected void start() {
		//TODO Menú
		int number = 0;
		String name;
		Teclado teclado = new Teclado ();

		do{
		     try{

			System.out.println ("---------");	
			System.out.println ("Blablakid");
			System.out.println ("---------");

			System.out.println ("Select an option:");

			System.out.println ("1 - Add kid"); 
			System.out.println ("2 - Remove kid"); 
			System.out.println ("3 - Add parent");
			System.out.println ("4 - Remove parent");
			System.out.println ("5 - Add activity");
			System.out.println ("6 - Remove activity");
			System.out.println ("7 - Add ride");
			System.out.println ("8 - Remove ride");
			System.out.println ("9 - Show summary");
			System.out.println ("10 -Check status");

			System.out.println ("0 - Exit");
			number= teclado.readInteger();//recogemos ese valor en int numero	
			selectOption(number);
			} catch (BlaException e) {
				System.out.println(e.getMessage());
				}
		}while (number != 0);

	}
	public void selectOption(int number)throws BlaException{

			switch (number){
				case 1: 
					this.blablakid.add(askKid());
					
					break;
				case 2: removeKid();
					break;
				case 3: askParent();
					break;
				case 4: removeParent();
					break;
				case 5: askActivity();
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9: 
					break;
				case 10:
					break;
				case 0:
					break;

				default:
					System.out.println("Error: el número introducido no es correcto, introduzca un número del menú");

			}
	}
	public Kid askKid(){
		String name;
		//TODO falta volver a pedir si está vacio
		System.out.println ("Name the kid to add:\n");
		name = Teclado.readString()));//me crea un niño con el nombre introducido  (constructor de Kid)
		return new Kid(name);
	}
	
	public void removeKid(){
		System.out.println ("Name the kid to remove:\n");
		blablakid.removeKid(teclado.readString());
		System.out.println ("Remove kid error: Kid "+???+ not found:\n");//Error
	}
	public void askParent(){ //pregunta por todos los datos del parent
		String name;
		System.out.println ("Name of the parent to add:");
		name = Teclado.readString()));
		//blablakid.addParent(new Parent(teclado.readString())); 
	
		System.out.println ("How many kids does Pedro have?:");
		System.out.println ("How many rides can Pedro make per day?:");
		System.out.println ("Who is"+????+"'s kid number"+??"?:");
	}
	
	public void removeParent(){
		System.out.println ("Name of the parent to remove:\n");
	}

	public void askActivity(){
		System.out.println ("Name of the activity:");
		System.out.println ("Where does the activity Baloncesto takes place?");
		System.out.println ("Day of the week for the activity:\nInsert the number of the day of the week:\n0 -Monday / 1-Tuesday / 2 -Wednesday / 3 -Thursday / 4 -Friday");
		switch(){
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
		}
		System.out.println ("Name of the kid taking the activity:");
		System.out.println ("When does the activity start? \n Insert hour:");
		System.out.println ("Insert minute:");
}
