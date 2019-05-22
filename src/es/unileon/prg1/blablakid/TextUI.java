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
		    showMenu();
		    number= Teclado.readInteger();//recogemos ese valor en int numero
			selectOption(number);
			} catch (BlaException e) {
				System.out.println(e.getMessage());
				}
		}while (number != 0);

	}
	
	public void showMenu() {
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
	
	}
	public void selectOption(int number)throws BlaException{

			switch (number){
				case 1: 
						this.blablakid.add(askKid());
						
					break;
				case 2: removeKid();
					break;
				case 3: askParent(); //igual que el askkid (mas el add)
					break;
				case 4: removeParent();
					break;
				case 5: //askActivity();
					break;
				case 6: removeActivity();
					break;
				case 7: addRide();
					break;
				case 8: removeRide();
					break;
				case 9: showSummary();
					break;
				case 10: checkStatus();
					break;
				case 0:
					break;

				default:
					System.out.println("Error: el número introducido no es correcto, introduzca un número del menú");

			}
	}


	public Kid askKid()throws BlaException{
		String name;
		System.out.println ("Name the kid to add:");
		name = Teclado.readString();
		return new Kid(name);
	}

	public void removeKid() throws BlaException{
		String name;
		System.out.println ("Name the kid to remove:\n");
		name = Teclado.readString();
		blablakid.removeKid(name);
	}
	public void askParent()throws BlaException{ //pregunta por todos los datos del parent
		String name;
		int numberkids;
		int numberrides;
		String kidname;
		Kids kids;
		System.out.println ("Name of the parent to add:");
		name = Teclado.readString();
		//blablakid.addParent(new Parent(teclado.readString()); 
	
		System.out.println ("How many kids does Pedro have?:");
		numberkids = Teclado.readInteger();
		kids = new Kids (numberkids);
		
		
		System.out.println ("How many rides can Pedro make per day?:");
		numberrides = Teclado.readInteger();
		
		for(int i=0; i<numberkids; i++) {
			System.out.println ("Who is's kid number"+i+"?");
			kidname = Teclado.readString();
			kids.add(new Kid (kidname));
		}
		
	//blablakid.add(new Parent(name,//arrayhijos));
	}
	
	public void removeParent(){
		String name;
		System.out.println ("Name of the parent to remove:\n");
		name = Teclado.readString();
		//blablakid.removeParent????
	}

	/*public void askActivity(){
		String name;
		String place;
		int hour, minute;
		
		blablakid.add(new Activity(//activity y namekid));
		
		System.out.println ("Name of the activity:");
		name = Teclado.readString();
		System.out.println ("Where does the activity Baloncesto takes place?");
		place = Teclado.readString();
		System.out.println ("Day of the week for the activity:\nInsert the number of the day of the week:\n0 -Monday / 1-Tuesday / 2 -Wednesday / 3 -Thursday / 4 -Friday");
		int number = Teclado.readInteger();
		number = 0;
		switch(number){
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
		}
		System.out.println ("Name of the kid taking the activity:");
		name = Teclado.readString();
		System.out.println ("When does the activity start? \n Insert hour:");
		hour = Teclado.readInteger();
		System.out.println ("Insert minute:");
		minute = Teclado.readInteger();
	}*/
	
	public void removeActivity() {
		String name, activity;
		int day;
		System.out.println ("Name of the kid taking the activity to remove: ");
		name = Teclado.readString();
		System.out.println ("Name of the activity to remove: ");
		activity = Teclado.readString();
		System.out.println ("Insert the number of the day of the week:\n0 -Monday / 1-Tuesday / 2 -Wednesday / 3 -Thursday / 4 -Friday ");
		day = Teclado.readInteger();
	}
	
	public void addRide() {
		String nameparent, activity, namekid, startplace, endplace;
		int starthour, startminute, endhour, endminute, day;
		System.out.println ("Name of the parent in charge of the ride:");
		nameparent = Teclado.readString();
		System.out.println ("Name of the activity of the ride:");
		activity = Teclado.readString();
		System.out.println ("Name of the kid taking the activity:");
		namekid = Teclado.readString();
		System.out.println ("Where does the ride start?");
		startplace = Teclado.readString();
		System.out.println ("Where does the ride end?");
		endplace = Teclado.readString();
		System.out.println ("When does the ride start?\nInsert hour:");
		starthour = Teclado.readInteger();
		System.out.println ("Insert minute:");
		startminute = Teclado.readInteger();
		System.out.println ("When does the ride end?\nInsert hour:");
		endhour = Teclado.readInteger();
		System.out.println ("Insert minute:");
		endminute = Teclado.readInteger();
		System.out.println ("Day of the week for the ride:\nInsert the number of the day of the week:\n0 -Monday / 1-Tuesday / 2 -Wednesday / 3 -Thursday / 4 -Friday");
		day = Teclado.readInteger();
	}
	
	public void removeRide() {
		String parent, startplace, endplace;
		int day;
		System.out.println ("Name of the parent in charge of the ride:");
		parent = Teclado.readString();
		System.out.println ("Day of the week for the ride:\nInsert the number of the day of the week:\n0 -Monday / 1-Tuesday / 2 -Wednesday / 3 -Thursday / 4 -Friday");
		day = Teclado.readInteger();
		System.out.println ("");
		startplace = Teclado.readString();
		System.out.println ("");
		endplace = Teclado.readString();
	}
	
	public void showSummary() {
	//La opci�n de mostrar el resumen muestra por pantalla la informaci�n del estado de la aplicaci�n en todo momento y que coincide con lo que estamos mostrando cada vez que mostramos el men� principal
	}
	public void checkStatus() {
	//Esta opci�n deber� mostrar informaci�n sobre los trayectos que faltan por cubrir.
	}
}



