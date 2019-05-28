package es.unileon.prg1.blablakid;

public class TextUI {
	private Blablakid blablakid;//esta declarado ya para todos los blablakid (todos sus metodos)
	public TextUI (Blablakid blablakid) {
		this.blablakid = blablakid;
	}
	
	protected void start() {
		int number = 0;
		do{
		    try{
		    showMenu();
		    number= Teclado.readInteger();//recogemos ese valor en int numero
			selectOption(number);
			showSummary();
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
					addKid();	
					break;
				case 2: 
					removeKid();
					break;
				case 3: 
					addParent(); //igual que el askkid (mas el add)
					break;
				case 4: 
					removeParent();
					break;
				case 5: 
					addActivity();
					break;
				case 6: 
					removeActivity();
					break;
				case 7: 
					addRide();
					break;
				case 8: 
					removeRide();
					break;
				case 9: 
					showSummary();
					break;
				case 10: 
					checkStatus();
					break;
				case 0:
					break;
				default:
					System.out.println("Error: el número introducido no es correcto, introduzca un número del menú");

			}
	}


	public void addKid()throws BlaException{
		String name;
		System.out.println ("Name the kid to add:");
		name = readString();
		this.blablakid.add(new Kid(name));
	}

	public void removeKid() throws BlaException{
		String name;
		System.out.println ("Name the kid to remove:\n");
		name = readString();
		blablakid.removeKid(name);
	}
	public void addParent()throws BlaException{ //pregunta por todos los datos del parent
		String parentName;
		int numberKids;
		int numberRides;
		String kidName;
		Kids kids;
		Parent parent;
		System.out.println ("Name of the parent to add:");
		parentName = readString();
		System.out.println ("How many kids does Pedro have?:");
		numberKids = Teclado.readInteger();
		kids = new Kids (numberKids);
		System.out.println ("How many rides can Pedro make per day?:");
		numberRides = Teclado.readInteger();
		parent = new Parent(parentName, numberRides, numberKids);
		
		for(int i=0; i<numberKids; i++) {
			System.out.println ("Who is "+parentName+"'s kid number"+i+"?");
			kidName = readString();
			kids.add(new Kid (kidName)); 
		}
		
		this.blablakid.add(parent, kids);
	
	}
	
	public void removeParent() throws BlaException{
		String name;
		System.out.println ("Name of the parent to remove:");
		name = readString();
		this.blablakid.removeParent(name);
	}

	public void addActivity() throws BlaException{
		String nameKid, nameActivity, place;
		WeekDays day = null;
		Time start, end;
		
		System.out.println ("Name of the activity:");
		nameActivity = readString();
		System.out.println ("Where does the activity "+nameActivity+" takes place?");
		place = readString();
		day = askWeekDay();
		System.out.println ("Name of the kid taking the activity:");
		nameKid = readString();
		System.out.println ("When does the activity start?");
		start = askTime();
		System.out.println ("When does the activity end?");
		end = askTime();
		this.blablakid.add(new Activity(nameActivity, place, day, start, end), nameKid);
	}
	
	public void removeActivity() throws BlaException {
		String nameKid, activityName;
		WeekDays day;
		System.out.println ("Name of the kid taking the activity to remove: ");
		nameKid = readString();
		System.out.println ("Name of the activity to remove: ");
		activityName = readString();
		day = askWeekDay();
		this.blablakid.removeActivity(nameKid, activityName, day);	
	}
	
	public void addRide() throws BlaException {
		String parentName, activityName, kidName, startPlace, endPlace;
		Time start, end;
		WeekDays day;
		Ride ride;
		System.out.println ("Name of the parent in charge of the ride:");
		parentName = readString();
		System.out.println ("Name of the activity of the ride:");
		activityName = readString();
		System.out.println ("Name of the kid taking the activity:");
		kidName = readString();
		System.out.println ("Where does the ride start?");
		startPlace = readString();
		System.out.println ("Where does the ride end?");
		endPlace = readString();
		System.out.println ("When does the ride start?");
		start = askTime();
		System.out.println ("When does the ride end?");
		end = askTime();
		day = askWeekDay();
		ride = new Ride(start, end, startPlace, endPlace );
		this.blablakid.addRide(parentName, activityName, kidName, ride, day);
	}
	
	public void removeRide() throws BlaException {
		String parentName, rideStart, rideEnd;
		WeekDays day;
		System.out.println ("Name of the parent in charge of the ride:");
		parentName = readString();
		day = askWeekDay();
		System.out.println ("Where does the ride start?");
		rideStart = readString();
		System.out.println ("Where does the ride end?");
		rideEnd = readString();
		this.blablakid.removeRide(parentName, day, rideStart, rideEnd);
	}
	public Time askTime() throws BlaException {
		int hour, minute;
		System.out.println("\tInsert hour:"); 
		hour= Teclado.readInteger();
		System.out.println ("\tInsert minute:");
		minute = Teclado.readInteger();
		return new Time(hour, minute);
	}
	public String readString() throws BlaException {
		String name;
		do {
			name = Teclado.readString();
			if(name.trim().length() == 0) { //espacios en blanco
			System.out.println("Error: The field can not be empty. Input it again");
			}
		} while (name.trim().length() == 0);
		return name;
	} 
	public WeekDays askWeekDay() throws BlaException{
		WeekDays day = null;
		int number;
		System.out.println ("Insert the number of the day of the week:\n0 -Monday / 1-Tuesday / 2 -Wednesday / 3 -Thursday / 4 -Friday ");
		do {
			number = Teclado.readInteger();
			switch(number){
				case 0:
					day = WeekDays.MONDAY;
					break;
				case 1:
					day = WeekDays.TUESDAY;
					break;
				case 2:
					day = WeekDays.WEDNESDAY;
					break;
				case 3:
					day = WeekDays.THURSDAY;
					break;
				case 4:
					day = WeekDays.FRIDAY;
					break;
				default:
					System.out.println("Error: The number "+number+" is incorrect. Introduce a 0-4 number");			
			}
		} while (number>4 || number<0);
		return day;
	}
	public void showSummary() {
	//La opci�n de mostrar el resumen muestra por pantalla la informaci�n del estado de la aplicaci�n en todo momento y que coincide con lo que estamos mostrando cada vez que mostramos el men� principal
	System.out.println(this.blablakid.toString());
	}
	public void checkStatus() {
	//Esta opci�n deber� mostrar informaci�n sobre los trayectos que faltan por cubrir.
	System.out.println(this.blablakid.checkStatus());	
	}
}



